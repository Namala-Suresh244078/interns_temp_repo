package com.mphasis.tflms.batchconfiguration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@Component
@Slf4j
public class ManualBatchSchemaRunner {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet rs = metaData.getTables(null, null, "BATCH_JOB_INSTANCE", null);

            if (!rs.next()) {
                log.warn("Spring did not initialize batch metadata tables. Executing manual-batch-schema.sql...");
                ScriptUtils.executeSqlScript(connection, new ClassPathResource("manual-batch-schema.sql"));
                log.info("Manual batch schema executed successfully.");
            } else {
                log.info("Spring batch metadata tables already exist. No manual execution needed.");
            }

        } catch (Exception e) {
            log.error("Error during manual batch schema initialization: ", e);
        }
    }
}
