package com.seas.crudspringboot.repository;

import com.seas.crudspringboot.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFactura extends JpaRepository<Factura, Long> {
}
