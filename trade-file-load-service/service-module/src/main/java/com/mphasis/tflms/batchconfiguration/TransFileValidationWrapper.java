package com.mphasis.tflms.batchconfiguration;

import com.mphasis.tflms.TransactionData;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Builder
public class TransFileValidationWrapper {

    private TransactionData transactionData;
    private List<FileValidation> fileValidation;

    public static TransFileValidationWrapper wrapValidateData(String[] tradeData, List<FileValidation> fileValidation, String guid) {
        TransactionData transactionData = TransactionData.builder()
                .fileHeaderDate(LocalDate.parse(tradeData[0]))
                .accountNumber(tradeData[1])
                .transactionType(tradeData[2])
                .batchLocation(tradeData[3])
                .batchNumber(tradeData[4])
                .updateBatchState(tradeData[5])
                .relatedFileNumber(tradeData[6])
                .actionName(tradeData[7])
                .relatedFileKey(tradeData[8])
                .doNotReportFlag(Boolean.valueOf(tradeData[9]))
                .explanation(tradeData[10])
                .minorAssetsClass(tradeData[11])
                .owningPortfolio(tradeData[12])
                .posterInitials(tradeData[13])
                .transactionSubtype(tradeData[14])
                .cashEffect(new BigDecimal(tradeData[15]))
                .cashPaidOut(new BigDecimal(tradeData[16]))
                .brokerNumber(tradeData[17])
                .oldBalance(new BigDecimal(tradeData[18]))
                .newBalance(new BigDecimal(tradeData[19]))
                .guid(guid)
                .build();


        return TransFileValidationWrapper.builder()
                .transactionData(transactionData)
                .fileValidation(fileValidation)
                .build();
    }
}

