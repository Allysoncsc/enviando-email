package br.com.enviando_mail;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private String userName = "correiasallyson@gmail.com";
	private String senha = "xxxxxxxxx";
	
	@org.junit.Test
	public void testeEmail() throws Exception{
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("correiasallyson@gmail.com ", "naotem", "Allyson", "allysoncsc@gmail.com", "Testando email com java", "Bom dia. Deu certo");
		
		enviaEmail.enviarEmail();
		
		
		/*try {
		
		*Olhar configurações do smtp do email*
		Properties properties = new Properties();
		
		
		properties.put("mail.smtp.ssl.trust","*");
		properties.put("mail.smtp.auth", "true");*Autorização*
		properties.put("mail.smtp.stattls", "true");*Autenticação*
		properties.put("mail.smtp.hot", "smtp.gmail.com");*Servidor do gmail*
		properties.put("mail.smtp.port", "465");*Porta do servidor*
		properties.put("mail.smtp.socketFactory.port", "465");*especifica porta a ser conectada pelo socket*
		properties.put("mail.smtp.socketFactory.class", "javax.ssl.SSLSocketFactory");*Classe socket da conexão ao SMTP*

		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication(userName, senha);
			}
			
		});
		
		
		System.out.println(senha);
		
		Address [] toUser = InternetAddress.parse("allyson.acs@gmail.com, allyson.acs@gmail.com");
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName));/*remetente*
		message.setRecipients(Message.RecipientType.TO, toUser);/*destinatários*
		message.setSubject("Titulo do email");
		message.setText("Olá, emailenviado por programa em java.");
		
		Transport.send(message);
		
		Thread.sleep(5000);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
}
