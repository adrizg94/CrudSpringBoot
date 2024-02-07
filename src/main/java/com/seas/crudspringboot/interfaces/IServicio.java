package com.seas.crudspringboot.interfaces;

import com.seas.crudspringboot.model.Cliente;

import java.util.List;

public interface IServicio<E, I> {

    public List<E> get();

    public E getId(I id);

    public void add(E bean);

    public void delete(I id);

}
