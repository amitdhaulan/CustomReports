package reporting;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingMailWithHTMLContent {
	public void sendMail() {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "false");
			props.put("mail.smtp.ssl.enable", "true");

			Session session = Session.getInstance(props, new EmailAuth());
			Message msg = new MimeMessage(session);

			InternetAddress from = new InternetAddress("fromAddress", "UserName");
			msg.setFrom(from);

			InternetAddress toAddress = new InternetAddress("toAddress");

			msg.setRecipient(Message.RecipientType.TO, toAddress);

			msg.setSubject("Test");
			msg.setContent("<html>\r\n" + "<head>\r\n" + "<!--\r\n" + "<body>"
					+ "<font size=\"2 \"font face=\"verdana\" color=\"green\">This site is hacked! You can't get anything from here!</font>\r\n"
					+ "          <h5>Hack done by Amit Kumar</h1>\r\n" + "" + "</body>" + "</html>\r\n" + "",
					"text/html");
			Transport.send(msg);
			System.out.println("Mail sent");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

	static class EmailAuth extends Authenticator {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("fromAddress", "password");
		}
	}

	public static void main(String[] args) {
		SendingMailWithHTMLContent content = new SendingMailWithHTMLContent();
		content.sendMail();
	}
}
