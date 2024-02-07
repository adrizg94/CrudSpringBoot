package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.IServicio;
import com.seas.crudspringboot.model.Factura;
import com.seas.crudspringboot.model.Producto;
import com.seas.crudspringboot.repository.RFactura;
import com.seas.crudspringboot.repository.RProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class SFactura implements IServicio<Factura, Long> {

    @Autowired
    private RFactura repository;
    @Autowired
    private RProducto repositoryProducto;

    @Override
    public List<Factura> get() {
        return repository.findAll();
    }

    @Override
    public Factura getId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void add(Factura factura) {
        repository.save(factura);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> detalles(Long id) {
        List<Producto> productosBD = getId(id).getProductos();
        List<Producto> productos = new ArrayList<>();

        for (Producto producto: productosBD) {
            if (productos.contains(producto)) {
                int cant = productos.get(productos.indexOf(producto)).getStock() + 1;
                producto.setStock(cant);
                controlDecimal(producto);
                productos.set(productos.indexOf(producto), producto);
            } else {
                producto.setStock(1);
                controlDecimal(producto);
                productos.add(producto);
            }
        }
        return productos;
    }

    public void controlDecimal(Producto producto) {
        float precio = producto.getPrecio() * producto.getStock();
        NumberFormat df = NumberFormat.getNumberInstance(Locale.UK);
        df.setMaximumFractionDigits(2);
        producto.setDescripcion(df.format(precio));
    }

    public ArrayList<Producto> productosFactura(Factura factura) {

        List<Producto> productosBD = repositoryProducto.findAll();
        ArrayList<Producto> listaFactura = new ArrayList<>();

        for (int i=0; i<productosBD.size(); i++) {
            int stockBD = productosBD.get(i).getStock();
            int stockFactura = factura.getProductos().get(i).getStock();
            boolean update = false;
            while (stockBD != stockFactura) {
                update = true;
                listaFactura.add(repositoryProducto.findById(productosBD.get(i).getId()).get());
                stockBD--;
            }
            if (update) {
                Long id = factura.getProductos().get(i).getId();
                int stock = factura.getProductos().get(i).getStock();
                Producto producto = repositoryProducto.findById(id).get();
                producto.setStock(stock);
                repositoryProducto.save(producto);
            }
        }
        return listaFactura;
    }
}
