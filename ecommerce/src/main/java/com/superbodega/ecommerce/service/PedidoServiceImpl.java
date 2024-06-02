package com.superbodega.ecommerce.service;

import com.superbodega.ecommerce.entity.Pedido;
import com.superbodega.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl  implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private KafkaTemplate<String, Pedido> kafkaTemplate;

    private static final String TOPIC = "ventas";

    public void sendPedido(Pedido pedido) {
        kafkaTemplate.send(TOPIC, pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        pedido.setFecha(new Date());
        Pedido pedidoSaved = pedidoRepository.save(pedido);
        sendPedido(pedidoSaved);
        return pedidoSaved;
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> findByFechaBetween(Date fechaInicio, Date fechaFin) {
        return pedidoRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

    @Override
    public List<Pedido> findByClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Pedido> findByProductoId(Long productoId) {
        return pedidoRepository.findByDetallesProductoId(productoId);
    }
}
