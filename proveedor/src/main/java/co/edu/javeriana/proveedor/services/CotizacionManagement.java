package co.edu.javeriana.proveedor.services;

import co.edu.javeriana.proveedor.model.Cotizacion;
import co.edu.javeriana.proveedor.model.PrecioProveedor;
import co.edu.javeriana.proveedor.utils.ProveedorUtil;

import java.util.Date;

public class CotizacionManagement {

    public static Cotizacion generarCotizacionAutomatica(Cotizacion cotizacion) {
        cotizacion.setFechaRespuesta(new Date(System.currentTimeMillis()));
        cotizacion.getProductos().forEach(producto -> {
                                                        final PrecioProveedor precioProveedor = new PrecioProveedor();
                                                        precioProveedor.setPrecio(ProveedorUtil.generarPrecio());
                                                        precioProveedor.setIdProducto(producto.getIdProducto());
                                                        producto.getPrecios().add(precioProveedor);
                                                      });
        return cotizacion;
    }
}