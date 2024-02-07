package com.seas.crudspringboot.controller;

import com.seas.crudspringboot.model.Empleado;
import com.seas.crudspringboot.service.SEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CEmpleado {

    @Autowired
    private SEmpleado service;

    @GetMapping("/empleados")
    public String getEmpleados(Model modelo) {
        modelo.addAttribute("empleados", service.get());
        return "empleados";
    }

    @GetMapping("/empleados/nuevo")
    public String getNewEmpleado(Model modelo) {
        modelo.addAttribute("empleado", new Empleado());
        return "nuevo_empleado";
    }

    @PostMapping("/empleados/nuevo")
    public String NewEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        service.add(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String getUpdateEmpleado(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("empleado", service.getId(id));
        return "editar_empleado";
    }

    @PostMapping("/empleados/editar/{id}")
    public String updateEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        service.add(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/borrar/{id}")
    public String deleteEmpleado(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/empleados";
    }
}
