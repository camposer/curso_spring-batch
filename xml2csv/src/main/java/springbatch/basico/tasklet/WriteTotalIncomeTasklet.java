package springbatch.basico.tasklet;

import java.io.File;
import java.io.PrintWriter;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class WriteTotalIncomeTasklet implements Tasklet {
	private String fileName;
	
	@Override
	public RepeatStatus execute(StepContribution sc, ChunkContext ctx)
			throws Exception {
		
		Double totalIncome = (Double)ctx.getStepContext()
				.getJobExecutionContext().get("totalIncome");
		
		PrintWriter pw = new PrintWriter(new File(fileName));
		pw.println("totalIncome," + totalIncome);
		pw.flush();
		pw.close();
		
		return RepeatStatus.FINISHED;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
