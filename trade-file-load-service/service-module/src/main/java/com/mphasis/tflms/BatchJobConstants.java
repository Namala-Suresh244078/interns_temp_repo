package com.mphasis.tflms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BatchJobConstants {

        public static final String TRANS_FILE_DELIMITER = ",";
        public static final String TRANS_FILE_READER_NAME = "TradeFileReader";
        public static final String TRANS_FILE_JOB= "TradeFileJob";
        public static final String TRANS_FILE_STEP="TradeFileStep";

}

