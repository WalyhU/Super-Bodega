package com.superbodega.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @NotNull
    @Positive
    private Integer cantidad;
}
