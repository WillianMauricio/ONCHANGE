package Main;

import javax.mail.MessagingException;
import org.quartz.SchedulerException;
import Framework.Biblioteca;

public class Main {
	public static void main(String[] args) throws SchedulerException, MessagingException {
		Biblioteca lib = new Biblioteca();
		lib.FactoryThread(1, "www.youtube.com.br/", 10);
		lib.FactoryThread(2, "teste/testeMudanca.html", 20);
		
	}	
}
