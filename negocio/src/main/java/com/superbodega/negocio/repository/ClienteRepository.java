package com.superbodega.negocio.repository;

import com.superbodega.negocio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClienteByCodigo(String codigo);
}
