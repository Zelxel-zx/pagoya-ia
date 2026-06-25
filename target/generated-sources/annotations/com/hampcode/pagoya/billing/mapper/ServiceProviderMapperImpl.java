package com.hampcode.pagoya.billing.mapper;

import com.hampcode.pagoya.billing.dto.ServiceProviderResponse;
import com.hampcode.pagoya.billing.model.ServiceProvider;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-23T10:23:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 26.0.1 (Homebrew)"
)
@Component
public class ServiceProviderMapperImpl implements ServiceProviderMapper {

    @Override
    public ServiceProviderResponse toResponse(ServiceProvider p) {
        if ( p == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = p.getId();
        name = p.getName();

        String category = p.getCategory().name();

        ServiceProviderResponse serviceProviderResponse = new ServiceProviderResponse( id, name, category );

        return serviceProviderResponse;
    }
}
