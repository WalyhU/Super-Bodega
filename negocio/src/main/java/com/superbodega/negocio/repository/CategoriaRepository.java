package com.superbodega.negocio.repository;

import com.superbodega.negocio.entity.Categoria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Categoria c SET c.nombre = ?2 WHERE c.id = ?1")
    void updateCategoria(Long id, String categoria);
}
