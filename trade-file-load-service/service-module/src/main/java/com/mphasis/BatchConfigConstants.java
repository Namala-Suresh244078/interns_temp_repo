package com.mphasis;
public abstract class BatchConfigConstants {
    protected BatchConfigConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    protected static final String[] TRAN_FILE_HEADERS = {"id", "name", "gender", "postalCode", "country", "city", "email"};
    protected static final String TRANS_FILE_DELIMITER = ",";
    protected static final String TRANS_FILE_READER_NAME = "TradeFileReader";
    protected static final Integer TRANS_FILE_LINES_TO_SKIP=1;

}
