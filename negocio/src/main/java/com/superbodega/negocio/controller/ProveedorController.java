package com.superbodega.negocio.controller;

import com.superbodega.negocio.entity.Proveedor;
import com.superbodega.negocio.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        List<Proveedor> proveedores = proveedorService.getAllProveedores();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.getProveedorById(id);
        if (proveedor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proveedor> saveProveedor(@RequestBody Proveedor proveedor) {
        try {
            Proveedor savedProveedor = proveedorService.saveProveedor(proveedor);
            return new ResponseEntity<>(savedProveedor, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        try {
            proveedorService.updateProveedor(id, proveedor);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
