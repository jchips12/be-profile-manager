package com.jchips12.profile.configuration;

import com.jchips12.profile.application.entity.AppUser;
import com.jchips12.profile.application.repository.AppUserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@Data
@RequiredArgsConstructor
public class MongoDbInitializerConfig implements InitializingBean {

    private final AppUserRepository repository;

    @Override
    public void afterPropertiesSet() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        repository.save(AppUser.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")))
                .build());
        repository.save(AppUser.builder()
                .username("user")
                .password(encoder.encode("user"))
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_CUSTOMER")))
                .build());

    }
}
