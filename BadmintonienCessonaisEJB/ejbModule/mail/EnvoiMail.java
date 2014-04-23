package mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Singleton permettant la gestion des mails
 * @author g.joseph-mondesir
 *
 */
@Singleton
public class EnvoiMail {
	
	private String from;
	private String host;
	private Session session;
	private Log log = LogFactory.getLog(this.getClass());
	private final String NOM_PROP="mail.properties";

	@PostConstruct
	public void init(){
		initParam();
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		session = Session.getDefaultInstance(props, null);
	}
	

	public void sendMessage(String destinataire, String copie, String sujet, String contenu ){
		try {
			MimeMultipart mimeMultiPart = new MimeMultipart();
			
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(contenu);
			
			mimeMultiPart.addBodyPart(textBodyPart);
			
			
			MimeMessage msg = new MimeMessage(session);
			InternetAddress iaFrom = new InternetAddress(from);
			msg.setSender(iaFrom);
			msg.addRecipients(Message.RecipientType.TO, destinataire);
			if(copie != null && !"".equals(copie)){
				msg.addRecipients(Message.RecipientType.CC, copie);
			}
			
			msg.setSubject(sujet);
			msg.setContent(mimeMultiPart);
			Transport.send(msg);
		} catch (MessagingException e) {
			log.error("Impossible d'envoyer le mail");
		}
	}
	
	private void initParam(){
		Properties prop = new Properties();
		try (InputStream in = EnvoiMail.class.getResourceAsStream(NOM_PROP);){
			prop.load(in);
			host = prop.getProperty("host");
			from = prop.getProperty("from");
		}  catch (IOException e) {
			log.error("Impossible de charger les paramètres");;
		}
	}
}
