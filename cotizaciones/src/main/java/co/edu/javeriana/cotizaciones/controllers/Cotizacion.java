package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.*;
import co.edu.javeriana.cotizaciones.repository.CatalogoRepository;
import co.edu.javeriana.cotizaciones.repository.PrecioProveedorRepository;
import co.edu.javeriana.cotizaciones.repository.UsersRepository;
import co.edu.javeriana.cotizaciones.utils.EMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0")
public class Cotizacion {

    Logger logger = LoggerFactory.getLogger(Productos.class);

    @Autowired
    private PrecioProveedorRepository precioRepository;

    @Autowired
    private EMail mail;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private CatalogoRepository catalogoRepository;

    private String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
            "    <meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0;\" />\n" +
            "    <!--[if !mso]--><!-- -->\n" +
            "    <link href='https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,600,700' rel=\"stylesheet\">\n" +
            "    <link href='https://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel=\"stylesheet\">\n" +
            "    <!-- <![endif]-->\n" +
            "\n" +
            "    <title>Material Design for Bootstrap</title>\n" +
            "\n" +
            "    <style type=\"text/css\">\n" +
            "        body {\n" +
            "            width: 100%;\n" +
            "            background-color: #ffffff;\n" +
            "            margin: 0;\n" +
            "            padding: 0;\n" +
            "            -webkit-font-smoothing: antialiased;\n" +
            "            mso-margin-top-alt: 0px;\n" +
            "            mso-margin-bottom-alt: 0px;\n" +
            "            mso-padding-alt: 0px 0px 0px 0px;\n" +
            "        }\n" +
            "\n" +
            "        p,\n" +
            "        h1,\n" +
            "        h2,\n" +
            "        h3,\n" +
            "        h4 {\n" +
            "            margin-top: 0;\n" +
            "            margin-bottom: 0;\n" +
            "            padding-top: 0;\n" +
            "            padding-bottom: 0;\n" +
            "        }\n" +
            "\n" +
            "        span.preheader {\n" +
            "            display: none;\n" +
            "            font-size: 1px;\n" +
            "        }\n" +
            "\n" +
            "        html {\n" +
            "            width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        table {\n" +
            "            font-size: 14px;\n" +
            "            border: 0;\n" +
            "        }\n" +
            "        /* ----------- responsivity ----------- */\n" +
            "\n" +
            "        @media only screen and (max-width: 640px) {\n" +
            "            /*------ top header ------ */\n" +
            "            .main-header {\n" +
            "                font-size: 20px !important;\n" +
            "            }\n" +
            "            .main-section-header {\n" +
            "                font-size: 28px !important;\n" +
            "            }\n" +
            "            .show {\n" +
            "                display: block !important;\n" +
            "            }\n" +
            "            .hide {\n" +
            "                display: none !important;\n" +
            "            }\n" +
            "            .align-center {\n" +
            "                text-align: center !important;\n" +
            "            }\n" +
            "            .no-bg {\n" +
            "                background: none !important;\n" +
            "            }\n" +
            "            /*----- main image -------*/\n" +
            "            .main-image img {\n" +
            "                width: 440px !important;\n" +
            "                height: auto !important;\n" +
            "            }\n" +
            "            /* ====== divider ====== */\n" +
            "            .divider img {\n" +
            "                width: 440px !important;\n" +
            "            }\n" +
            "            /*-------- container --------*/\n" +
            "            .container590 {\n" +
            "                width: 440px !important;\n" +
            "            }\n" +
            "            .container580 {\n" +
            "                width: 400px !important;\n" +
            "            }\n" +
            "            .main-button {\n" +
            "                width: 220px !important;\n" +
            "            }\n" +
            "            /*-------- secions ----------*/\n" +
            "            .section-img img {\n" +
            "                width: 320px !important;\n" +
            "                height: auto !important;\n" +
            "            }\n" +
            "            .team-img img {\n" +
            "                width: 100% !important;\n" +
            "                height: auto !important;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media only screen and (max-width: 479px) {\n" +
            "            /*------ top header ------ */\n" +
            "            .main-header {\n" +
            "                font-size: 18px !important;\n" +
            "            }\n" +
            "            .main-section-header {\n" +
            "                font-size: 26px !important;\n" +
            "            }\n" +
            "            /* ====== divider ====== */\n" +
            "            .divider img {\n" +
            "                width: 280px !important;\n" +
            "            }\n" +
            "            /*-------- container --------*/\n" +
            "            .container590 {\n" +
            "                width: 280px !important;\n" +
            "            }\n" +
            "            .container590 {\n" +
            "                width: 280px !important;\n" +
            "            }\n" +
            "            .container580 {\n" +
            "                width: 260px !important;\n" +
            "            }\n" +
            "            /*-------- secions ----------*/\n" +
            "            .section-img img {\n" +
            "                width: 280px !important;\n" +
            "                height: auto !important;\n" +
            "            }\n" +
            "        }\n" +
            "    </style>\n" +
            "    <!-- [if gte mso 9]><style type=”text/css”>\n" +
            "        body {\n" +
            "        font-family: arial, sans-serif!important;\n" +
            "        }\n" +
            "        </style>\n" +
            "    <![endif]-->\n" +
            "</head>\n" +
            "\n" +
            "\n" +
            "<body class=\"respond\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" +
            "    <!-- pre-header -->\n" +
            "    <table style=\"display:none!important;\">\n" +
            "        <tr>\n" +
            "            <td>\n" +
            "                <div style=\"overflow:hidden;display:none;font-size:1px;color:#ffffff;line-height:1px;font-family:Arial;maxheight:0px;max-width:0px;opacity:0;\">\n" +
            "                    Pre-header for the newsletter template\n" +
            "                </div>\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "    </table>\n" +
            "    <!-- pre-header end -->\n" +
            "    <!-- header -->\n" +
            "    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\">\n" +
            "\n" +
            "        <tr>\n" +
            "            <td align=\"center\">\n" +
            "                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td align=\"center\">\n" +
            "\n" +
            "                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
            "\n" +
            "                                <tr>\n" +
            "                                    <td align=\"center\" height=\"70\" style=\"height:70px;\">\n" +
            "                                        <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"100\" border=\"0\" style=\"display: block; width: 100px;\" src=\"https://mdbootstrap.com/img/logo/mdb-email.png\" alt=\"\" /></a>\n" +
            "                                    </td>\n" +
            "                                </tr>\n" +
            "\n" +
            "                                <tr>\n" +
            "                                    <td align=\"center\">\n" +
            "                                        <table width=\"360 \" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" +
            "                                            class=\"container590 hide\">\n" +
            "                                            <tr>\n" +
            "                                                <td width=\"120\" align=\"center\" style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" +
            "                                                    <a href=\"\" style=\"color: #312c32; text-decoration: none;\">Hombre</a>\n" +
            "                                                </td>\n" +
            "                                                <td width=\"120\" align=\"center\" style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" +
            "                                                    <a href=\"\" style=\"color: #312c32; text-decoration: none;\">Mujer</a>\n" +
            "                                                </td>\n" +
            "                                                <td width=\"120\" align=\"center\" style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" +
            "                                                    <a href=\"\" style=\"color: #312c32; text-decoration: none;\">BLOG</a>\n" +
            "                                                </td>\n" +
            "                                            </tr>\n" +
            "                                        </table>\n" +
            "                                    </td>\n" +
            "                                </tr>\n" +
            "                            </table>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                </table>\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "    </table>\n" +
            "    <!-- end header -->\n" +
            "\n" +
            "    <!-- big image section -->\n" +
            "    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\n" +
            "\n" +
            "        <tr>\n" +
            "            <td align=\"center\">\n" +
            "                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
            "                    <tr>\n" +
            "\n" +
            "                        <td align=\"center\" class=\"section-img\">\n" +
            "                            <a href=\"\" style=\" border-style: none !important; display: block; border: 0 !important;\"><img src=\"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/img%20(59).jpg\" style=\"display: block; width: 590px;\" width=\"590\" border=\"0\" alt=\"\" /></a>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td align=\"center\" style=\"color: #343434; font-size: 24px; font-family: Quicksand, Calibri, sans-serif; font-weight:700;letter-spacing: 3px; line-height: 35px;\"\n" +
            "                            class=\"main-header\">\n" +
            "\n" +
            "\n" +
            "                            <div style=\"line-height: 35px\">\n" +
            "\n" +
            "                                NUEVO EN <span style=\"color: #5caad2;\">JUNIO - JULIO</span>\n" +
            "\n" +
            "                            </div>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td align=\"center\">\n" +
            "                            <table border=\"0\" width=\"40\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"eeeeee\">\n" +
            "                                <tr>\n" +
            "                                    <td height=\"2\" style=\"font-size: 2px; line-height: 2px;\">&nbsp;</td>\n" +
            "                                </tr>\n" +
            "                            </table>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td align=\"center\">\n" +
            "                            <table border=\"0\" width=\"400\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
            "                                <tr>\n" +
            "                                    <td align=\"center\" style=\"color: #888888; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" +
            "\n" +
            "\n" +
            "                                        <div style=\"line-height: 24px\">\n" +
            "\n" +
            "                                            El verano se aproxima cambia tu ropa.\n" +
            "                                        </div>\n" +
            "                                    </td>\n" +
            "                                </tr>\n" +
            "                            </table>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td align=\"center\">\n" +
            "                            <table border=\"0\" align=\"center\" width=\"160\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"5caad2\" style=\"\">\n" +
            "\n" +
            "                                <tr>\n" +
            "                                    <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" +
            "                                </tr>\n" +
            "\n" +
            "                                <tr>\n" +
            "                                    <td align=\"center\" style=\"color: #ffffff; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 26px;\">\n" +
            "\n" +
            "\n" +
            "                                        <div style=\"line-height: 26px;\">\n" +
            "                                            <a href=\"\" style=\"color: #ffffff; text-decoration: none;\">Comprar Ahora!</a>\n" +
            "                                        </div>\n" +
            "                                    </td>\n" +
            "                                </tr>\n" +
            "\n" +
            "                                <tr>\n" +
            "                                    <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" +
            "                                </tr>\n" +
            "\n" +
            "                            </table>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "\n" +
            "\n" +
            "                </table>\n" +
            "\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "\n" +
            "        <tr class=\"hide\">\n" +
            "            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "            <td height=\"40\" style=\"font-size: 40px; line-height: 40px;\">&nbsp;</td>\n" +
            "        </tr>\n" +
            "\n PRODUCTOS" +
            "    </table>\n" +
            "    <!-- end section -->\n" +
            "</body>\n" +
            "\n" +
            "</html>";


    @PostMapping("/cotizaciones/precios")
    public ResponseEntity<Void> cotizaciones(@RequestBody(required = true) List<co.edu.javeriana.cotizaciones.dto.Cotizacion> cotizaciones) throws MessagingException {

        logger.debug("* * * * * * * * * * * * COTIZACION - PRECIO *  * * * * * * * * * " + cotizaciones.size());

        BigDecimal idUsuario = new BigDecimal(0);

        List<ReporteCotizaciones> lista = new ArrayList<>();

        String body  = "";
        String html2 = "";

        for(co.edu.javeriana.cotizaciones.dto.Cotizacion c : cotizaciones) {

            idUsuario = c.getIdUser();
            body = body + "Codigo Cotizacion: " + c.getIdCotizacion()    + "\n";
            body = body + "Fecha cotizacion : " + c.getFechaCotizacion() + "\n";
            BigDecimal pp = new BigDecimal(0);
            for (Producto p : c.getProductos()) {

                Catalogo cat = catalogoRepository.findCatalogoByIdCatalogo(p.getIdCatalogo()).get();

                body = body + "\t\t Catalogo      : " + cat.getNombreCatalogo() + "\n";
                body = body + "\t\t\t Producto    : " + p.getNombreProducto() + "\n";
                body = body + "\t\t\t Descripcion : " + p.getDescripcionProducto() + "\n";

                html2 = html2 + "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\">\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">\n" +
                        "                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
                        "\n" +
                        "                    <tr>\n" +
                        "                        <td>\n" +
                        "                            <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" +
                        "                                class=\"container590\">\n" +
                        "\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td align=\"center\">\n" +
                        "                                        <a href=\"\" style=\" border-style: none !important; border: 0 !important;\"><img src=\"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/img%20(34).jpg\" style=\"display: block; width: 280px;\" width=\"280\" border=\"0\" alt=\"\" /></a>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "                            </table>\n" +
                        "\n" +
                        "                            <table border=\"0\" width=\"5\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" +
                        "                                class=\"container590\">\n" +
                        "                                <tr>\n" +
                        "                                    <td width=\"5\" height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\n" +
                        "                                </tr>\n" +
                        "                            </table>\n" +
                        "\n" +
                        "                            <table border=\"0\" width=\"260\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" +
                        "                                class=\"container590\">\n" +
                        "                                <tr>\n" +
                        "                                    <td align=\"left\" style=\"color: #3d3d3d; font-size: 22px; font-family: Quicksand, Calibri, sans-serif; font-weight:700;letter-spacing: 3px; line-height: 35px;\"\n" +
                        "                                        class=\"align-center main-header\">\n" +
                        "\n" +
                        "\n" +
                        "                                        <div style=\"line-height: 35px\">\n" +
                        "\n" +
                        "                                            "+ p.getNombreProducto()  +"\n" +
                        "\n" +
                        "                                        </div>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td height=\"15\" style=\"font-size: 12px; line-height: 12px;\">&nbsp;</td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td align=\"left\">\n" +
                        "                                        <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
                        "                                            <tr>\n" +
                        "                                                <td align=\"center\">\n" +
                        "                                                    <table align=\"center\" width=\"40\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"eeeeee\">\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td height=\"2\" style=\"font-size: 2px; line-height: 2px;\"></td>\n" +
                        "                                                        </tr>\n" +
                        "                                                    </table>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td height=\"15\" style=\"font-size: 12px; line-height: 12px;\">&nbsp;</td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td align=\"left\" style=\"color: #888888; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\"\n" +
                        "                                        class=\"align-center\">\n" +
                        "\n" +
                        "\n" +
                        "                                        <div style=\"line-height: 24px\">\n" +
                        "\n" +
                        "                                         Catalgo : "+ cat.getNombreCatalogo()  +"\n" +
                        "                                         Precio : "+ pp  +"\n" +
                        "\n" +
                        "                                        </div>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td align=\"left\">\n" +
                        "                                        <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
                        "                                            <tr>\n" +
                        "                                                <td align=\"center\">\n" +
                        "                                                    <table border=\"0\" align=\"center\" width=\"120\" cellpadding=\"0\" cellspacing=\"0\" style=\"border: 1px solid #eeeeee; \">\n" +
                        "\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td height=\"5\" style=\"font-size: 5px; line-height: 5px;\">&nbsp;</td>\n" +
                        "                                                        </tr>\n" +
                        "\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td align=\"center\" style=\"color: #5caad2; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 20px;\">\n" +
                        "\n" +
                        "\n" +
                        "                                                                <div style=\"line-height: 20px;\">\n" +
                        "                                                                    <a href=\"\" style=\"color: #5caad2; text-decoration: none;\">READ MORE</a>\n" +
                        "                                                                </div>\n" +
                        "                                                            </td>\n" +
                        "                                                        </tr>\n" +
                        "\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td height=\"8\" style=\"font-size: 8px; line-height: 8px;\">&nbsp;</td>\n" +
                        "                                                        </tr>\n" +
                        "\n" +
                        "                                                    </table>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                            </table>\n" +
                        "\n" +
                        "                        </td>\n" +
                        "                    </tr>\n" +
                        "\n" +
                        "                </table>\n" +
                        "            </td>\n" +
                        "        </tr>\n" +
                        "\n" +
                        "        <tr>\n" +
                        "            <td height=\"40\" style=\"font-size: 40px; line-height: 40px;\">&nbsp;</td>\n" +
                        "        </tr>\n" +
                        "\n" +
                        "    </table>";

                for (PrecioProveedor precio : p.getPrecios()) {
                    precio.setIdProducto(p.getIdProducto());
                    precio.setIdUser(c.getIdUser());

                    precioRepository.crearPrecioProveedor(precio);

                    int descuento = (int) (Math.random()*25+1);
                    pp = precio.getPrecio();
                    body = body + "\t\t\t Valor Unitario : " + precio.getPrecio() + "\n";
                    body = body + "\t\t\t Descuento      : " + descuento + "%" + "\n";
                }
                //logger.debug("--- ---");
            }
            //logger.debug("--- --- ---");
        }
        Users usuario = userRepository.findUsersById(idUsuario).get();

        mail.sendEmail(usuario.getEmail(), "Cotizaciones", html.replaceAll("PRODUCTOS", html2));

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
