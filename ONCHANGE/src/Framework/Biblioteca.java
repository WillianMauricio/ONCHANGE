package Framework;

import Email.EnviaEmail;
import Factory.FactoryQuartz;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
	public boolean quartz(int tempo) {
		FactoryQuartz quartz = new FactoryQuartz();
		return quartz.criaQuartz(tempo);
	}

	/**
	 * CRIA THREAD PARA INSTANCIAS DE VALIDADOR QUARTZ
	 * @param tipo TIPO DA VERIFICAÇÃO
	 * @param url URL DO SITE
	 * @param tempo TEMPO PARA AGENDAR TAREFA
	 */
	public void FactoryThread(int tipo, String url, int tempo) {
		tipoV = tipo;
		ExecutorService threadExecutor = Executors.newFixedThreadPool(2);
		threadExecutor.execute(new Runnable() {
			public void run() {
				try {
					instanciaValidador(tipo, url, tempo);
				} catch (SchedulerException e) {
					e.printStackTrace();
				}
			}
		});
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
		ValidadorQuartz validador = new ValidadorQuartz(tipo, url);
		quartz(tempo);
		return validador;
	}
}
