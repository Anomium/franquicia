package com.microservicio.api.producto.infraestructura.controlador;

import com.microservicio.api.producto.aplicacion.comando.manejador.ManejadorListarProductosMayorStock;
import com.microservicio.api.producto.dominio.modelo.dto.DtoProducto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@ApiOperation("Controlador consulta producto")
public class ConsultaControladorProducto {

    private final ManejadorListarProductosMayorStock manejadorListarProductosMayorStock;


    public ConsultaControladorProducto(ManejadorListarProductosMayorStock manejadorListarProductosMayorStock) {
        this.manejadorListarProductosMayorStock = manejadorListarProductosMayorStock;
    }

    @GetMapping(value = "/{idFranquicia}")
    public List<DtoProducto> listarProductoMayorStockPorSucursal(@PathVariable String idFranquicia) {
        return this.manejadorListarProductosMayorStock.listar(idFranquicia);
    }
}
