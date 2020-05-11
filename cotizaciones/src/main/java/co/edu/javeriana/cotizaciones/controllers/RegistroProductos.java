package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.*;
import co.edu.javeriana.cotizaciones.repository.CatalogoRepository;
import co.edu.javeriana.cotizaciones.repository.PrecioProveedorRepository;
import co.edu.javeriana.cotizaciones.repository.ProductoRepository;
import co.edu.javeriana.cotizaciones.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Controller
public class RegistroProductos {

    Logger logger = LoggerFactory.getLogger(RegistroProductos.class);

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PrecioProveedorRepository precioProveedorRepository;

    @GetMapping("/registroProductos")
    public String securedPage(Model model, Principal principal) {
        WrapperProducto wrapperProducto = new WrapperProducto();
        wrapperProducto.setProducto(new Producto());
        wrapperProducto.setPrecio(new BigDecimal(0));

        Users usuario = usersRepository.findUsersByUserName(principal.getName()).orElseThrow();

        logger.info("usuario id: {}", usuario.getIdUser());
        List<Catalogo> catalogos = catalogoRepository.findCatalogoByIdUser(usuario.getIdUser());

        model.addAttribute("catalogos", catalogos);
        model.addAttribute("wrapperProducto", wrapperProducto);

        return "registroProductos";
    }

    @PostMapping("/registrarProducto")
    public String registrar(@ModelAttribute("wrapperProducto") WrapperProducto producto, Model model, Principal principal) {

        if (producto != null) {
            Users usuario = usersRepository.findUsersByUserName(principal.getName()).orElseThrow();
            logger.info("producto: {}", producto.getProducto().getNombreProducto());
            int idProducto = productoRepository.crearProducto(producto.getProducto());
            if (producto.getPrecio() != null) {
                PrecioProveedor precioProveedor = new PrecioProveedor();
                precioProveedor.setIdProducto(new BigDecimal(idProducto));
                precioProveedor.setIdUser(usuario.getIdUser());
                precioProveedor.setPrecio(producto.getPrecio());
                precioProveedorRepository.crearPrecioProveedor(precioProveedor);
            }
        }

        return "successPage";
    }
}
