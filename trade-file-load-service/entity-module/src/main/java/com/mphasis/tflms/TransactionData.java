package com.mphasis.tflms;

import com.mphasis.tflms.constants.TransactionDataEntityConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = TransactionDataEntityConstants.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TransactionDataEntityConstants.COLUMN_ID)
    private Long id;

    @NotNull(message = "File header date cannot be null")
    @Column(name = TransactionDataEntityConstants.COLUMN_FILE_HEADER_DATE)
    private LocalDate fileHeaderDate;

    @NotNull
    @Size(min = 12, max = 12)
    @Column(name = TransactionDataEntityConstants.COLUMN_ACCOUNT_NUMBER, unique = true)
    private String accountNumber;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(name = TransactionDataEntityConstants.COLUMN_TRANSACTION_TYPE)
    private String transactionType;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(name = TransactionDataEntityConstants.COLUMN_BATCH_LOCATION)
    private String batchLocation;

    @NotNull
    @Size(min = 6, max = 6)
    @Column(name = TransactionDataEntityConstants.COLUMN_BATCH_NUMBER, unique = true)
    private String batchNumber;

    @NotNull
    @Size(min = 8, max = 8) // YYYYMMDD format
    @Column(name = TransactionDataEntityConstants.COLUMN_UPDATE_BATCH_STATE)
    private String updateBatchState;

    @Size(min = 2, max = 2)
    @Column(name = TransactionDataEntityConstants.COLUMN_RELATED_FILE_NUMBER)
    private String relatedFileNumber;

    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = TransactionDataEntityConstants.COLUMN_ACTION_NAME)
    private String actionName;

    @NotNull
    @Size(min = 6, max = 6)
    @Column(name = TransactionDataEntityConstants.COLUMN_RELATED_FILE_KEY, unique = true)
    private String relatedFileKey;

    @NotNull
    @Column(name = TransactionDataEntityConstants.COLUMN_DO_NOT_REPORT_FLAG, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean doNotReportFlag = false;

    @Size(max = 50)
    @Column(name = TransactionDataEntityConstants.COLUMN_EXPLANATION)
    private String explanation;

    @Size(min = 3, max = 3)
    @Column(name = TransactionDataEntityConstants.COLUMN_MINOR_ASSETS_CLASS)
    private String minorAssetsClass;

    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = TransactionDataEntityConstants.COLUMN_OWNING_PORTFOLIO)
    private String owningPortfolio;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(name = TransactionDataEntityConstants.COLUMN_POSTER_INITIALS)
    private String posterInitials;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(name = TransactionDataEntityConstants.COLUMN_TRANSACTION_SUBTYPE)
    private String transactionSubtype;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    @Column(name = TransactionDataEntityConstants.COLUMN_CASH_EFFECT)
    private BigDecimal cashEffect;

    @Digits(integer = 15, fraction = 2)
    @Column(name = TransactionDataEntityConstants.COLUMN_CASH_PAID_OUT)
    private BigDecimal cashPaidOut;

    @Size(min = 3, max = 3)
    @Column(name = TransactionDataEntityConstants.COLUMN_BROKER_NUMBER)
    private String brokerNumber;

    @NotNull
    @Digits(integer = 17, fraction = 2)
    @Column(name = TransactionDataEntityConstants.COLUMN_OLD_BALANCE)
    private BigDecimal oldBalance;

    @NotNull
    @Digits(integer = 17, fraction = 2)
    @Column(name = TransactionDataEntityConstants.COLUMN_NEW_BALANCE)
    private BigDecimal newBalance;
}
