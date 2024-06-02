package com.superbodega.negocio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "El cliente es obligatorio")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de venta es obligatoria")
    private Date fechaVenta;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<VentaProducto> productos;

    private Long idPedido;
}
