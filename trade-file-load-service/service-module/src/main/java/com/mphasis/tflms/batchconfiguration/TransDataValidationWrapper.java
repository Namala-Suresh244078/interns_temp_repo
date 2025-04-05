package com.mphasis.tflms.batchconfiguration;

import com.mphasis.tflms.FileValidation;
import com.mphasis.tflms.TransactionData;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class TransDataValidationWrapper {

    private TransactionData transactionData;
    private List<FileValidation> fileValidationList;

    public static TransDataValidationWrapper dataWrapper(TransactionData transactionData, List<FileValidation> fileValidationResult) {
        return TransDataValidationWrapper.builder()
                .transactionData(transactionData)
                .fileValidationList(fileValidationResult)
                .build();
    }
}
