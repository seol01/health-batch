package com.batch.health;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;

@EnableBatchProcessing
@SpringBootApplication
public class HealthApplication {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public HealthApplication(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Step passStep() {
        return new StepBuilder("passStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Execute PassStep");
                    return RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }

    @Bean
    public Job passJob() {
        return new JobBuilder("passJob", jobRepository)
                .start(passStep())
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class, args);
    }
}
