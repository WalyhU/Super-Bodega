package com.superbodega.negocio.controller;

import com.superbodega.negocio.entity.Venta;
import com.superbodega.negocio.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.getAllVentas();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        Venta venta = ventaService.getVentaById(id);
        if (venta == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Venta> saveVenta(@RequestBody Venta venta) {
        try {
            Venta savedVenta = ventaService.saveVenta(venta);
            return new ResponseEntity<>(savedVenta, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byCliente/{clienteId}")
    public ResponseEntity<List<Venta>> getVentasByCliente(@PathVariable Long clienteId) {
        List<Venta> ventas = ventaService.getVentasByCliente(clienteId);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/byFecha")
    public ResponseEntity<List<Venta>> getVentasByFecha(@RequestParam Date fechaInicio, @RequestParam Date fechaFin) {
        List<Venta> ventas = ventaService.getVentasByFecha(fechaInicio, fechaFin);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/byProducto/{productoId}")
    public ResponseEntity<List<Venta>> getVentasByProducto(@PathVariable Long productoId) {
        List<Venta> ventas = ventaService.getVentasByProducto(productoId);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/byProveedor/{proveedorId}")
    public ResponseEntity<List<Venta>> getVentasByProveedor(@PathVariable Long proveedorId) {
        List<Venta> ventas = ventaService.getVentasByProveedor(proveedorId);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }
}
