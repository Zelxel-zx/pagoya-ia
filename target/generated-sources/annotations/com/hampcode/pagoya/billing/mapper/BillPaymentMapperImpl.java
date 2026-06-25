package com.hampcode.pagoya.billing.mapper;

import com.hampcode.pagoya.billing.dto.BillPaymentResponse;
import com.hampcode.pagoya.billing.dto.CreateBillPaymentRequest;
import com.hampcode.pagoya.billing.model.BillPayment;
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
public class BillPaymentMapperImpl implements BillPaymentMapper {

    @Override
    public BillPayment toEntity(CreateBillPaymentRequest request) {
        if ( request == null ) {
            return null;
        }

        BillPayment.BillPaymentBuilder billPayment = BillPayment.builder();

        billPayment.billCode( request.billCode() );
        billPayment.amount( request.amount() );

        return billPayment.build();
    }

    @Override
    public BillPaymentResponse toResponse(BillPayment p) {
        if ( p == null ) {
            return null;
        }

        String providerName = null;
        Long id = null;
        String billCode = null;
        BigDecimal amount = null;
        LocalDateTime paidAt = null;

        providerName = pProviderName( p );
        id = p.getId();
        billCode = p.getBillCode();
        amount = p.getAmount();
        paidAt = p.getPaidAt();

        String status = p.getStatus().name();

        BillPaymentResponse billPaymentResponse = new BillPaymentResponse( id, providerName, billCode, amount, status, paidAt );

        return billPaymentResponse;
    }

    private String pProviderName(BillPayment billPayment) {
        ServiceProvider provider = billPayment.getProvider();
        if ( provider == null ) {
            return null;
        }
        return provider.getName();
    }
}
