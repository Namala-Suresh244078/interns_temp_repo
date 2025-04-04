package com.mphasis.tflms.batchconfiguration;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import java.util.UUID;
import static com.mphasis.tflms.batchconfiguration.TradeDataValidator.*;
@Component
public class TransactionDataProcessor implements ItemProcessor<String[],TransFileValidationWrapper> {

    @Override
    public TransFileValidationWrapper process(String[] tradeData) throws Exception {

        String errorGuid = UUID.randomUUID().toString();

        TradeDataValidator.validateFieldHeaderDate(tradeData[0], errorGuid);
        TradeDataValidator.validateAccountNumber(tradeData[1], errorGuid);
        TradeDataValidator.validateTransactionType(tradeData[2], errorGuid);
        TradeDataValidator.validateBatchLocation(tradeData[3], errorGuid);
        TradeDataValidator.validateBatchNumber(tradeData[4], errorGuid);
        TradeDataValidator.validUpdateBatchState(tradeData[5], errorGuid);
        TradeDataValidator.validRelatedFileNumber(tradeData[6], errorGuid);
        TradeDataValidator.validActionName(tradeData[7], errorGuid);
        TradeDataValidator.validateRelatedFileKey(tradeData[8], errorGuid);
        TradeDataValidator.validateDoNotReportFlag(tradeData[9], errorGuid);
        TradeDataValidator.validateExplanation(tradeData[10], errorGuid);
        TradeDataValidator.validateMinorAssetsClass(tradeData[11], errorGuid);
        TradeDataValidator.validateOwningPortFolio(tradeData[12], errorGuid);
        TradeDataValidator.validatePosterInitials(tradeData[13], errorGuid);
        TradeDataValidator.validateTransactionSubType(tradeData[14], errorGuid);
        TradeDataValidator.validateCashEffect(tradeData[15], errorGuid);
        TradeDataValidator.validateCashPaidOut(tradeData[16], errorGuid);
        TradeDataValidator.validateBrokerNumber(tradeData[17], errorGuid);
        TradeDataValidator.validateOldBalance(tradeData[18], errorGuid);
        TradeDataValidator.validateNewBalance(tradeData[19], errorGuid);

        return TransFileValidationWrapper.wrapValidateData(tradeData, fileValidationList, fileValidationList.isEmpty() ? null : errorGuid);
    }
}
