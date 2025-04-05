package com.mphasis.tflms.impl;

import com.mphasis.tflms.FileValidation;
import com.mphasis.tflms.TransactionData;
import com.mphasis.tflms.service.ITradeDataValidatorService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradeDataValidatorServiceImpl implements ITradeDataValidatorService {

    @Override
    public List<FileValidation> validateTradeData(TransactionData transactionData, String errorGuid) {
        List<FileValidation> tradeFileValidationResult = new ArrayList<>();
        return tradeFileValidationResult;
    }
}
