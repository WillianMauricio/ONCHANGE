package Quartz;

import javax.mail.MessagingException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import Classes.ValidadorQuartz;
import Factory.FactoryTipo;
import Framework.Biblioteca;

/**
 * CLASSE QUE IMPLEMENTA O JOB DO QUARTZ
 * 
 * @author willian
 *
 */
public class QuartzMain implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		FactoryTipo tipo = new FactoryTipo();
		@SuppressWarnings("static-access")
		boolean status = tipo.verificaTipo(ValidadorQuartz.getValidador().getTipo(),
				ValidadorQuartz.getValidador().getUrl());
		System.out.println(status);
		if (status) {
			System.out.println("TUDO OK!");
		} else {
			try {
				Biblioteca.enviarEmail();
			} catch (MessagingException e) {
				System.out.println("Erro!");
			}
		}
	}
}