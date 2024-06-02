package com.superbodega.negocio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompraProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @NotNull(message = "El producto es obligatorio")
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    @NotNull(message = "La compra es obligatoria")
    @JsonBackReference
    @JsonIgnore
    private Compra compra;
}
