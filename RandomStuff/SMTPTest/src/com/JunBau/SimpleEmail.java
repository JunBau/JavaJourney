package com.JunBau;

import java.util.Properties;

import javax.mail.Session;

public class SimpleEmail {

    public static void sendEmail() {

        // So, this didn't work from my ISP IP address. so had to try TLS... Hence why there is a TLS email class..

        System.out.println("SimpleEmail Start");

        String smtpHostServer = "outlook-com.olc.protection.outlook.com";
        String emailID = "phillip.alejo@outlook.com";

        Properties props = System.getProperties();

        props.put("outlook-com.olc.protection.outlook.com", smtpHostServer);

        Session session = Session.getInstance(props, null);

        EmailUtil.sendEmail(session, emailID,"This is a test", "HTML ting");
    }
}