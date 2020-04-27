package co.edu.javeriana.securityserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInformation {
    @RequestMapping(
            value = "/user/me",
            produces = { "application/json"},
            method = RequestMethod.GET)
    public Principal user(Principal principal) {
        return principal;
    }
}
