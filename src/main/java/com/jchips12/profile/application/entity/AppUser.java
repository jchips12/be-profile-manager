package com.jchips12.profile.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class AppUser {

    @MongoId
    private ObjectId id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

}
