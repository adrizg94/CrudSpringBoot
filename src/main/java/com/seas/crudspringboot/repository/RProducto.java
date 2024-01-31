package com.seas.crudspringboot.repository;

import com.seas.crudspringboot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProducto extends JpaRepository<Producto, Long> {
}
