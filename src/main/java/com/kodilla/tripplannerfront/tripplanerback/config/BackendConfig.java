package com.kodilla.tripplannerfront.tripplanerback.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BackendConfig {

    @Value("${backend.api.endpoint.test}")
    private String backendApiEndpoint;
}
