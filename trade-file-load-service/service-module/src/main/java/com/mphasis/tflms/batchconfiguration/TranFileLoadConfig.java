package com.mphasis.tflms.batchconfiguration;


import com.mphasis.tflms.BatchJobConstants;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import java.io.File;
import static com.mphasis.tflms.BatchJobConstants.*;


@Configuration
public class TranFileLoadConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<String[]> itemReader(@Value("#{jobParameters['file']}") String filePath) {
        return new FlatFileItemReaderBuilder<String[]>()
                .resource(new FileSystemResource(new File(filePath)))
                .name(TRANS_FILE_READER)
                .lineMapper((line, lineNumber) -> line.split(TRANS_FILE_DELIMITER))
                .strict(false)
                .build();
    }
}
