package com.mphasis.tflms.constants;

public class TransactionDataConstants {

    public static final String TABLE_NAME = "TransFileData";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FILE_HEADER_DATE = "fileHeaderDate";
    public static final String COLUMN_ACCOUNT_NUMBER = "accountNumber";
    public static final String COLUMN_TRANSACTION_TYPE = "transactionType";
    public static final String COLUMN_BATCH_LOCATION = "batchLocation";
    public static final String COLUMN_BATCH_NUMBER = "batchNumber";
    public static final String COLUMN_UPDATE_BATCH_STATE = "updateBatchState";
    public static final String COLUMN_RELATED_FILE_NUMBER = "relatedFileNumber";
    public static final String COLUMN_ACTION_NAME = "actionName";
    public static final String COLUMN_RELATED_FILE_KEY = "relatedFileKey";
    public static final String COLUMN_DO_NOT_REPORT_FLAG = "doNotReportFlag";
    public static final String COLUMN_EXPLANATION = "explanation";
    public static final String COLUMN_MINOR_ASSETS_CLASS = "minorAssetsClass";
    public static final String COLUMN_OWNING_PORTFOLIO = "owningPortfolio";
    public static final String COLUMN_POSTER_INITIALS = "posterInitials";
    public static final String COLUMN_TRANSACTION_SUBTYPE = "transactionSubtype";
    public static final String COLUMN_CASH_EFFECT = "cashEffect";
    public static final String COLUMN_CASH_PAID_OUT = "cashPaidOut";
    public static final String COLUMN_BROKER_NUMBER = "brokerNumber";
    public static final String COLUMN_OLD_BALANCE = "oldBalance";
    public static final String COLUMN_NEW_BALANCE = "newBalance";

    // Field Lengths & Constraints
    public static final int FILE_HEADER_DATE_LENGTH = 8;  // YYYYMMDD
    public static final int ACCOUNT_NUMBER_LENGTH = 12;
    public static final int TRANSACTION_TYPE_LENGTH = 3;
    public static final int BATCH_LOCATION_LENGTH = 2;
    public static final int BATCH_NUMBER_LENGTH = 6;
    public static final int UPDATE_BATCH_STATE_LENGTH = 8;  // YYYYMMDD
    public static final int RELATED_FILE_NUMBER_LENGTH = 2;
    public static final int ACTION_NAME_LENGTH = 12;
    public static final int RELATED_FILE_KEY_LENGTH = 6;
    public static final int EXPLANATION_LENGTH = 50;
    public static final int MINOR_ASSETS_CLASS_LENGTH = 3;
    public static final int OWNING_PORTFOLIO_LENGTH = 1;
    public static final int POSTER_INITIALS_LENGTH = 3;
    public static final int TRANSACTION_SUBTYPE_LENGTH = 2;
    public static final int BROKER_NUMBER_LENGTH = 3;
    public static final int DECIMAL_PRECISION = 17;
    public static final int DECIMAL_SCALE = 2;


}
