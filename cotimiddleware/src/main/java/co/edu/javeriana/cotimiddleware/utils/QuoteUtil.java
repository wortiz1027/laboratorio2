package co.edu.javeriana.cotimiddleware.utils;

import co.edu.javeriana.cotimiddleware.model.Cotizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class QuoteUtil {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteUtil.class);

    public static HttpEntity encapsulateRequet(final Cotizacion cotizacion) {
        LOG.info("Process.method.encapsulateRequet");
        //Configuramos el encabezado de la petició
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        //Creamos la entidad de solicitud con el cuerpo de la petición y el encabezado
        HttpEntity<Cotizacion> requestEntity = new HttpEntity<>(cotizacion, requestHeaders);

        return requestEntity;
    }

    public static HttpEntity encapsulateRequet(final List<Cotizacion> cotizaciones) {
        LOG.info("Process.method.encapsulateRequet");
        //Configuramos el encabezado de la petició
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        //Creamos la entidad de solicitud con el cuerpo de la petición y el encabezado
        HttpEntity<List<Cotizacion>> requestEntity = new HttpEntity<>(cotizaciones, requestHeaders);

        return requestEntity;
    }

    public static void asignarProveedor(final Cotizacion cotizacion, final String idProveedor) {
        cotizacion.getProductos().forEach(producto -> {
                                                        producto.getPrecios().get(0).setIdUser(new BigDecimal(idProveedor));
                                                       });
    }
}
