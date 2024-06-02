package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Producto;
import com.superbodega.negocio.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id);
            return productoRepository.save(producto);
        }
        return null;
    }

    @Override
    public void updateProductoStock(Long id, Integer cantidad) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setStock(producto.getStock() + cantidad);
            productoRepository.save(producto);
        }
    }

    @Override
    public void deleteProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        }
    }
}
