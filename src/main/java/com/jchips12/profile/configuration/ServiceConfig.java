package com.jchips12.profile.configuration;

import com.jchips12.profile.application.repository.AppUserRepository;
import com.jchips12.profile.application.service.DefaultRegistrationService;
import com.jchips12.profile.application.service.RegistrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    RegistrationService defaultRegistrationService(AppUserRepository appUserRepository) {
        return new DefaultRegistrationService(appUserRepository);
    }
}
