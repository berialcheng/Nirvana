package org.nirvana.springbatch.main;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lancher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloWorldJob");

		try {
			JobExecution result = launcher.run(job, new JobParameters());
			System.out.println(result.toString());
			JobInstance instance = result.getJobInstance();
			System.out.println(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
