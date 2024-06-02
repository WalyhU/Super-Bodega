package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto getProductoById(Long id);
    Producto saveProducto(Producto producto);
    Producto updateProducto(Long id, Producto producto);
    void updateProductoStock(Long id, Integer cantidad);
    void deleteProducto(Long id);
}
