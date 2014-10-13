package springbatch.basico.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTasklet implements Tasklet {

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {

        // why not using println? because it makes testing harder, *nix and
        // windows think different about new line as in \n vs \r\n    
        System.out.print("Hello World!");

        return RepeatStatus.FINISHED;
	}

}