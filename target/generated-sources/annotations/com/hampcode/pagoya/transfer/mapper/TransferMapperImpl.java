package com.hampcode.pagoya.transfer.mapper;

import com.hampcode.pagoya.account.model.Account;
import com.hampcode.pagoya.transfer.dto.TransferResponse;
import com.hampcode.pagoya.transfer.model.Transfer;
import com.hampcode.pagoya.transfer.model.TransferStatus;
import com.hampcode.pagoya.transfer.model.TransferType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-23T10:23:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 26.0.1 (Homebrew)"
)
@Component
public class TransferMapperImpl implements TransferMapper {

    @Override
    public TransferResponse toResponse(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        String sourceAccountNumber = null;
        String targetAccountNumber = null;
        Long id = null;
        TransferType type = null;
        String externalBankName = null;
        String externalAccountNumber = null;
        String externalBeneficiaryName = null;
        BigDecimal amount = null;
        String currency = null;
        BigDecimal exchangeRate = null;
        TransferStatus status = null;
        LocalDateTime createdAt = null;

        sourceAccountNumber = transferSourceAccountAccountNumber( transfer );
        targetAccountNumber = transferTargetAccountAccountNumber( transfer );
        id = transfer.getId();
        type = transfer.getType();
        externalBankName = transfer.getExternalBankName();
        externalAccountNumber = transfer.getExternalAccountNumber();
        externalBeneficiaryName = transfer.getExternalBeneficiaryName();
        amount = transfer.getAmount();
        currency = transfer.getCurrency();
        exchangeRate = transfer.getExchangeRate();
        status = transfer.getStatus();
        createdAt = transfer.getCreatedAt();

        TransferResponse transferResponse = new TransferResponse( id, type, sourceAccountNumber, targetAccountNumber, externalBankName, externalAccountNumber, externalBeneficiaryName, amount, currency, exchangeRate, status, createdAt );

        return transferResponse;
    }

    private String transferSourceAccountAccountNumber(Transfer transfer) {
        Account sourceAccount = transfer.getSourceAccount();
        if ( sourceAccount == null ) {
            return null;
        }
        return sourceAccount.getAccountNumber();
    }

    private String transferTargetAccountAccountNumber(Transfer transfer) {
        Account targetAccount = transfer.getTargetAccount();
        if ( targetAccount == null ) {
            return null;
        }
        return targetAccount.getAccountNumber();
    }
}
