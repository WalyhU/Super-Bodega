package com.superbodega.ecommerce.service;

import com.superbodega.ecommerce.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Page<Producto> findAll(Pageable pageable);

    Page<Producto> findByCategoriaNombre(String categoria, Pageable pageable);
}
