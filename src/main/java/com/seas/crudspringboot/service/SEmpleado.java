package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.IEmpleado;
import com.seas.crudspringboot.model.Empleado;
import com.seas.crudspringboot.repository.REmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SEmpleado implements IEmpleado {

    @Autowired
    private REmpleado repository;

    @Override
    public List<Empleado> getEmpleados() {return repository.findAll();}

    @Override
    public Empleado getEmpleadoId(Long id) {return repository.findById(id).get();}

    @Override
    public void addEmpleado(Empleado empleado) {repository.save(empleado);}

    @Override
    public void deleteEmpleado(Long id) {repository.deleteById(id);}

}
