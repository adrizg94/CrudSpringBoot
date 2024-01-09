package com.seas.crudspringboot.repository;

import com.seas.crudspringboot.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REmpleado extends JpaRepository<Empleado, Long> {
}
