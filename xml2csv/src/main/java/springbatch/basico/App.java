package springbatch.basico;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		 
		String[] springConfig  = 
			{	"job-report.xml" 
			};
	 
		ApplicationContext context = 
			new ClassPathXmlApplicationContext(springConfig);
	 
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("reportJob");
	 
		try {
			JobParameters jobParameters = new JobParametersBuilder()
				.addString("excludeAge", Integer.toString(30))
				.addString("minAge", Integer.toString(29))
				.toJobParameters();
			
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
		System.out.println("Done");
	 
	  }
}
