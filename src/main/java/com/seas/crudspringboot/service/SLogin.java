package com.seas.crudspringboot.service;

import com.seas.crudspringboot.model.Empleado;
import com.seas.crudspringboot.repository.REmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SLogin {

    @Autowired
    REmpleado repository;

    public boolean login(Empleado empleado) {

        boolean log = false;
        List<Empleado> empleados = repository.findAll();

        for (Empleado empleadoBD:empleados) {
            if (empleadoBD.getDni().equals(empleado.getDni()) &&
                    empleadoBD.getPassword().equals(empleado.getPassword())) {
                log = true;
                empleado.setId(empleadoBD.getId());
                break;
            }
        }
        return log;
    }
}
