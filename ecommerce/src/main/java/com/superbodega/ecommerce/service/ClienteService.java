package com.superbodega.ecommerce.service;

import com.superbodega.ecommerce.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    Cliente update(Long id, Cliente cliente);

    void deleteById(Long id);
}
