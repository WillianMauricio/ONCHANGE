package Framework;

import Email.EnviaEmail;
import Factory.FactoryThread;
import javax.mail.MessagingException;
import org.quartz.SchedulerException;
import Classes.ValidadorQuartz;

/**
 * CLASSE RESPONS�VEL POR TODA A EXECU��O DO FRAMEWORK � NELA QUE CHAMAMOS TODOS
 * OS M�TODOS NECESS�RIOS PARA O FUNCIONAMENTO
 */
public class Biblioteca {
	static private int tipoV;

	/**
	 * M�TODO DE ENVIAR E-MAIL CASO HAJA "ANORMALIDADE" NO SITE
	 * 
	 * @throws MessagingException UTILIZADO CASO OCORRA ALGUMA EXCESS�O NO SCHEDULER
	 */
	public static void enviarEmail() throws MessagingException {
		EnviaEmail email = new EnviaEmail();
		email.enviarEmail(tipoV);
	}

	/**
	 * GERA THREAD PARA EXECU��O DO QUARTZ
	 * @param tempo TEMPO DE EXECU��O DE TAREFAS
	 */
	@SuppressWarnings("unused")
	public void criaThread(int tempo) {
		FactoryThread thread = new FactoryThread(1, tempo);
	}

	/**
	 * M�TODO QUE INSTANCIA UM VALIDADOR QUE ARMAZENA O TIPO, URL EM UMA VARI�VEL
	 * EST�TICA PARA EXECUTAR O JOB QUARTZ EM UM DETERMINADO TEMPO
	 * 
	 * @param tipo  PAR�METRO QUE DEFINE O TIPO DA VERIFICA��O, PODENDO SER POR
	 *              DISPONIBILIDADE DO SITE OU SE HOUVE ALGUMA MUDAN�A NO MESMO.
	 * @param url   PAR�METRO QUE DEFINE A URL DO SITE PARA VERIFICA��O
	 * @param tempo PAR�METRO QUE DEFINE A CADA TANTO TEMPO A EXECU��O DO JOB NA
	 *              CLASSE "QUARTZMAIN.JAVA"
	 * @return RETORNA UM OBJETO DO TIPO VALIDADORQUARTZ
	 * @throws SchedulerException UTILIZADO PARA CHAMAR O M�TODO QUARTZ()
	 */
	public ValidadorQuartz instanciaValidador(int tipo, String url, int tempo) throws SchedulerException {
		tipoV = tipo;
		criaThread(tempo);
		ValidadorQuartz validador = new ValidadorQuartz(tipo, url);
		return validador;
	}
}
