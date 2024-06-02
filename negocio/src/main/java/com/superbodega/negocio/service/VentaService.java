package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Venta;
import java.util.Date;
import java.util.List;

public interface VentaService {
    List<Venta> getAllVentas();
    Venta getVentaById(Long id);
    Venta saveVenta(Venta venta);
    void deleteVenta(Long id);
    List<Venta> getVentasByCliente(Long clienteId);
    List<Venta> getVentasByFecha(Date fechaInicio, Date fechaFin);
    List<Venta> getVentasByProducto(Long productoId);
    List<Venta> getVentasByProveedor(Long proveedorId);
}
