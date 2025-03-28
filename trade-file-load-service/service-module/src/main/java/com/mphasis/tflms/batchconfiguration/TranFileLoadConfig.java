package com.mphasis.tflms.batchconfiguration;

import com.mphasis.tflms.BatchConfigConstants;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import java.io.File;


@Configuration
public class TranFileLoadConfig extends BatchConfigConstants{

    @Bean
    @StepScope
    public FlatFileItemReader<TRANS_FILE_DATA> itemReader(@Value("#{jobParameters['file']}") String filePath) {
        return new FlatFileItemReaderBuilder<TRANS_FILE_DATA>()
                .resource(new FileSystemResource(new File(filePath)))
                .name(TRANS_FILE_READER_NAME)
                .delimited()
                .delimiter(TRANS_FILE_DELIMITER)
                .names(BatchConfigConstants.TRAN_FILE_HEADERS)
                .linesToSkip(TRANS_FILE_LINES_TO_SKIP)
                .targetType(TRANS_FILE_DATA.class)
                .strict(false)
                .build();
    }
}