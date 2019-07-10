package Factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactoryThread2 {

	/**
	 * CONSTRUTOR QUE CRIA NOVA THREAD E EXECUTA ELA.
	 * 
	 * @param cont  QUANTAS EXECUÇÕES PARALELAS
	 * @param tempo TEMPO PARA O QUARTZ AGENDAR TAREFAS
	 */
	public FactoryThread2(int cont, int tempo) {
		ExecutorService threadExecutor = Executors.newFixedThreadPool(cont);
		threadExecutor.execute(new Runnable() {
			public void run() {
				quartz(tempo);
			}
		});
	}

	/**
	 * METODO DE CRIAÇÃO DO QUARTZ
	 * 
	 * @param tempo TMEPO DE AGENDAMENTO DE TAREFAS NO QUARTZ
	 * @return SE CONSEGUIU CRIAR O QUARTZ
	 */
	public boolean quartz(int tempo) {
		FactoryQuartz qrt = new FactoryQuartz();
		return qrt.criaQuartz(tempo);
	}
}
