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

import java.util.ArrayList;
import java.util.List;

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
            while (stockBD != stockFactura) {
                listaFactura.add(serviceProducto.getProdctoId(listaProductos.get(i).getId()));
                stockBD--;
            }
        }

        factura.setProductos(listaFactura);
        service.addFactura(factura);
        return "redirect:/tpv/" + factura.getEmpleado().getId();
    }
}
