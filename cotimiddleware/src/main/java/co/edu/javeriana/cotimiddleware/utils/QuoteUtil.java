package co.edu.javeriana.cotimiddleware.utils;

import co.edu.javeriana.cotimiddleware.model.Cotizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

public final class QuoteUtil {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteUtil.class);

    public static HttpEntity encapsulateRequet(Cotizacion cotizacion) {
        LOG.info("Process.method.encapsulateRequet");
        //Configuramos el encabezado de la petició
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        //Creamos la entidad de solicitud con el cuerpo de la petición y el encabezado
        HttpEntity<Cotizacion> requestEntity = new HttpEntity<>(cotizacion, requestHeaders);

        return requestEntity;
    }
}
