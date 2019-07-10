package Framework;

import Email.EnviaEmail;
import Factory.FactoryThread;
import javax.mail.MessagingException;
import org.quartz.SchedulerException;
import Classes.ValidadorQuartz;

/**
 * CLASSE RESPONSÁVEL POR TODA A EXECUÇÃO DO FRAMEWORK É NELA QUE CHAMAMOS TODOS
 * OS MÉTODOS NECESSÁRIOS PARA O FUNCIONAMENTO
 */
public class Biblioteca {
	static private int tipoV;

	/**
	 * MÉTODO DE ENVIAR E-MAIL CASO HAJA "ANORMALIDADE" NO SITE
	 * 
	 * @throws MessagingException UTILIZADO CASO OCORRA ALGUMA EXCESSÃO NO SCHEDULER
	 */
	public static void enviarEmail() throws MessagingException {
		EnviaEmail email = new EnviaEmail();
		email.enviarEmail(tipoV);
	}

	/**
	 * GERA THREAD PARA EXECUÇÃO DO QUARTZ
	 * @param tempo TEMPO DE EXECUÇÃO DE TAREFAS
	 */
	@SuppressWarnings("unused")
	public void criaThread(int tempo) {
		FactoryThread thread = new FactoryThread(1, tempo);
	}

	/**
	 * MÉTODO QUE INSTANCIA UM VALIDADOR QUE ARMAZENA O TIPO, URL EM UMA VARIÁVEL
	 * ESTÁTICA PARA EXECUTAR O JOB QUARTZ EM UM DETERMINADO TEMPO
	 * 
	 * @param tipo  PARÂMETRO QUE DEFINE O TIPO DA VERIFICAÇÃO, PODENDO SER POR
	 *              DISPONIBILIDADE DO SITE OU SE HOUVE ALGUMA MUDANÇA NO MESMO.
	 * @param url   PARÂMETRO QUE DEFINE A URL DO SITE PARA VERIFICAÇÃO
	 * @param tempo PARÂMETRO QUE DEFINE A CADA TANTO TEMPO A EXECUÇÃO DO JOB NA
	 *              CLASSE "QUARTZMAIN.JAVA"
	 * @return RETORNA UM OBJETO DO TIPO VALIDADORQUARTZ
	 * @throws SchedulerException UTILIZADO PARA CHAMAR O MÉTODO QUARTZ()
	 */
	public ValidadorQuartz instanciaValidador(int tipo, String url, int tempo) throws SchedulerException {
		tipoV = tipo;
		criaThread(tempo);
		ValidadorQuartz validador = new ValidadorQuartz(tipo, url);
		return validador;
	}
}
