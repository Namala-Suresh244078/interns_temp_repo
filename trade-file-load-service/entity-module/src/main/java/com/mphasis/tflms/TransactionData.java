package com.mphasis.tflms;

import com.mphasis.tflms.constants.TransactionDataConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = TransactionDataConstants.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TransactionDataConstants.COLUMN_ID)
    private Long id;

    @NotNull(message = "File header date cannot be null")
    @Column(name = TransactionDataConstants.COLUMN_FILE_HEADER_DATE)
    private LocalDate fileHeaderDate;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_ACCOUNT_NUMBER, unique = true)
    private String accountNumber;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_TRANSACTION_TYPE)
    private String transactionType;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_BATCH_LOCATION)
    private String batchLocation;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_BATCH_NUMBER, unique = true)
    private String batchNumber;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_UPDATE_BATCH_STATE)
    private String updateBatchState;

    @Column(name = TransactionDataConstants.COLUMN_RELATED_FILE_NUMBER)
    private String relatedFileNumber;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_ACTION_NAME)
    private String actionName;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_RELATED_FILE_KEY, unique = true)
    private String relatedFileKey;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_DO_NOT_REPORT_FLAG, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean doNotReportFlag = false;

    @Column(name = TransactionDataConstants.COLUMN_EXPLANATION)
    private String explanation;

    @Column(name = TransactionDataConstants.COLUMN_MINOR_ASSETS_CLASS)
    private String minorAssetsClass;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_OWNING_PORTFOLIO)
    private String owningPortfolio;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_POSTER_INITIALS)
    private String posterInitials;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_TRANSACTION_SUBTYPE)
    private String transactionSubtype;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_CASH_EFFECT)
    private BigDecimal cashEffect;

    @Column(name = TransactionDataConstants.COLUMN_CASH_PAID_OUT)
    private BigDecimal cashPaidOut;

    @Column(name = TransactionDataConstants.COLUMN_BROKER_NUMBER)
    private String brokerNumber;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_OLD_BALANCE)
    private BigDecimal oldBalance;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_NEW_BALANCE)
    private BigDecimal newBalance;
}
