package Factory;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import Quartz.QuartzMain;

/**
 * CLASSE QUE CRIA O QUARTZ JOB SCHEDULER
 * @author willian
 *
 */
public class FactoryQuartz {
	
	/**
	 * MÉTODO DE CRIAÇÃO DO SCHEDULER (TRIGGER, JOB)
	 * @param tempo TEMPO DE EXECUÇÃO
	 * @return RETORNA SE CONSEGUIU CRIAR O OBJETO
	 */
	public boolean criaQuartz(int tempo) {
	SchedulerFactory shedFact = new StdSchedulerFactory();
	try {
		Scheduler scheduler = shedFact.getScheduler();
		scheduler.start();
		JobDetail job = JobBuilder.newJob(QuartzMain.class).withIdentity("validadorJOB", "grupo01").build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("validadorTRIGGER", "grupo01")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/" + tempo + " * * * * ?")).build();
		scheduler.scheduleJob(job, trigger);
	} catch (SchedulerException e) {
		return false;
	}
		return true;
	}
}
