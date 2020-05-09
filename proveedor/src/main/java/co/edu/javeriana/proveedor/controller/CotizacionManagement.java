package co.edu.javeriana.proveedor.controller;

import co.edu.javeriana.proveedor.model.Cotizacion;
import co.edu.javeriana.proveedor.utils.ProveedorUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
public class CotizacionManagement {

    @GetMapping("/cotizaciones/{nombre}")
    public ResponseEntity<String> saludo(@PathVariable("nombre") String nombre) {

        return new ResponseEntity<String>("Hola mundo " + nombre, HttpStatus.OK);
    }

    public static Cotizacion generarCotizacionAutomatica(Cotizacion cotizacion) {
        cotizacion.getProductos().forEach(producto -> {producto.setPrecio(ProveedorUtil.generarPrecio());});
        return cotizacion;
    }
}
