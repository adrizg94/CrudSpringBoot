package com.seas.crudspringboot.repository;

import com.seas.crudspringboot.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REmpleado extends JpaRepository<Empleado, Long> {
}
