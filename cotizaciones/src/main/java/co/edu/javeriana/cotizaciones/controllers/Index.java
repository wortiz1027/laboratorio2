package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.Producto;
import co.edu.javeriana.cotizaciones.dto.ProductosWrapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
public class Index {

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView ("redirect:/login?logout");
    }

    /*@GetMapping("/register")
    public String register(Model model){
        return "register";
    }*/

    /*@RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //User user = userService.findUserByUserName(auth.getName());
        //modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        //modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        //modelAndView.setViewName("admin/home");
        return modelAndView;
    }*/

}