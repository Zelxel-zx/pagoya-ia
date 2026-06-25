package com.hampcode.pagoya.account.mapper;

import com.hampcode.pagoya.account.dto.AccountBalanceResponse;
import com.hampcode.pagoya.account.dto.AccountResponse;
import com.hampcode.pagoya.account.model.Account;
import com.hampcode.pagoya.account.model.AccountStatus;
import com.hampcode.pagoya.account.model.AccountType;
import com.hampcode.pagoya.customer.model.Customer;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-23T10:23:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 26.0.1 (Homebrew)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponse toResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        Long customerId = null;
        Long id = null;
        String accountNumber = null;
        BigDecimal balance = null;
        AccountStatus status = null;
        AccountType type = null;

        customerId = accountCustomerId( account );
        id = account.getId();
        accountNumber = account.getAccountNumber();
        balance = account.getBalance();
        status = account.getStatus();
        type = account.getType();

        AccountResponse accountResponse = new AccountResponse( id, accountNumber, balance, status, type, customerId );

        return accountResponse;
    }

    @Override
    public AccountBalanceResponse toBalance(Account account) {
        if ( account == null ) {
            return null;
        }

        String accountNumber = null;
        BigDecimal balance = null;

        accountNumber = account.getAccountNumber();
        balance = account.getBalance();

        AccountBalanceResponse accountBalanceResponse = new AccountBalanceResponse( accountNumber, balance );

        return accountBalanceResponse;
    }

    private Long accountCustomerId(Account account) {
        Customer customer = account.getCustomer();
        if ( customer == null ) {
            return null;
        }
        return customer.getId();
    }
}
