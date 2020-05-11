package co.edu.javeriana.cotizaciones.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EMail {

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(String to, String subject, String content) throws MessagingException {

        /*SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        sender.send(message);*/

        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        //String htmlMsg = "<h3>Hello World!</h3>";
//mimeMessage.setContent(htmlMsg, "text/html"); /** Use this or below line **/
        helper.setText(content, true); // Use this or above line.
        helper.setTo(to);
        helper.setSubject(subject);
        //helper.setFrom("abc@gmail.com");
        sender.send(mimeMessage);

    }

}