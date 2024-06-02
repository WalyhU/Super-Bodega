package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> getAllProveedores();
    Proveedor getProveedorById(Long id);
    Proveedor saveProveedor(Proveedor proveedor);
    Proveedor updateProveedor(Long id, Proveedor proveedor);
    void deleteProveedor(Long id);
}
