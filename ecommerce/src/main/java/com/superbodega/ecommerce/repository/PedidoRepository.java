package com.superbodega.ecommerce.repository;

import com.superbodega.ecommerce.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByFechaBetween(Date fechaInicio, Date fechaFin);

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByDetallesProductoId(Long productoId);
}
