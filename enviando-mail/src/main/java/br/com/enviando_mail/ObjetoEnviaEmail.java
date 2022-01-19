package br.com.enviando_mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


//aula 19.7 5min
public class ObjetoEnviaEmail {

	private String userName = "correiasallyson@gmail.com";
	private String senha = "xxxxxxxxx";
	
	private String nomeRemetente = "";
	private String listaDestinatarios = "";
	private String assuntoEmail = "";
	private String menssagemEmail = "";
	
	
	
	public ObjetoEnviaEmail(String userName, String senha, String nomeRemetente, String listaDestinatarios,
			String assuntoEmail, String menssagemEmail) {
		super();
		this.userName = userName;
		this.senha = senha;
		this.nomeRemetente = nomeRemetente;
		this.listaDestinatarios = listaDestinatarios;
		this.assuntoEmail = assuntoEmail;
		this.menssagemEmail = menssagemEmail;
	}



	public void enviarEmail() throws Exception {

		/* Olhar configurações do smtp do email */
		Properties properties = new Properties();
		
		properties.put("mail.smtp.ssl.trust","*");
		properties.put("mail.smtp.auth", "true");/* Autorização */
		properties.put("mail.smtp.stattls", "true");/* Autenticação */
		properties.put("mail.smtp.hot", "smtp.gmail.com");/* Servidor do gmail */
		properties.put("mail.smtp.port", "465");/* Porta do servidor */
		properties.put("mail.smtp.socketFactory.port", "465");/* especifica porta a ser conectada pelo socket */
		properties.put("mail.smtp.socketFactory.class",
				"javax.ssl.SSLSocketFactory");/* Classe socket da conexão ao SMTP */

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, senha);
			}

		});

		System.out.println(senha);

		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));/* remetente */
		message.setRecipients(Message.RecipientType.TO, toUser);/* destinatários */
		message.setSubject(assuntoEmail);
		message.setText(menssagemEmail);

		Transport.send(message);
	}
}
