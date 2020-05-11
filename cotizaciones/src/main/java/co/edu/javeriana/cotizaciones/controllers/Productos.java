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
        }

        model.addAttribute("wrapper", wrapper);
        model.addAttribute("productos", w);

        return "productos";
    }

    @RequestMapping(value = "/cotizaciones", method = RequestMethod.POST)
    public String contizar(@ModelAttribute("wrapper") ProductosWrapper wrapper, Model model){
        logger.debug(" * * * * * * * * COTIZACIONES 1 * * * * * * * * * * * *" + wrapper.getProductos().size());
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

    public ProductosWrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(ProductosWrapper wrapper) {
        this.wrapper = wrapper;
    }
}
