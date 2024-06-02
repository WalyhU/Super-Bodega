package com.superbodega.ecommerce.service;

import com.superbodega.ecommerce.entity.Pedido;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findAll();

    Optional<Pedido> findById(Long id);

    Pedido save(Pedido pedido);

    void deleteById(Long id);

    List<Pedido> findByFechaBetween(Date fechaInicio, Date fechaFin);

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByProductoId(Long productoId);
}
