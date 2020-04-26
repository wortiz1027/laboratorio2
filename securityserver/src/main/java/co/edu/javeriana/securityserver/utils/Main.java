package co.edu.javeriana.securityserver.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {

    public static void main(String[] args) {
        SecureRandom random = null;
        //String clientId = "seguridad";
        String clientId = "8de6d4c46d616eb4c358ba6f63bb54dc";

        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //String pass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+-*/.;";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        //for (int i = 0; i < 3; i++)
        System.out.println("Hash {} --> " + encoder.encode(clientId));
    }


}
