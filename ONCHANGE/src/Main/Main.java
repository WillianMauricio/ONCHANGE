package Main;

import javax.mail.MessagingException;
import org.quartz.SchedulerException;
import Framework.Biblioteca;

public class Main {
	public static void main(String[] args) throws SchedulerException, MessagingException {
		Biblioteca lib = new Biblioteca();
		lib.instanciaValidador(2, "testeMudanca.html", 10);
		lib.instanciaValidador(1, "www.youtube.com/", 10);
	}	
}
