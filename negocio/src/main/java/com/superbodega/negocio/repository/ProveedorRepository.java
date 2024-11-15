package com.superbodega.negocio.repository;

import com.superbodega.negocio.entity.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Proveedor p SET p.nombre = :nombre, p.email = :email WHERE p.id = :id")
    void updateProveedor(Long id, String nombre, String email);
}
