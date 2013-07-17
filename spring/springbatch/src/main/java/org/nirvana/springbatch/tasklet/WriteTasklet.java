package org.nirvana.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class WriteTasklet implements Tasklet {
	
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		Thread.currentThread().sleep(10000);
		System.out.println(message);
        return RepeatStatus.FINISHED;
	}

}
