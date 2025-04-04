package com.mphasis.tflms;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TransFileData")
@Data
@NoArgsConstructor
@Builder
public class TransactionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "File header date cannot be null")
    private LocalDate fileHeaderDate;

    @NotNull
    @Size(min = 10, max = 20)
    @Column(unique = true)
    private String accountNumber;

    @NotNull
    @Size(max = 50)
    private String transactionType;

    @NotNull
    @Size(max = 255)
    private String batchLocation;

    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String batchNumber;

    @NotNull
    @Size(max = 100)
    private String updateBatchState;

    @Size(max = 50)
    private String relatedFileNumber;

    @NotNull
    @Size(max = 100)
    private String actionName;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String relatedFileKey;

    @NotNull
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean doNotReportFlag = false;

    @Size(max = 500)
    private String explanation;

    @Size(max = 100)
    private String minorAssetsClass;

    @NotNull
    @Size(max = 100)
    private String owningPortfolio;

    @NotNull
    @Size(min = 2, max = 5)
    private String posterInitials;

    @NotNull
    @Size(max = 100)
    private String transactionSubtype;

    @NotNull
    @Digits(integer = 12, fraction = 2)
    private BigDecimal cashEffect;

    @Digits(integer = 12, fraction = 2)
    private BigDecimal cashPaidOut;

    @Size(max = 20)
    private String brokerNumber;

    @NotNull
    @Digits(integer = 17, fraction = 2)
    private BigDecimal oldBalance;

    @NotNull
    @Digits(integer = 17, fraction = 2)
    private BigDecimal newBalance;

}
