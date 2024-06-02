package com.superbodega.negocio.repository;

import com.superbodega.negocio.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByFechaCompraBetween(Date fechaInicio, Date fechaFin);
}
