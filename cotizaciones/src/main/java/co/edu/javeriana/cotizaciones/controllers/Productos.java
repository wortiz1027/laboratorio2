package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.Cotizacion;
import co.edu.javeriana.cotizaciones.dto.Producto;
import co.edu.javeriana.cotizaciones.dto.ProductosWrapper;
import co.edu.javeriana.cotizaciones.repository.CotizacionRepository;
import co.edu.javeriana.cotizaciones.repository.ProductoRepository;
import co.edu.javeriana.cotizaciones.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class Productos {

    Logger logger = LoggerFactory.getLogger(Productos.class);

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private CotizacionRepository cotizacionRepository;

    @Autowired
    private UsersRepository usersRepository;

    ProductosWrapper wrapper = new ProductosWrapper();

    @GetMapping("/productos")
    public String securedPage(Model model, Principal principal) {
        List<Producto> productos = repository.findAll();
        List<List<Producto>> w = new ArrayList<>();

        int tamanio = (productos.size() / 3) + 1;
        int corte = 0;

        for (int i = 0; i < tamanio; i++) {

            List<Producto> tmp = new ArrayList<>();
            for (int j = corte; j < productos.size(); j++) {
                if (tmp.size() < 3) {
                    tmp.add(productos.get(j));
                }
            }

            corte = corte + 3;
            w.add(tmp);
            wrapper.getProductos().add(tmp);
        }

        model.addAttribute("wrapper", wrapper);
        model.addAttribute("productos", w);

        return "productos";
    }

    @RequestMapping(value = "/cotizaciones", method = RequestMethod.POST)
    public String cotizar(@ModelAttribute("wrapper") ProductosWrapper wrapper, Model model, Principal principal){
        final String uri = "http://localhost:8080/middleware/api/v1.0/enviarCotizacion";

        BigDecimal idUser = usersRepository.findUsersByUserName(principal.getName()).get().getIdUser();

        Cotizacion cotizacion = new Cotizacion();

        cotizacion.setIdUser(idUser);
        cotizacion.setFechaCotizacion(new Date());
        cotizacion.setFechaRespuesta(new Date());

        int idCotizacion = cotizacionRepository.crearCotizacion(cotizacion);

        logger.debug(" * * * * * * *  ID_COTIZACION * * * * * * * " + idCotizacion + " - " + wrapper.getProductos().size());

        cotizacion.setIdCotizacion(new BigDecimal(idCotizacion));

        int index = 0;

        for(List<Producto> productos : this.wrapper.getProductos()) {
            for(Producto producto : productos) {
                if (index < 5) {
                    if (producto.getIdCatalogo().equals(new BigDecimal(1))) {
                        producto.setSelected(Boolean.TRUE);
                        cotizacion.getProductos().add(producto);
                    }

                    if (producto.getIdCatalogo().equals(new BigDecimal(2))) {
                        producto.setSelected(Boolean.TRUE);
                        cotizacion.getProductos().add(producto);
                    }

                }
                index++;
            }
        }

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, cotizacion, Cotizacion.class);

        return "successPage";
    }

    public ProductosWrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(ProductosWrapper wrapper) {
        this.wrapper = wrapper;
    }
}