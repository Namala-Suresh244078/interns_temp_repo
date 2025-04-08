package com.mphasis.tflms.service;

import com.mphasis.tflms.FileValidation;
import com.mphasis.tflms.TransactionData;

import java.util.List;

public interface ITradeDataValidatorService {
    List<FileValidation> validateTradeData(TransactionData transactionData);
}
