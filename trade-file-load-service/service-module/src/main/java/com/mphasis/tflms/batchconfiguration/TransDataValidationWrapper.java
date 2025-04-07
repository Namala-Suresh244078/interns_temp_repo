package com.mphasis.tflms.batchconfiguration;

import com.mphasis.tflms.FileValidation;
import com.mphasis.tflms.TransactionData;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class TransDataValidationWrapper {
    TransactionData transactionData;
    List<FileValidation> fileValidation;

    public static TransDataValidationWrapper dataValidationWrapper(TransactionData transactionData,List<FileValidation> validations){
        return TransDataValidationWrapper.builder()
                .transactionData(transactionData)
                .fileValidation(validations)
                .build();
    }
}
