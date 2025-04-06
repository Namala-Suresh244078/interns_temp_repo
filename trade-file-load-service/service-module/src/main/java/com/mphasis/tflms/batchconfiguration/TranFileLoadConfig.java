package com.mphasis.tflms.batchconfiguration;


import com.mphasis.tflms.BatchConfigConstants;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.File;


@Configuration
public class TranFileLoadConfig {
    
    @Value("${batch.chunk.size}")
    private int chunkSize;
    
    @Bean
    @StepScope
    public FlatFileItemReader<String[]> itemReader(@Value("#{jobParameters['file']}") String filePath) {
        return new FlatFileItemReaderBuilder<String[]>()
                .resource(new FileSystemResource(new File(filePath)))
                .name(TRANS_FILE_READER_NAME)
                .lineMapper((line, lineNumber) -> line.split(TRANS_FILE_DELIMITER))
                .strict(false)
                .build();
    }
    
    @Bean
    public TransFileWriter itemWriter(){
        return new TransFileWriter();
    }
    
    @Bean
    public TransDataProcessor itemProcessor(){
        return new TransDataProcessor();
        }
    
    @Bean
    public Job job (JobRepository jobRepository, Step step) {
        return new JobBuilder("tradeFileLoadJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step (JobRepository jobRepository, PlatformTransactionManager transactionManager, FlatFileItemReader<String[]> itemReader) {
        return new StepBuilder("tradeFileProcessingStep", jobRepository)
                .<String[], TransDataValidationWrapper>chunk(chunkSize, transactionManager)
                .reader(itemReader)
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }
}
