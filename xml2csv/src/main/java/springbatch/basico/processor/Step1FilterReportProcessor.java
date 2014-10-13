package springbatch.basico.processor;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;

import springbatch.basico.model.Report;

public class Step1FilterReportProcessor implements
		ItemProcessor<Report, Report> {
	private JobExecution jobExecution;
	
	private String excludeAge;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		jobExecution = stepExecution.getJobExecution();
	}

	@Override
	public Report process(Report item) throws Exception {

		Double totalIncome = (Double) jobExecution.getExecutionContext().get(
				"totalIncome");
		if (totalIncome != null)
			totalIncome += item.getIncome().doubleValue();
		else
			totalIncome = 0d;

		jobExecution.getExecutionContext().put("totalIncome", totalIncome);

		// filter object which age = 30
		if (item.getAge() == Integer.parseInt(excludeAge)) {
			return null; // null = ignore this object
		}

		return item;
	}

	public String getExcludeAge() {
		return excludeAge;
	}

	public void setExcludeAge(String excludeAge) {
		this.excludeAge = excludeAge;
	}
}