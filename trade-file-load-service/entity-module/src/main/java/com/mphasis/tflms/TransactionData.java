package com.mphasis.tflms;

import com.mphasis.tflms.constants.TransactionDataConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_FILE_HEADER_DATE, length = TransactionDataConstants.FILE_HEADER_DATE_LENGTH)
    private LocalDate fileHeaderDate;

    @NotNull
    @Size(min = TransactionDataConstants.ACCOUNT_NUMBER_LENGTH, max = TransactionDataConstants.ACCOUNT_NUMBER_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_ACCOUNT_NUMBER, length = TransactionDataConstants.ACCOUNT_NUMBER_LENGTH, unique = true)
    private String accountNumber;

    @NotNull
    @Size(max = TransactionDataConstants.TRANSACTION_TYPE_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_TRANSACTION_TYPE, length = TransactionDataConstants.TRANSACTION_TYPE_LENGTH)
    private String transactionType;

    @NotNull
    @Size(max = TransactionDataConstants.BATCH_LOCATION_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_BATCH_LOCATION, length = TransactionDataConstants.BATCH_LOCATION_LENGTH)
    private String batchLocation;

    @NotNull
    @Size(max = TransactionDataConstants.BATCH_NUMBER_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_BATCH_NUMBER, length = TransactionDataConstants.BATCH_NUMBER_LENGTH, unique = true)
    private String batchNumber;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_UPDATE_BATCH_STATE, length = TransactionDataConstants.UPDATE_BATCH_STATE_LENGTH)
    private LocalDate updateBatchState;

    @Size(max = TransactionDataConstants.RELATED_FILE_NUMBER_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_RELATED_FILE_NUMBER, length = TransactionDataConstants.RELATED_FILE_NUMBER_LENGTH)
    private String relatedFileNumber;

    @NotNull
    @Size(max = TransactionDataConstants.ACTION_NAME_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_ACTION_NAME, length = TransactionDataConstants.ACTION_NAME_LENGTH)
    private String actionName;

    @NotNull
    @Size(max = TransactionDataConstants.RELATED_FILE_KEY_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_RELATED_FILE_KEY, length = TransactionDataConstants.RELATED_FILE_KEY_LENGTH, unique = true)
    private String relatedFileKey;

    @NotNull
    @Column(name = TransactionDataConstants.COLUMN_DO_NOT_REPORT_FLAG, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean doNotReportFlag = false;

    @Size(max = TransactionDataConstants.EXPLANATION_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_EXPLANATION, length = TransactionDataConstants.EXPLANATION_LENGTH)
    private String explanation;

    @Size(max = TransactionDataConstants.MINOR_ASSETS_CLASS_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_MINOR_ASSETS_CLASS, length = TransactionDataConstants.MINOR_ASSETS_CLASS_LENGTH)
    private String minorAssetsClass;

    @NotNull
    @Size(max = TransactionDataConstants.OWNING_PORTFOLIO_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_OWNING_PORTFOLIO, length = TransactionDataConstants.OWNING_PORTFOLIO_LENGTH)
    private String owningPortfolio;

    @NotNull
    @Size(max = TransactionDataConstants.POSTER_INITIALS_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_POSTER_INITIALS, length = TransactionDataConstants.POSTER_INITIALS_LENGTH)
    private String posterInitials;

    @NotNull
    @Size(max = TransactionDataConstants.TRANSACTION_SUBTYPE_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_TRANSACTION_SUBTYPE, length = TransactionDataConstants.TRANSACTION_SUBTYPE_LENGTH)
    private String transactionSubtype;

    @NotNull
    @Digits(integer = TransactionDataConstants.DECIMAL_PRECISION, fraction = TransactionDataConstants.DECIMAL_SCALE)
    @Column(name = TransactionDataConstants.COLUMN_CASH_EFFECT, precision = TransactionDataConstants.DECIMAL_PRECISION, scale = TransactionDataConstants.DECIMAL_SCALE)
    private BigDecimal cashEffect;

    @Digits(integer = TransactionDataConstants.DECIMAL_PRECISION, fraction = TransactionDataConstants.DECIMAL_SCALE)
    @Column(name = TransactionDataConstants.COLUMN_CASH_PAID_OUT, precision = TransactionDataConstants.DECIMAL_PRECISION, scale = TransactionDataConstants.DECIMAL_SCALE)
    private BigDecimal cashPaidOut;

    @Size(max = TransactionDataConstants.BROKER_NUMBER_LENGTH)
    @Column(name = TransactionDataConstants.COLUMN_BROKER_NUMBER, length = TransactionDataConstants.BROKER_NUMBER_LENGTH)
    private String brokerNumber;

    @NotNull
    @Digits(integer = TransactionDataConstants.DECIMAL_PRECISION, fraction = TransactionDataConstants.DECIMAL_SCALE)
    @Column(name = TransactionDataConstants.COLUMN_OLD_BALANCE, precision = TransactionDataConstants.DECIMAL_PRECISION, scale = TransactionDataConstants.DECIMAL_SCALE)
    private BigDecimal oldBalance;

    @NotNull
    @Digits(integer = TransactionDataConstants.DECIMAL_PRECISION, fraction = TransactionDataConstants.DECIMAL_SCALE)
    @Column(name = TransactionDataConstants.COLUMN_NEW_BALANCE, precision = TransactionDataConstants.DECIMAL_PRECISION, scale = TransactionDataConstants.DECIMAL_SCALE)
    private BigDecimal newBalance;
}
