package com.hampcode.pagoya.auth.mapper;

import com.hampcode.pagoya.auth.dto.RegisterResponse;
import com.hampcode.pagoya.auth.model.Role;
import com.hampcode.pagoya.auth.model.User;
import com.hampcode.pagoya.customer.model.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-23T10:23:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 26.0.1 (Homebrew)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public RegisterResponse toRegisterResponse(User user, Customer customer) {
        if ( user == null && customer == null ) {
            return null;
        }

        Long userId = null;
        String email = null;
        String role = null;
        if ( user != null ) {
            userId = user.getId();
            email = user.getEmail();
            role = userRoleName( user );
        }
        Long customerId = null;
        String fullName = null;
        String dni = null;
        if ( customer != null ) {
            customerId = customer.getId();
            fullName = customer.getFullName();
            dni = customer.getDni();
        }

        RegisterResponse registerResponse = new RegisterResponse( userId, email, role, customerId, fullName, dni );

        return registerResponse;
    }

    private String userRoleName(User user) {
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getName();
    }
}
