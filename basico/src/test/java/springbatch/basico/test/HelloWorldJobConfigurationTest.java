package springbatch.basico.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath*:hello-world-job.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldJobConfigurationTest {

    @Autowired
    private Job job;
    @Autowired
    private JobLauncher jobLauncher;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /** Simple Launch Test. */
    @Test
    public void launchJob() throws Exception {
        // launch the job
        JobExecution jobExecution = jobLauncher.run(job, new JobParameters());

        // assert job run status
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

        // assert sysoutput
        assertEquals("Hello World!", outContent.toString());
    }

    @Before
    public void setUpStreams() {
        // catch system out
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        // reset JVM standard
        System.setOut(null);
    }
}

