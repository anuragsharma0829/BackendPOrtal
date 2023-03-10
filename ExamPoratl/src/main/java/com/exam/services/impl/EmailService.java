package com.exam.services.impl;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService {

    public boolean Forgotpass(String subject, String to) throws MessagingException
//        code
    {
        boolean f = false;
        //Variable for gmail
        String host = "smtp.gmail.com";
        String from = "sharmaanurag0829@gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Step 1: to get the session object..
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sharmaanurag0829@gmail.com", "eyqymqimdjubooye");
            }


        });

        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);
        String htmlMsg = " Hello user' <br>"
                + ""
                + "Please use this Link to Reset Your Password " + " -> " +
                "<a href=\"http://localhost:4200/forgotPass/?email="+to+"\">Generate Password</a> <br>" +
                "Password is confidential, do not share this  with anyone.</body>";
        try {

            //from email
            m.setFrom(from);
            m.setContent(htmlMsg, "text/html");
            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);
            m.setSentDate(new Date());


            //adding text to message
            m.setText(htmlMsg);
            m.setContent(htmlMsg, "text/html");
            //send

            //Step 3 : send the message using Transport class
            Transport.send(m);

            System.out.println("Sent success...................");
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
