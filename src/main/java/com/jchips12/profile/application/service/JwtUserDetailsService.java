package com.jchips12.profile.application.service;

import com.jchips12.profile.application.entity.AppUser;
import com.jchips12.profile.application.repository.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public JwtUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null && appUser.getUsername().equals(username)) {
            return new User(appUser.getUsername(), appUser.getPassword(), appUser.getAuthorities());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}