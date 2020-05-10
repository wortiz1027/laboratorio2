package co.edu.javeriana.proveedor.controller;

import co.edu.javeriana.proveedor.model.Cotizacion;
import co.edu.javeriana.proveedor.utils.ProveedorUtil;

import java.util.Date;

public class CotizacionManagement {

    public static Cotizacion generarCotizacionAutomatica(Cotizacion cotizacion) {
        cotizacion.setFechaRespuesta(new Date(System.currentTimeMillis()));
        cotizacion.getProductos().forEach(producto -> {producto.setPrecio(ProveedorUtil.generarPrecio());});
        return cotizacion;
    }
}
