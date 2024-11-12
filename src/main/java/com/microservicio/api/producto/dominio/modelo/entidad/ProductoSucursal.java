package com.microservicio.api.producto.dominio.modelo.entidad;

import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "producto_sucursal")
public class ProductoSucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductoSucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal idsucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public ProductoSucursal(Producto producto, Sucursal idsucursal, Integer stock, BigDecimal precioVenta) {
        this.producto = producto;
        this.idsucursal = idsucursal;
        this.stock = stock;
        this.precioVenta = precioVenta;
    }

    public void seteoIdProducto(Long idProducto) {
        this.producto = new Producto(idProducto);
    }

}
