package com.superbodega.ecommerce.controller;

import com.superbodega.ecommerce.entity.Producto;
import com.superbodega.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<Page<Producto>> getAllProductos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String categoria) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Producto> productos;

        if (categoria != null) {
            productos = productoService.findByCategoriaNombre(categoria, pageable);
        } else {
            productos = productoService.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
        }

        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}
