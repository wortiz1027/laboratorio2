package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.PrecioProveedor;
import co.edu.javeriana.cotizaciones.dto.Producto;
import co.edu.javeriana.cotizaciones.repository.PrecioProveedorRepository;
import co.edu.javeriana.cotizaciones.utils.EMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0")
public class Cotizacion {

    Logger logger = LoggerFactory.getLogger(Productos.class);

    @Autowired
    private PrecioProveedorRepository precioRepository;

    @Autowired
    private EMail mail;

    @PostMapping("/cotizaciones/precios")
    public ResponseEntity<Void> cotizaciones(@RequestBody(required = true) List<co.edu.javeriana.cotizaciones.dto.Cotizacion> cotizaciones){

        logger.debug("* * * * * * * * * * * * COTIZACION - PRECIO *  * * * * * * * * * " + cotizaciones.size());

        for(co.edu.javeriana.cotizaciones.dto.Cotizacion c : cotizaciones) {
            logger.debug("* * * * * * * * * * * * ID_COTIZACION       : " + c.getIdCotizacion());
            logger.debug("* * * * * * * * * * * * ID_USER             : " + c.getIdUser());
            logger.debug("* * * * * * * * * * * * FECHA_COTIZACION    :" + c.getFechaCotizacion());
            logger.debug("* * * * * * * * * * * * FECHA_RESPUESTA     :" + c.getFechaRespuesta());

            for (Producto p : c.getProductos()) {
                logger.debug("* * * * * * * * * * * * ID_PRODUCTO     : " + p.getIdProducto());
                logger.debug("* * * * * * * * * * * * ID_CATALOGO     : " + p.getIdCatalogo());
                logger.debug("* * * * * * * * * * * * NOMBRE_PRODUCTO : " + p.getNombreProducto());
                logger.debug("* * * * * * * * * * * * DESC_PRODUCTO   : " + p.getDescripcionProducto());
                logger.debug("* * * * * * * * * * * * TIPO_PRODUCTO   : " + p.getTipoProducto());
                logger.debug("* * * * * * * * * * * * SELECCIONADO    : " + p.getSelected());

                for (PrecioProveedor precio : p.getPrecios()) {
                    logger.debug("* * * * * * * * * * * * ID_PROVEEDOR : " + precio.getIdPrecioProveedor());
                    logger.debug("* * * * * * * * * * * * ID_PRODUCTO  : " + precio.getIdProducto());
                    logger.debug("* * * * * * * * * * * * ID_USER      : " + precio.getIdUser());
                    logger.debug("* * * * * * * * * * * * PRECIO       : " + precio.getPrecio());
                    logger.debug("---");

                    precio.setIdProducto(p.getIdProducto());
                    precio.setIdUser(c.getIdUser());

                    precioRepository.crearPrecioProveedor(precio);

                }
                logger.debug("--- ---");
            }
            logger.debug("--- --- ---");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
