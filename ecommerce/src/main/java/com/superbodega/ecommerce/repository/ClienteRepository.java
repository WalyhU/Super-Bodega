package com.superbodega.ecommerce.repository;

import com.superbodega.ecommerce.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}