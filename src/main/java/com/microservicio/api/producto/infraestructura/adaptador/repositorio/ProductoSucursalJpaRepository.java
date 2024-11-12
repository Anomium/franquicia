package com.microservicio.api.producto.infraestructura.adaptador.repositorio;

import com.microservicio.api.producto.dominio.modelo.entidad.ProductoSucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoSucursalJpaRepository extends JpaRepository<ProductoSucursal, Long> {

    @Query(value = "UPDATE PRODUCTO_SUCURSAL PS SET PS.STOCK = :stock " +
            "WHERE PS.ID_SUCURSAL = :idSucursal AND PS.ID_PRODUCTO = :idProducto", nativeQuery = true)
    void actualizarPorStock(@Param("idSucursal") Long idSucursal,
                            @Param("idProducto") Long idProducto,
                            @Param("stock") Integer stock);


    @Modifying
    @Query(value = "DELETE FROM producto_sucursal ps WHERE ps.id_producto = :idProducto", nativeQuery = true)
    void eliminar(@Param("idProducto") Long idProducto);


}
