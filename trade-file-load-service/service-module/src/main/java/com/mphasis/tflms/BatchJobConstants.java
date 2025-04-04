package com.mphasis.tflms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class BatchJobConstants {

        public static final String TRANS_FILE_DELIMITER = ",";
        public static final String TRANS_FILE_READER = "TradeFileReader";
        public static final int CHUNK_SIZE = 200;
        public static final String TRANS_FILE_JOB= "TradeFileJob";
        public static final String TRANS_FILE_STEP="TradeFileStep";

}

