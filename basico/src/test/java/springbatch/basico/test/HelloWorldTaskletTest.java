package springbatch.basico.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.core.step.tasklet.Tasklet;

import springbatch.basico.tasklet.HelloWorldTasklet;

public class HelloWorldTaskletTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final Tasklet tasklet = new HelloWorldTasklet();

    @Test
    public void testExecute() throws Exception {
        tasklet.execute(null, null);
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
