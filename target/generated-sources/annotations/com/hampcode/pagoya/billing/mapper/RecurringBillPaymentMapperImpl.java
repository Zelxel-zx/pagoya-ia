package com.hampcode.pagoya.billing.mapper;

import com.hampcode.pagoya.billing.dto.RecurringBillPaymentResponse;
import com.hampcode.pagoya.billing.model.RecurringBillPayment;
import com.hampcode.pagoya.billing.model.ServiceProvider;
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
public class RecurringBillPaymentMapperImpl implements RecurringBillPaymentMapper {

    @Override
    public RecurringBillPaymentResponse toResponse(RecurringBillPayment r) {
        if ( r == null ) {
            return null;
        }

        String providerName = null;
        Long id = null;
        String billCode = null;
        BigDecimal amount = null;
        Integer dayOfMonth = null;
        Integer dayOfWeek = null;
        LocalDateTime nextRunAt = null;

        providerName = rProviderName( r );
        id = r.getId();
        billCode = r.getBillCode();
        amount = r.getAmount();
        dayOfMonth = r.getDayOfMonth();
        dayOfWeek = r.getDayOfWeek();
        nextRunAt = r.getNextRunAt();

        String frequency = r.getFrequency().name();
        String status = r.getStatus().name();

        RecurringBillPaymentResponse recurringBillPaymentResponse = new RecurringBillPaymentResponse( id, providerName, billCode, amount, frequency, dayOfMonth, dayOfWeek, status, nextRunAt );

        return recurringBillPaymentResponse;
    }

    private String rProviderName(RecurringBillPayment recurringBillPayment) {
        ServiceProvider provider = recurringBillPayment.getProvider();
        if ( provider == null ) {
            return null;
        }
        return provider.getName();
    }
}
