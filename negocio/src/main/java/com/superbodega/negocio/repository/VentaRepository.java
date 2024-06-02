package com.superbodega.negocio.repository;

import com.superbodega.negocio.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByClienteId(Long clienteId);
    List<Venta> findByFechaVentaBetween(Date fechaInicio, Date fechaFin);

    @Query("SELECT v FROM Venta v JOIN v.productos vp WHERE vp.producto.id = :productoId")
    List<Venta> findByProductoId(@Param("productoId") Long productoId);

    @Query("SELECT v FROM Venta v JOIN v.productos vp JOIN vp.producto p WHERE p.proveedor.id = :proveedorId")
    List<Venta> findByProveedorId(@Param("proveedorId") Long proveedorId);
}
