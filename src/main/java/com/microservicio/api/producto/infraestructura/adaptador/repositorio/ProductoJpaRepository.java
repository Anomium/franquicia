package com.microservicio.api.producto.infraestructura.adaptador.repositorio;

import com.microservicio.api.producto.dominio.modelo.dto.DtoProducto;
import com.microservicio.api.producto.dominio.modelo.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoJpaRepository extends JpaRepository<Producto, Long> {

    boolean existsByNombre(String nombre);

    @Modifying
    @Query(value = "UPDATE producto p SET p.nombre = :nuevoNombre WHERE p.id_producto = :idProducto", nativeQuery = true)
    void actualizarPorNombre(@Param("idProducto") Long idProducto,
                            @Param("nuevoNombre") String nuevoNombre);

    @Query(value = "SELECT \n" +
            "    p.nombre AS nombreProducto,\n" +
            "    s.nombre AS nombreSucursal,\n" +
            "    ps.stock,\n" +
            "    ps.precio_venta AS precioVenta\n" +
            "FROM sucursal s\n" +
            "INNER JOIN producto_sucursal ps ON s.id_sucursal = ps.id_sucursal\n" +
            "INNER JOIN producto p ON ps.id_producto = p.id_producto\n" +
            "WHERE s.id_franquicia = :idFranquicia\n" +
            "AND ps.stock = (\n" +
            "    SELECT MAX(ps2.stock)\n" +
            "    FROM producto_sucursal ps2\n" +
            "    INNER JOIN sucursal s2 ON ps2.id_sucursal = s2.id_sucursal\n" +
            "    WHERE s2.id_sucursal = s.id_sucursal\n" +
            ")\n" +
            "ORDER BY s.nombre;", nativeQuery = true)
    List<Object[]> listarProductoMayorStockPorSucursal(@Param("idFranquicia") String idFranquicia);

    @Query(value = "DELETE FROM producto_sucursal WHERE id_producto_sucursal = :idProducto", nativeQuery = true)
    void eliminar(@Param("idProducto") Long idProducto);
}
