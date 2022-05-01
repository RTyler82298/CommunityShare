import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class Mail {


        public static void sendMail(String recipientemail, String postName, String selectorName, String selectorEmail, String posterName) {
            // Assuming you are sending email from localhost
            String host = "localhost";

            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);

            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties);

            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress("CommuntiyAPP@Gmail.com"));  //TODO Create this email

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientemail));

                // Set Subject: header field
                message.setSubject("Someone Has Selected one of your Posts!");

                // Now set the actual message
                message.setText("Hello" + posterName + ". " + selectorName + " has asked for your post " + posterName
                + ". Please reach out to them at " + selectorEmail + " at your convience to arrange.");

                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
    }

