package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.CompraProducto;

import java.util.List;

public interface CompraProductoService {
    List<CompraProducto> getAllCompraProductos();
    CompraProducto getCompraProductoById(Long id);
    CompraProducto saveCompraProducto(CompraProducto compraProducto);
    CompraProducto updateCompraProducto(Long id, CompraProducto compraProducto);
    void deleteCompraProducto(Long id);
}
