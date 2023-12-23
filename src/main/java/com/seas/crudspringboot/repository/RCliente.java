package com.seas.crudspringboot.repository;

import com.seas.crudspringboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RCliente extends JpaRepository<Cliente, Long> {
    
}
