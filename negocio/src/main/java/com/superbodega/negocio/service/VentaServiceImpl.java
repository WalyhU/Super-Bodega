package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Pedido;
import com.superbodega.negocio.entity.Producto;
import com.superbodega.negocio.entity.Venta;
import com.superbodega.negocio.entity.VentaProducto;
import com.superbodega.negocio.repository.ProductoRepository;
import com.superbodega.negocio.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @KafkaListener(topics = "ventas", groupId = "group_id")
    public void recibirPedidoComoVenta(Pedido pedido) {
        Venta venta = new Venta();
        venta.setFechaVenta(pedido.getFecha());
        venta.setIdPedido(pedido.getId());

        List<VentaProducto> ventaProductos = pedido.getDetalles().stream().map(detalle -> {
            VentaProducto ventaProducto = new VentaProducto();
            ventaProducto.setProducto(productoRepository.findById(detalle.getProducto().getId()).orElse(null));
            ventaProducto.setCantidad(detalle.getCantidad());
            return ventaProducto;
        }).collect(Collectors.toList());

        venta.setProductos(ventaProductos);

        ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Venta saveVenta(Venta venta) {
        // Validar y actualizar el stock de los productos
        for (VentaProducto vp : venta.getProductos()) {
            Producto producto = productoRepository.findById(vp.getProducto().getId()).orElse(null);
            if (producto != null && producto.getStock() >= vp.getCantidad()) {
                producto.setStock(producto.getStock() - vp.getCantidad());
                productoRepository.save(producto);
            } else {
                throw new IllegalArgumentException("Stock insuficiente para el producto: " + producto.getNombre());
            }
        }
        return ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Venta no encontrada");
        }
    }

    @Override
    public List<Venta> getVentasByCliente(Long clienteId) {
        return ventaRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Venta> getVentasByFecha(Date fechaInicio, Date fechaFin) {
        return ventaRepository.findByFechaVentaBetween(fechaInicio, fechaFin);
    }

    @Override
    public List<Venta> getVentasByProducto(Long productoId) {
        return ventaRepository.findByProductoId(productoId);
    }

    @Override
    public List<Venta> getVentasByProveedor(Long proveedorId) {
        return ventaRepository.findByProveedorId(proveedorId);
    }
}
