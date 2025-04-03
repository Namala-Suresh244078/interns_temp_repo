package com.mphasis.tflms;
import java.io.File;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;

public class TranFileLoadConfig {
    @Bean
    public RepositoryItemWriter<TRANS_FILE_DATA> itemWriter() {
        RepositoryItemWriter<TRANS_FILE_DATA> writer = new RepositoryItemWriter<>();
        writer.setRepository(transFileDataRepository);
        writer.setMethodName("save");
        return writer;
    }
}
