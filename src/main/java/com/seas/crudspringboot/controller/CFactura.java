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
        modelo.addAttribute("facturas", service.get());
        return "facturas";
    }

    @GetMapping("/facturas/detalles/{id}")
    public String getDetallesFactura(Model modelo, @PathVariable("id") Long id) {
        modelo.addAttribute("productos", service.detalles(id));
        return "detalles_factura";
    }
    @GetMapping("/facturas/borrar/{id}")
    public String deleteFactura(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/facturas";
    }

    @GetMapping("/tpv/{id}")
    public String getTPV(Model modelo, @PathVariable("id") Long id) {
        Factura factura = new Factura();
        factura.setEmpleado(serviceEmpleado.getId(id));
        factura.setProductos(serviceProducto.get());
        modelo.addAttribute("clientes", serviceCliente.get());
        modelo.addAttribute("factura", factura);
        return "tpv";
    }
    @PostMapping("/tpv/{id}")
    public String NewFactura(@ModelAttribute("factura") Factura factura) {
        factura.setEmpleado(serviceEmpleado.getId(factura.getEmpleado().getId()));
        factura.setCliente(serviceCliente.getId(factura.getCliente().getId()));
        factura.setId(null);
        factura.setProductos(service.productosFactura(factura));
        service.add(factura);
        return "redirect:/tpv/" + factura.getEmpleado().getId();
    }
}
