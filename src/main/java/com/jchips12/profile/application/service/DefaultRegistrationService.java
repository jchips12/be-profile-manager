package com.jchips12.profile.application.service;

import com.jchips12.profile.application.entity.AppUser;
import com.jchips12.profile.application.exception.UserNameAlreadyInUseException;
import com.jchips12.profile.application.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@RequiredArgsConstructor
public class DefaultRegistrationService implements RegistrationService {

    private final AppUserRepository appUserRepository;

    @Override
    public void register(AppUser appUser) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        appUser.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER")));
        appUser.setPassword(encoder.encode(appUser.getPassword()));
        AppUser existingAppUser = appUserRepository.findByUsername(appUser.getUsername());
        if (existingAppUser == null) {
            appUserRepository.save(appUser);
        } else {
            throw new UserNameAlreadyInUseException(String.format("Username %s is already in use.", appUser.getUsername()));
        }
    }
}
