package com.seas.crudspringboot.interfaces;

import com.seas.crudspringboot.model.Empleado;

import java.util.List;

public interface IEmpleado {

    public List<Empleado> getEmpleados();

    public Empleado getEmpleadoId(Long id);

    public void addEmpleado(Empleado empleado);

    public void deleteEmpleado(Long id);



}
