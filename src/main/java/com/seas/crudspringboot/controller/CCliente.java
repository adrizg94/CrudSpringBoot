package com.seas.crudspringboot.controller;

import com.seas.crudspringboot.interfaces.ICliente;
import com.seas.crudspringboot.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CCliente {

    @Autowired
    private ICliente service;

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/clientes")
    public String getClientes(Model modelo) {
        modelo.addAttribute("clientes", service.getClientes());
        return "clientes";
    }

    @GetMapping("/clientes/nuevo")
    public String getNewCliente(Model modelo) {
        modelo.addAttribute("cliente", new Cliente());
        return "nuevo_cliente";
    }

    @PostMapping("/clientes")
    public String addCliente(@ModelAttribute("cliente") Cliente cliente) {
        service.addCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String getUpdateCliente(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("cliente", service.getClienteId(id));
        return "editar_cliente";
    }

    @PostMapping("/clientes/{id}")
    public String updateCliente(@ModelAttribute("cliente") Cliente cliente) {
        service.addCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String deleteCliente(@PathVariable("id") Long id) {
        service.deleteCliente(id);
        return "redirect:/clientes";
    }

}
