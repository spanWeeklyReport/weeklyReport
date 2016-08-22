package com.evry.dashboard.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
 
@Service("mailService")
public class ApplicationMailer 
{
    @Autowired
    private JavaMailSender  mailSender;
     
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
 
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to, String subject, String body) 
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
       // mailSender.send(message);
    }
 
    /**
     * This method will send a pre-configured message
     * */
    public void sendPreConfiguredMail(String message) 
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
    
    public void sendMimeMessage(String from, String to, String subject, String msg) throws Exception{
    	  MimeMessage mime = this.mailSender.createMimeMessage();
    	  MimeMessageHelper helper = new MimeMessageHelper(mime, true);
    	  helper.setFrom(from);
    	  helper.setTo(to);
    	  helper.setSubject(subject);
    	  String htmlText = "Hi,<br /><br />This is a gentle reminder from admin at the Evry Weekly Report to fill your Report "
    	  		+ "for this week.<br /><br />Regards"
    	  		+ "<br/>Evry Weeky Report";
    	    helper.setText(htmlText,true);
    	    this.mailSender.send(mime);
    	    }
    
    public void remindHr(String from, String to[], String subject, String msg) throws Exception{
  	  MimeMessage mime = this.mailSender.createMimeMessage();
  	  MimeMessageHelper helper = new MimeMessageHelper(mime, true);
  	  helper.setFrom(from);
  	  helper.setTo(to);
  	  helper.setSubject(subject);
  	  String htmlText = "Hi,<br /><br />Please share details on new career openings and HR trends.<br /><br/>"
  	  		+ "<table style='border:1px solid black'>"
  	  		+ "<tr><td colspan='3' style='background:lightgreen;border:1px solid black'>Resource Status &#8208; Apps Team (Monthly trend from HR)</td></tr>"
  	  		+ "<tr><td style='border:1px solid black; width:200px;'>Month</td><td style='border:1px solid black; width:200px;'>Decrease/Exit</td><td style='border:1px solid black; width:200px;'>Increase/New Joining</td></tr>"
  	  		+ "<tr><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "<tr><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "<tr><td style='border:1px solid black;'></td><td style='border:1px solid black'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "</table><br /><br /><br /><br />"
  	  		+ "<table style='border:1px solid black'>"
  	  		+ "<tr style='background:lightgreen;'><td style='border:1px solid black; width:100px;'></td><td style='border:1px solid black; width:100px;'>Technology</td><td style='border:1px solid black; width:100px;'>Project</td>"
  	  		+ "<td style='border:1px solid black; width:100px;'>Raised By</td><td style='border:1px solid black; width:100px;'>Career Openings</td><td style='border:1px solid black; width:100px;'>Open</td>"
  	  		+ "<td style='border:1px solid black; width:100px;'>Expected Closure Date</td></tr>"
  	  		+ "<tr><td style='border:1px solid black; width:100px;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "<tr><td style='border:1px solid black; width:100px;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "<tr><td style='border:1px solid black; width:100px;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td style='border:1px solid black;'><td></td></tr>"
  	  		+ "<tr><td style='border:1px solid black; width:100px;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "<tr><td style='border:1px solid black; width:100px;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "<tr><td style='border:1px solid black; width:100px;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td></tr>"
  	  		+ "</table><br /><br /><br /><br />"
  	  	    + "<table style='border:1px solid black'>"
	  		+ "<tr><td colspan='4' style='background:lightgreen;border:1px solid black'>Updates on Open Positions</td></tr>"
	  		+ "<tr><td style='border:1px solid black; width:150px;'>Project</td><td style='border:1px solid black; width:150px;'>Current Week</td><td style='border:1px solid black; width:150px;'>Last Week</td><td style='border:1px solid black;  width:150px;'>Comments</td></tr>"
	  		+ "<tr><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black'></td><td style='border:1px solid black'></td></tr>"
	  		+ "<tr><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'><td style='border:1px solid black'></td></td></tr>"
	  		+ "<tr><td style='border:1px solid black;'></td><td style='border:1px solid black;'></td><td style='border:1px solid black;'><td style='border:1px solid black'></td></td></tr>"
	  		+ "</table><br /><br /><br /><br />";
  	    helper.setText(htmlText,true);
  	    this.mailSender.send(mime);
  	    }
    	
    
}