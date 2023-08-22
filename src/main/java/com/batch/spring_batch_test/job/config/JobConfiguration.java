//package com.batch.spring_batch_test.job.config;
//
//import com.batch.spring_batch_test.job.db_job.db_service.Job1ItemProcessor;
//import com.batch.spring_batch_test.job.db_job.db_service.Job1ItemReader;
//import com.batch.spring_batch_test.job.db_job.db_service.Job1ItemWriter;
//import com.batch.spring_batch_test.job.db_job.dto.Item;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.flow.FlowExecutionStatus;
//import org.springframework.batch.core.job.flow.JobExecutionDecider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//public class JobConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    private final Job1ItemReader job1ItemReader;
//    private final Job1ItemProcessor job1ItemProcessor;
//    private final Job1ItemWriter job1ItemWriter;
//
//    @Bean
//    public Job simpleJob() {
//        return jobBuilderFactory.get("simpleJob3")   // "simpleJob" batch job 생성
//                .start(simpleStep1())
//                .build();
//    }
//
//    @Bean
//    public Step simpleStep1() {
//        return stepBuilderFactory.get("simpleStep3") // "simpleStep" batch job 생성
//                .<String, Item>chunk(2)
//                .reader(job1ItemReader)
//                .processor(job1ItemProcessor)
//                .writer(job1ItemWriter)
//                .build();
//    }
//
//
//}
