package co.edu.javeriana.securityserver.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {

    public static void main(String[] args) {
        SecureRandom random = null;
        String clientId = "Colombia2020";
        //String clientId = "8de6d4c46d616eb4c358ba6f63bb54dc";

        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //String pass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+-.;";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        //for (int i = 0; i < 3; i++)
        System.out.println("Hash {} --> " + encoder.encode(clientId));

        /*List<String> s = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");

        List<List<String>> ss = new ArrayList<>();

        int valor = (s.size() / 3) + 1;

        int corte = 0;

        for (int i = 0; i < valor; i++) {

            List<String> tmp = new ArrayList<>();

            for (int j = corte; j < s.size(); j++) {
                if (tmp.size() < 3) {
                    System.out.println(s.get(j));
                    tmp.add(s.get(j));
                }
            }

            corte = corte + 3;
            System.out.println("----" + corte);
            ss.add(tmp);
        }

        for (List<String> l : ss) {
            //System.out.println("----");
            for (String s1 : l) {
              //  System.out.println("" + s1);
            }

        }

        System.out.println("FIN " + ss.size());*/

    }

}
