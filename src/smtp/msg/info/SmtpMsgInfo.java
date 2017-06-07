package smtp.msg.info;

import java.util.Properties;

import javax.mail.MessagingException;

public class SmtpMsgInfo {
	// SMTP info
	public static String host = "smtp.gmail.com";
	public static String port = "587";
	public static String mailFrom = "";
	public static String password = "";

	// message info
	public static String mailTo = "";
	public static String subject = "New email with attachments from eclipse";
	public static String message = "I have some attachments for you.";

	public static Properties properties;

	public static String[] attachFiles;

	public static void setProperties() throws MessagingException {

		// sets SMTP server properties
		properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", mailFrom);
		properties.put("mail.password", password);

	}

	public static String[] getAttachments() {
		// attachments
		attachFiles = new String[1];
		attachFiles[0] = "D:\\amit\\Java_programs\\StartingWindowsApplication\\extentReportFile.html";
/*		attachFiles[1] = "D:\\amit\\Java_programs\\Selenium_DatabaseTtesting\\test-output\\testng.css";
		attachFiles[2] = "D:\\amit\\Java_programs\\Selenium_DatabaseTtesting\\test-output\\index.html";
		attachFiles[3] = "D:\\amit\\Java_programs\\Selenium_DatabaseTtesting\\test-output\\testng.css";
		attachFiles[4] = "D:\\amit\\Java_programs\\CustomReports\\extentReportFile.html";
*/		return attachFiles;

	}
}