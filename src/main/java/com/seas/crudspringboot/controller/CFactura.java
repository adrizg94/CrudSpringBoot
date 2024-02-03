package com.seas.crudspringboot.controller;

import com.seas.crudspringboot.model.*;
import com.seas.crudspringboot.service.SCliente;
import com.seas.crudspringboot.service.SEmpleado;
import com.seas.crudspringboot.service.SFactura;
import com.seas.crudspringboot.service.SProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class CFactura {

    @Autowired
    private SFactura service;
    @Autowired
    private SProducto serviceProducto;
    @Autowired
    private SEmpleado serviceEmpleado;
    @Autowired
    private SCliente serviceCliente;

    @GetMapping("/facturas")
    public String getFacturas(Model modelo) {
        modelo.addAttribute("facturas", service.getFacturas());
        return "facturas";
    }

    @GetMapping("/facturas/detalles/{id}")
    public String getDetallesFactura(Model modelo, @PathVariable("id") Long id) {

        List<Producto> productosBD = service.getFacturaId(id).getProductos();
        List<Producto> productos = new ArrayList<>();

        for (int i=0; i<productosBD.size(); i++) {
            productosBD.get(i).setStock(1);
        }
        for (int i=0; i<productosBD.size(); i++) {
            Producto productoBD = productosBD.get(i);
            if (productos.contains(productoBD)) {
                int cant = productos.get(productos.indexOf(productoBD)).getStock() + 1;
                productoBD.setStock(cant);
                productos.set(productos.indexOf(productoBD), productoBD);
            } else {
                productos.add(productoBD);
            }
        }
        for (int i=0; i<productos.size(); i++) {
            float precio = productos.get(i).getPrecio() * productos.get(i).getStock();
            NumberFormat df = NumberFormat.getNumberInstance(Locale.UK);
            df.setMaximumFractionDigits(2);
            productos.get(i).setDescripcion(df.format(precio));
        }

        modelo.addAttribute("productos", productos);
        return "detalles_factura";
    }
    @GetMapping("/facturas/borrar/{id}")
    public String deleteFactura(@PathVariable("id") Long id) {
        service.deleteFactura(id);
        return "redirect:/facturas";
    }

    @GetMapping("/tpv/{id}")
    public String getTPV(Model modelo, @PathVariable("id") Long id) {
        Factura factura = new Factura();
        factura.setProductos(serviceProducto.getProdctos());
        modelo.addAttribute("productos", serviceProducto.getProdctos());
        modelo.addAttribute("clientes", serviceCliente.getClientes());
        modelo.addAttribute("factura", factura);
        modelo.addAttribute("empleadoId", id);
        return "tpv";
    }
    @PostMapping("/tpv/{id}")
    public String NewFactura(@ModelAttribute("factura") Factura factura) {
        factura.setEmpleado(serviceEmpleado.getEmpleadoId(factura.getEmpleado().getId()));
        factura.setCliente(serviceCliente.getClienteId(factura.getCliente().getId()));
        factura.setPrecio(factura.getPrecio());
        factura.setId(null);

        List<Producto> listaProductos = serviceProducto.getProdctos();
        List<Producto> listaFactura = new ArrayList<Producto>();

        for (int i=0; i<listaProductos.size(); i++) {
            int stockBD = listaProductos.get(i).getStock();
            int stockFactura = factura.getProductos().get(i).getStock();
            boolean update = false;
            while (stockBD != stockFactura) {
                update = true;
                listaFactura.add(serviceProducto.getProdctoId(listaProductos.get(i).getId()));
                stockBD--;
            }
            if (update) {
                Long id = factura.getProductos().get(i).getId();
                int stock = factura.getProductos().get(i).getStock();
                Producto producto = serviceProducto.getProdctoId(id);
                producto.setStock(stock);
                serviceProducto.addProducto(producto);
            }
        }

        factura.setProductos(listaFactura);
        service.addFactura(factura);
        return "redirect:/tpv/" + factura.getEmpleado().getId();
    }
}
