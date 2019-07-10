package Email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * CLASSE QUE ENVIA O E-MAIL
 * @author willi
 *
 */
public class EnviaEmail {

	/**
	 * CRIA UMA SESSÃO DE E-MAIL NO GMAIL
	 * @return RETORNA UMA SESSÃO DE EMAIL
	 */
	private Session criarSessionMail() {
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", 465);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.port", 465);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("onchangefmk@gmail.com", "willian25");
			}
		});

		// session.setDebug(true);

		return session;
	}

	/**
	 * MÉTODO DE ENVIAR E-MAIL
	 * @param tipo PARÂMETRO QUE PEGA O TIPO PARA FAZER A VERIFICAÇÃO
	 * @throws AddressException EXCESSÃO DE ERRO
	 * @throws MessagingException EXCESSÃO DE ERRO
	 */
	public void enviarEmail(int tipo) throws AddressException, MessagingException {
		String msg;
		if(tipo == 1) {
			msg = "SITE INDISPONÍVEL - REALIZADA A VERIFICAÇÃO DA CONEXÃO COM ONCHANGE";
		}
		else {
			msg = "ALTERAÇÃO NO CÓDIGO FONTE DO SITE - VERIFICAÇÃO REALIZADA COM ONCHANGE";
		}
		String assunto = "ONCHANGE - LOGS - Tipo: " + tipo;
		String email = "willianmauricioxcix@gmail.com";
		String remetente = "onchangefmk@gmail.com";
		System.out.println("__________________________________________________");
		System.out.println("Enviando email DE: " + remetente + " PARA: " + email);
		System.out.println("Assunto: " + assunto);

		Message message = new MimeMessage(criarSessionMail());
		message.setFrom(new InternetAddress(remetente)); // Remetente

		Address[] toUser = InternetAddress // DestinatÃ¡rio(s)
				.parse(email.trim().toLowerCase());

		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assunto);// Assunto
		message.setContent(msg, "text/html");
		Transport.send(message);
		System.out.println("Email enviado com Sucesso!");
		System.out.println("__________________________________________________");
		msg = "";
	}
}
