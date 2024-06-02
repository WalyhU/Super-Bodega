package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.CompraProducto;
import com.superbodega.negocio.repository.CompraProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompraProductoServiceImpl implements CompraProductoService {
    @Autowired
    private CompraProductoRepository compraProductoRepository;

    @Autowired
    private ProductoService productoService;

    @Override
    public List<CompraProducto> getAllCompraProductos() {
        return compraProductoRepository.findAll();
    }

    @Override
    public CompraProducto getCompraProductoById(Long id) {
        return compraProductoRepository.findById(id).orElse(null);
    }

    @Override
    public CompraProducto saveCompraProducto(CompraProducto compraProducto) {
        productoService.updateProductoStock(compraProducto.getProducto().getId(), compraProducto.getCantidad());
        return compraProductoRepository.save(compraProducto);
    }

    @Override
    public CompraProducto updateCompraProducto(Long id, CompraProducto compraProducto) {
        // Se obtiene la compra producto actual
        CompraProducto compraProductoActual = compraProductoRepository.findById(id).orElse(null);
        if (compraProductoActual != null) {
            // Se actualiza el stock del producto
            productoService.updateProductoStock(compraProductoActual.getProducto().getId(), -compraProductoActual.getCantidad());
            productoService.updateProductoStock(compraProducto.getProducto().getId(), compraProducto.getCantidad());
            // Se actualiza la compra producto
            compraProductoActual.setId(compraProducto.getId());
            return compraProductoRepository.save(compraProductoActual);
        }
        return null;
    }

    @Override
    public void deleteCompraProducto(Long id) {
        CompraProducto compraProducto = compraProductoRepository.findById(id).orElse(null);
        if (compraProducto != null) {
            productoService.updateProductoStock(compraProducto.getProducto().getId(), -compraProducto.getCantidad());
            compraProductoRepository.deleteById(id);
        }
    }
}
