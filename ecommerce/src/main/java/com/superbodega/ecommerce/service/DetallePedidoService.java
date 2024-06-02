package com.superbodega.ecommerce.service;

import com.superbodega.ecommerce.entity.DetallePedido;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {

    List<DetallePedido> findAll();

    Optional<DetallePedido> findById(Long id);

    DetallePedido save(DetallePedido detallePedido);

    void deleteById(Long id);
}