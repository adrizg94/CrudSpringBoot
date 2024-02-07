package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.IServicio;
import com.seas.crudspringboot.model.Producto;
import com.seas.crudspringboot.repository.RProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class SProducto implements IServicio<Producto, Long> {

    @Autowired
    private RProducto repository;

    @Override
    public List<Producto> get() {
        return repository.findAll();
    }

    @Override
    public Producto getId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void add(Producto producto) {
        repository.save(producto);
    }

    public void addImagen(Producto producto, MultipartFile imagen) {
        Path directorioImg = Paths.get("src//main//resources//static/images");
        Path rutaImg = Paths.get(directorioImg.toFile().getAbsolutePath() + "//" + imagen.getOriginalFilename());

        try {
            byte[] byteImg = imagen.getBytes();
            Files.write(rutaImg, byteImg);
            producto.setImagen(imagen.getOriginalFilename());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
