package com.seas.crudspringboot.interfaces;

import com.seas.crudspringboot.model.Producto;

import java.util.List;

public interface IProducto {

    public List<Producto> getProdctos();
    public Producto getProdctoId(Long id);
    public void addProducto(Producto producto);
    public void deleteProdcto(Long id);
}
