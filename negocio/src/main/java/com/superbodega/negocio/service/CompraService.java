package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Compra;
import java.util.Date;
import java.util.List;

public interface CompraService {
    List<Compra> getAllCompras();
    Compra getCompraById(Long id);
    Compra saveCompra(Compra compra);
    void deleteCompra(Long id);
    List<Compra> getComprasByFecha(Date fechaInicio, Date fechaFin);
}
