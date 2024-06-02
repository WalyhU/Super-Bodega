package com.superbodega.negocio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @NotNull
    @Positive
    private Integer cantidad;

    @NotNull
    @Positive
    private BigDecimal precio;
}
