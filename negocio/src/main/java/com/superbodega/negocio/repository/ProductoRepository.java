package com.superbodega.negocio.repository;

import com.superbodega.negocio.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
