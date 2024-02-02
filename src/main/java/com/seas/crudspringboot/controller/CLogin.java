package com.seas.crudspringboot.controller;

import com.seas.crudspringboot.model.Empleado;
import com.seas.crudspringboot.service.SEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CLogin {

    @Autowired
    SEmpleado service;
    @GetMapping(value = {"/","/index"})
    public String getIndex(Model modelo) {
        modelo.addAttribute("user", new Empleado());
        return "index";
    }
    @PostMapping("/index")
    public String login(@ModelAttribute("user") Empleado empleado) {
        List<Empleado> empleados = service.getEmpleados();
        boolean log = false;
        Long newId = null;
        for (int i=0; i<empleados.size(); i++) {
            if (empleado.getDni().equals(empleados.get(i).getDni()) && empleado.getPassword().equals(empleados.get(i).getPassword())) {
                newId = empleados.get(i).getId();
                log = true;
                break;
            }
        }
        if (log) {
            return "redirect:/tpv/" + newId;
        } else {
            return "redirect:/bad_login";
        }
    }
    @GetMapping("/bad_login")
    public String badLogin() {
        return "bad_login";
    }
}
