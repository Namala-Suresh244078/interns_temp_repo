package com.mphasis.tflms.batchconfiguration;

import com.mphasis.tflms.FileValidation;
import com.mphasis.tflms.TransactionData;
import com.mphasis.tflms.impl.TradeDataValidatorServiceImpl;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TransDataProcessor implements ItemProcessor<String[], TransDataValidationWrapper> {

    @Autowired
    TradeDataValidatorServiceImpl tradeDataValidatorService;

    private static final int IDX_FILE_HEADER_DATE=0;
    private static final int IDX_ACCOUNT_NUMBER=1;
    private static final int IDX_TRANSACTION_TYPE=2;
    private static final int IDX_BATCH_LOCATION=3;
    private static final int IDX_BATCH_NUMBER=4;
    private static final int IDX_UPDATE_BATCH_STATE=5;
    private static final int IDX_RELATED_FILE_NUMBER=6;
    private static final int IDX_ACTION_NAME=7;
    private static final int IDX_RELATED_FILE_KEY=8;
    private static final int IDX_DO_NOT_REPORT_FLAG=9;
    private static final int IDX_EXPLANATION=10;
    private static final int IDX_MINOR_ASSETS_CLASS=11;
    private static final int IDX_OWNING_PORTFOLIO=12;
    private static final int IDX_POSTER_INITIALS=13;
    private static final int IDX_TRANSACTION_SUB_TYPE=14;
    private static final int IDX_CASH_EFFECT=15;
    private static final int IDX_CASH_PAID_OUT=16;
    private static final int IDX_BROKER_NUMBER=17;
    private static final int IDX_OLD_BALANCE=18;
    private static final int IDX_NEW_BALANCE=19;

    @Override
    public TransDataValidationWrapper process(String[] tradeData) throws Exception {

        String errorGuid= UUID.randomUUID().toString();

        TransactionData transactionData = TransactionData.builder()
                .fileHeaderDate(LocalDate.parse(tradeData[IDX_FILE_HEADER_DATE]))
                .accountNumber(tradeData[IDX_ACCOUNT_NUMBER])
                .transactionType(tradeData[IDX_TRANSACTION_TYPE])
                .batchLocation(tradeData[IDX_BATCH_LOCATION])
                .batchNumber(tradeData[IDX_BATCH_NUMBER])
                .updateBatchState(tradeData[IDX_UPDATE_BATCH_STATE])
                .relatedFileNumber(tradeData[IDX_RELATED_FILE_NUMBER])
                .actionName(tradeData[IDX_ACTION_NAME])
                .relatedFileKey(tradeData[IDX_RELATED_FILE_KEY])
                .doNotReportFlag(Boolean.valueOf(tradeData[IDX_DO_NOT_REPORT_FLAG]))
                .explanation(tradeData[IDX_EXPLANATION])
                .minorAssetsClass(tradeData[IDX_MINOR_ASSETS_CLASS])
                .owningPortfolio(tradeData[IDX_OWNING_PORTFOLIO])
                .posterInitials(tradeData[IDX_POSTER_INITIALS])
                .transactionSubtype(tradeData[IDX_TRANSACTION_SUB_TYPE])
                .cashEffect(new BigDecimal(tradeData[IDX_CASH_EFFECT]))
                .cashPaidOut(new BigDecimal(tradeData[IDX_CASH_PAID_OUT]))
                .brokerNumber(tradeData[IDX_BROKER_NUMBER])
                .oldBalance(new BigDecimal(tradeData[IDX_OLD_BALANCE]))
                .newBalance(new BigDecimal(tradeData[IDX_NEW_BALANCE]))
                .build();

        List<FileValidation> fileValidationResult=tradeDataValidatorService.validateTradeData(transactionData,errorGuid);
        transactionData.setErrorGuid(fileValidationResult.isEmpty()?null:errorGuid);
        return TransDataValidationWrapper.dataWrapper(transactionData,fileValidationResult);
    }
}
