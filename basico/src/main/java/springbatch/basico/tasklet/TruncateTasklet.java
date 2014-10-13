package springbatch.basico.tasklet;

import java.sql.Connection;
import java.sql.Statement;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TruncateTasklet implements Tasklet {
	private DriverManagerDataSource ds;

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		
		Connection con = ds.getConnection();
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM RAW_REPORT");
		
		return RepeatStatus.FINISHED;
	}

	public DriverManagerDataSource getDs() {
		return ds;
	}

	public void setDs(DriverManagerDataSource ds) {
		this.ds = ds;
	}
}
