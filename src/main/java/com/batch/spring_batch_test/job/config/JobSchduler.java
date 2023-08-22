package com.batch.spring_batch_test.job.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class JobSchduler {

    private final JobLauncher jobLauncher;
    private final Job2Configuration jobConfiguration;

    @Scheduled(fixedDelay = 10000) // 10 seconds interval
    public void runJobAtInterval() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(jobConfiguration.stepJob(), jobParameters);
    }
}
