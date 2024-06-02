package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.VentaProducto;
import java.util.List;

public interface VentaProductoService {
    List<VentaProducto> getAllVentaProductos();
    VentaProducto getVentaProductoById(Long id);
    VentaProducto saveVentaProducto(VentaProducto ventaProducto);
    void deleteVentaProducto(Long id);
}
