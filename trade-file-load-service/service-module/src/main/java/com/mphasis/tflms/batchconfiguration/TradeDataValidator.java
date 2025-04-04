package com.mphasis.tflms.batchconfiguration;

import com.mphasis.tflms.enums.FileErrorSeverity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TradeDataValidator {
     static List<FileValidation> fileValidationList = new ArrayList<>();

    public static void validateFieldHeaderDate(String date, String errorGuid) {
        if (!StringUtils.hasText(date)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "file header date should not be null", errorGuid));
        } else if (date.length() != 8) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "file header date should be 8 characters long", errorGuid));
        }
    }

    public static void validateAccountNumber(String accountNumber, String errorGuid) {
        if (!StringUtils.hasText(accountNumber)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "account number should not be null", errorGuid));
        } else if (accountNumber.length() != 12) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "account number should be 12 characters long", errorGuid));
        }
    }

    public static void validateTransactionType(String transactionType, String errorGuid) {
        if (!StringUtils.hasText(transactionType)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "transaction type should not be null", errorGuid));
        } else if (transactionType.length() != 3) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "transaction type should be 3 characters long", errorGuid));
        }
    }

    public static void validateBatchLocation(String batchLocation, String errorGuid) {
        if (!StringUtils.hasText(batchLocation)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "batch location should not be null", errorGuid));
        } else if (batchLocation.length() != 2) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "batch location should be 2 characters long", errorGuid));
        }
    }

    public static void validateBatchNumber(String batchNumber, String errorGuid) {
        if (!StringUtils.hasText(batchNumber)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "batch number should not be null", errorGuid));
        } else if (batchNumber.length() != 6) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "batch number should be 6 characters long", errorGuid));
        }
    }

    public static void validUpdateBatchState(String updateBatchState, String errorGuid) {
        if (!StringUtils.hasText(updateBatchState)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "update batch state should not be null", errorGuid));
        } else if (updateBatchState.length() != 8) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "update batch state should be 8 characters long", errorGuid));
        }
    }

    public static void validRelatedFileNumber(String relatedFileNumber, String errorGuid) {
        if (!StringUtils.hasText(relatedFileNumber)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "related file number should not be null", errorGuid));
        } else if (relatedFileNumber.length() != 8) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "related file number should be 8 characters long", errorGuid));
        }
    }

    public static void validActionName(String actionName, String errorGuid) {
        if (!StringUtils.hasText(actionName)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "action name should not be null", errorGuid));
        } else if (actionName.length() != 12) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "action name should be 12 characters long", errorGuid));
        }
    }

    public static void validateRelatedFileKey(String relatedFileKey, String errorGuid){
        if (!StringUtils.hasText(relatedFileKey)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "related file key should not be null", errorGuid));
        } else if (relatedFileKey.length() != 6) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "related file key should be 6 characters long", errorGuid));
        }
    }
    public static void validateDoNotReportFlag(String doNotReportFlag,String errorGuid){
        if (!StringUtils.hasText(doNotReportFlag)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "do not report flag should not be null", errorGuid));
        } else if (doNotReportFlag.length() != 1) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "do not report flag should be 1 characters long", errorGuid));
        }
    }
    public static void validateExplanation(String explanation,String errorGuid){
        if (!StringUtils.hasText(explanation)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "explanation should not be null",errorGuid));
        }
        else if(explanation.length()!=50) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "explanation should not be more or less than 50",errorGuid));
        }
    }
    public static void validateMinorAssetsClass(String minorAssetsClass,String errorGuid){
        if (!StringUtils.hasText(minorAssetsClass)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "minor assets class should not be null",errorGuid));
        }
        else if(minorAssetsClass.length()!=3) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "minor assets class should not be more or less than 3",errorGuid));
        }
    }
    public static void validateOwningPortFolio(String owningPortFolio,String errorGuid){
        if (!StringUtils.hasText(owningPortFolio)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "owning port folio should not be null",errorGuid));
        }
        else if(owningPortFolio.length()!=1) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "owning port folio should not be more or less than 1",errorGuid));
        }
    }
    public static void validatePosterInitials(String posterInitials,String errorGuid){
        if (!StringUtils.hasText(posterInitials)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "poster initials should not be null",errorGuid));
        }
        else if(posterInitials.length()!=3) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "poster initials should not be more or less than 3",errorGuid));
        }
    }
    public static void validateTransactionSubType(String transactionSubType,String errorGuid){
        if (!StringUtils.hasText(transactionSubType)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "transaction sub type should not be null",errorGuid));
        }
        else if(transactionSubType.length()!=2) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "transaction sub type should not be more or less than 2",errorGuid));
        }
    }
    public static void validateCashEffect(String cashEffect,String errorGuid){
        if (!StringUtils.hasText(cashEffect)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "cash effect should not be null",errorGuid));
        }
        else if(cashEffect.length()!=17) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "cash effect should not be more or less than 17",errorGuid));
        }
    }
    public static void validateCashPaidOut(String cashPaidOut,String errorGuid){
        if (!StringUtils.hasText(cashPaidOut)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "cash paid out should not be null",errorGuid));
        }
        else if(cashPaidOut.length()!=17) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "cash paid out should not be more or less than 17",errorGuid));
        }
    }
    public static void validateBrokerNumber(String brokerNumber,String errorGuid) {
        if (!StringUtils.hasText(brokerNumber)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR, FileErrorSeverity.ERROR.getSeverityLevel(), "broker number should not be null", errorGuid));
        } else if (brokerNumber.length() != 3) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING, FileErrorSeverity.WARNING.getSeverityLevel(), "broker number should not be more or less than 3", errorGuid));
        }
    }
    public static void validateOldBalance(String oldBalance,String errorGuid){
        if (!StringUtils.hasText(oldBalance)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "old balance should not be null",errorGuid));
        }
        else if(oldBalance.length()!=17) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "old balance should not be more or less than 17",errorGuid));
        }
    }
    public static void validateNewBalance(String newBalance,String errorGuid){
        if (!StringUtils.hasText(newBalance)) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.ERROR,FileErrorSeverity.ERROR.getSeverityLevel(), "new balance should not be null",errorGuid));
        }
        else if(newBalance.length()!=17) {
            fileValidationList.add(new FileValidation(1, FileErrorSeverity.WARNING,FileErrorSeverity.WARNING.getSeverityLevel(), "new balance should not be more or less than 17",errorGuid));
        }
    }
}
