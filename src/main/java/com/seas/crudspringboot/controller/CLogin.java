package com.seas.crudspringboot.controller;

import com.seas.crudspringboot.model.Empleado;
import com.seas.crudspringboot.service.SEmpleado;
import com.seas.crudspringboot.service.SLogin;
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
    SLogin service;

    @GetMapping(value = {"/","/index"})
    public String getIndex(Model modelo) {
        modelo.addAttribute("user", new Empleado());
        return "index";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute("user") Empleado empleado) {

        if (service.login(empleado)) {
            return "redirect:/tpv/" + empleado.getId();
        } else {
            return "redirect:/bad_login";
        }
    }

    @GetMapping("/bad_login")
    public String badLogin() {
        return "bad_login";
    }
}
