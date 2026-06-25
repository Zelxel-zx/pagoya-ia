package com.hampcode.pagoya.customer.mapper;

import com.hampcode.pagoya.auth.model.User;
import com.hampcode.pagoya.customer.dto.CustomerResponse;
import com.hampcode.pagoya.customer.model.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-23T10:23:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 26.0.1 (Homebrew)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long userId = null;
        Long id = null;
        String fullName = null;
        String dni = null;
        String phone = null;

        userId = customerUserId( customer );
        id = customer.getId();
        fullName = customer.getFullName();
        dni = customer.getDni();
        phone = customer.getPhone();

        CustomerResponse customerResponse = new CustomerResponse( id, fullName, dni, phone, userId );

        return customerResponse;
    }

    private Long customerUserId(Customer customer) {
        User user = customer.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }
}
