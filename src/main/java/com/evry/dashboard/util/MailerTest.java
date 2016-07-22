package com.evry.dashboard.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
 
public class MailerTest {
 
    public static void main(String[] args) 
    {
        //Create the application context
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
         
        //Get the mailer instance
        ApplicationMailer mailer = (ApplicationMailer) context.getBean("mailService");
 
        //Send a composed mail
        mailer.sendMail("somebody@gmail.com", "Test Subject", "Testing body");
 
        //Send a pre-configured mail
        mailer.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
    }
}
