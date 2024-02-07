package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.IServicio;
import com.seas.crudspringboot.model.Empleado;
import com.seas.crudspringboot.repository.REmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SEmpleado implements IServicio<Empleado, Long> {

    @Autowired
    private REmpleado repository;

    @Override
    public List<Empleado> get() {
        return repository.findAll();
    }

    @Override
    public Empleado getId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void add(Empleado empleado) {
        repository.save(empleado);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
