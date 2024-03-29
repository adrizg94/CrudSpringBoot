package com.seas.crudspringboot.repository;

import com.seas.crudspringboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCliente extends JpaRepository<Cliente, Long> {
}
