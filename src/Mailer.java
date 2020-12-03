import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
class Mailer{  
    public static void send(String to,String sub,String msg){  
    	String from = "jonkur96@gmail.com";
    	String password = "i don't have passcode"; 
    	Properties props = new Properties();    
    	props.put("mail.smtp.host", "smtp.gmail.com");    
    	props.put("mail.smtp.socketFactory.port", "465");    
    	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.port", "465"); 
    	
    	Session session = Session.getDefaultInstance(props,    
    		new javax.mail.Authenticator() {    
    			protected PasswordAuthentication getPasswordAuthentication() {    
    				return new PasswordAuthentication(from,password);
    			}
    		});
    	try {    
    		MimeMessage message = new MimeMessage(session);    
    		message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    		message.setSubject(sub);
    		message.setText(msg); 

    		Transport.send(message);
    		
    	} catch (MessagingException e) {
    		e.printStackTrace();
    	}    
    }  
}  