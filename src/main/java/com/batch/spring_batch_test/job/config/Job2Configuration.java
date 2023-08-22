package com.batch.spring_batch_test.job.config;

import com.batch.spring_batch_test.job.db_job.db_step.DbStepTaskLet;
import com.batch.spring_batch_test.job.db_job.db_step.DbStepTaskLet2;
import com.batch.spring_batch_test.job.db_job.dto.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class Job2Configuration {

    private final DbStepTaskLet dbStepTaskLet;
    private final DbStepTaskLet2 dbStepTaskLet2;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job stepJob() {
        return jobBuilderFactory.get("simpleJob")   // "simpleJob" batch job 생성
                .start(step1())
                .start(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step") // "simpleStep" batch job 생성
                .tasklet(dbStepTaskLet)
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(dbStepTaskLet2)
                .build();
    }

}
