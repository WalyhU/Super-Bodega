package com.superbodega.negocio.repository;

import com.superbodega.negocio.entity.Categoria;
import com.superbodega.negocio.entity.Producto;
import com.superbodega.negocio.entity.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Producto p SET p.nombre = :nombre, p.descripcion = :descripcion, p.precio = :precio, p.stock = :stock, p.categoria = :categoria, p.proveedor = :proveedor WHERE p.id = :id")
    void updateProducto(Long id, String nombre, String descripcion, Double precio, Integer stock, Categoria categoria, Proveedor proveedor);
}
