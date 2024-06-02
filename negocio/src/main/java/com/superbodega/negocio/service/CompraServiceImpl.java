package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Compra;
import com.superbodega.negocio.entity.CompraProducto;
import com.superbodega.negocio.entity.Producto;
import com.superbodega.negocio.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    CompraProductoService compraProductoService;

    @Override
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Compra getCompraById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Override
    public Compra saveCompra(Compra compra) {
        for (CompraProducto compraProducto : compra.getProductos()) {
            Producto producto = productoService.getProductoById(compraProducto.getProducto().getId());
            if (producto == null) {
                return null;
            }
            if (producto.getStock() < compraProducto.getCantidad()) {
                return null;
            }
            producto.setStock(producto.getStock() - compraProducto.getCantidad());
            productoService.saveProducto(producto);
            compraProductoService.saveCompraProducto(compraProducto);
        }
        Compra newCompra = compraRepository.save(compra);
        newCompra.getProductos().forEach(compraProducto -> compraProducto.setCompra(newCompra));
        return newCompra;
    }

    @Override
    public void deleteCompra(Long id) {
        Compra compra = getCompraById(id);
        if (compra != null) {
            compraRepository.delete(compra);
        }
    }

    @Override
    public List<Compra> getComprasByFecha(Date fechaInicio, Date fechaFin) {
        return compraRepository.findByFechaCompraBetween(fechaInicio, fechaFin);
    }
}
