package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.Producto;
import co.edu.javeriana.cotizaciones.dto.ProductosWrapper;
import co.edu.javeriana.cotizaciones.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Productos {

    Logger logger = LoggerFactory.getLogger(Productos.class);

    @Autowired
    private ProductoRepository repository;



    @GetMapping("/productos")
    public String securedPage(Model model, Principal principal) {

        List<Producto> productos = repository.findAll();

        ProductosWrapper wrapper = new ProductosWrapper();

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
            wrapper.getProductos().add(tmp);
        }

        model.addAttribute("wrapper", wrapper);

        return "productos";
    }

    @PostMapping("/cotizaciones")
    public String delete(@ModelAttribute ProductosWrapper wrapper, Model model){
        logger.debug(" * * * * * * * * COTIZACIONES 1 * * * * * * * * * * * *");
        if(wrapper != null){
            logger.debug(" * * * * * * * * COTIZACIONES 2 * * * * * * * * * * * *");
            for (List<Producto> productos : wrapper.getProductos()) {
                logger.debug(" * * * * * * * * COTIZACIONES 3 * * * * * * * * * * * *");
                for(Producto producto : productos){
                    logger.debug(" * * * * * * * * COTIZACIONES 4 * * * * * * * * * * * *");
                    logger.debug(producto.getNombreProducto() + ": " + producto.isSeleccionado());
                }
            }
        }
        return "blank";
    }

}
