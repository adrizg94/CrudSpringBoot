package com.seas.crudspringboot.controller;

import com.seas.crudspringboot.model.Producto;
import com.seas.crudspringboot.service.SProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class CProducto {

    @Autowired
    private SProducto service;
    @GetMapping("/productos")
    public String getProductos(Model modelo) {
        modelo.addAttribute("productos", service.get());
        return "productos";
    }
    @GetMapping("/productos/nuevo")
    public String getNewProducto(Model modelo) {
        modelo.addAttribute("producto", new Producto());
        return "nuevo_producto";
    }
    @PostMapping("productos/nuevo")
    public String newProducto(@ModelAttribute("producto") Producto producto, @RequestParam("file") MultipartFile imagen) {
        service.addImagen(producto, imagen);
        service.add(producto);
        return "redirect:/productos";
    }
    @GetMapping("productos/editar/{id}")
    public String getUpdateProducto(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("producto", service.getId(id));
        return "editar_producto";
    }
    @PostMapping("/productos/editar/{id}")
    public String updateProducto(@ModelAttribute("producto") Producto producto, @RequestParam("file") MultipartFile imagen) {
        service.addImagen(producto, imagen);
        service.add(producto);
        return "redirect:/productos";
    }
    @GetMapping("/productos/borrar/{id}")
    public String deleteProducto(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/productos";
    }

}
