package com.JunBau;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmail {

    public static void tlsEmail(String fromAddress, String password, String toAddress, String body, String subject) {

        // Credentials for authentication. Currently only for Gmail...
        final String fromEmail = fromAddress;
        final String pass = password;

        final String toEmail = toAddress;

        System.out.println("TLS Email start.");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, pass);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail,subject, body);

        // Right now javax.mail seems to be handling a lot of the stuff.. Would like to create my own socket operations
        // and the negotiation between servers, such as the ehlo, and helo's.

    }


}
