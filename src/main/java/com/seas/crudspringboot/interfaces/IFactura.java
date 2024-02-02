package com.seas.crudspringboot.interfaces;

import com.seas.crudspringboot.model.Factura;

import java.util.List;

public interface IFactura {

    public List<Factura> getFacturas();

    public Factura getFacturaId(Long id);

    public void addFactura(Factura factura);

    public void deleteFactura(Long id);
}
