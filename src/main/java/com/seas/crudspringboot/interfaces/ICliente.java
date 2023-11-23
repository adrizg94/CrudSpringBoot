package com.seas.crudspringboot.interfaces;

import com.seas.crudspringboot.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ICliente {

    public List<Cliente> getClientes();

    public Cliente getClienteId(Long id);

    public void addCliente(Cliente cliente);

    public void deleteCliente(Long id);

}
