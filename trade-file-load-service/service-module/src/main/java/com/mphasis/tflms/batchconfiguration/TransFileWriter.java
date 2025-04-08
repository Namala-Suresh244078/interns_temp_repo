package com.mphasis.tflms.batchconfiguration;

import org.springframework.beans.factory.annotation.Autowired;

public class TransFileWriter implements ItemWriter<TransDataValidationWrapper> {

    @Autowired
    TransactionDataRepository transactionDataRepository;
    @Autowired
    FileValidationRepository fileValidationRepository;

    @Override
    public void write( transDataChunk<? extends TransDataValidationWrapper>  transDataChunk) throws Exception {
        for (TransDataValidationWrapper dataValidationWrapper:  transDataChunk) {
            transactionFileRepository.save(dataValidationWrapper.getTransactionData());

            List<FileValidation> fileValidation = dataValidationWrapper.getFileValidation();
            if (fileValidation != null && !fileValidation.isEmpty()) {
                fileValidationRepository.saveAll(fileValidation);
            }
        }
    }
}
