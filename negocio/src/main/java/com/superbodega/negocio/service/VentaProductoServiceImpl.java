package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.VentaProducto;
import com.superbodega.negocio.repository.VentaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaProductoServiceImpl implements VentaProductoService {
    @Autowired
    private VentaProductoRepository ventaProductoRepository;

    @Override
    public List<VentaProducto> getAllVentaProductos() {
        return ventaProductoRepository.findAll();
    }

    @Override
    public VentaProducto getVentaProductoById(Long id) {
        return ventaProductoRepository.findById(id).orElse(null);
    }

    @Override
    public VentaProducto saveVentaProducto(VentaProducto ventaProducto) {
        return ventaProductoRepository.save(ventaProducto);
    }

    @Override
    public void deleteVentaProducto(Long id) {
        ventaProductoRepository.deleteById(id);
    }
}
