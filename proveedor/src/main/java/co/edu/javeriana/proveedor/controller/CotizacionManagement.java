package co.edu.javeriana.proveedor.controller;

import co.edu.javeriana.proveedor.model.Cotizacion;
import co.edu.javeriana.proveedor.utils.ProveedorUtil;

public class CotizacionManagement {
    public static Cotizacion generarCotizacionAutomatica(Cotizacion cotizacion) {
        cotizacion.getProductos().forEach(producto -> {producto.setPrecio(ProveedorUtil.generarPrecio());});
        return cotizacion;
    }
}
