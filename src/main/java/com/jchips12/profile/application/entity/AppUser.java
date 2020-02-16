package com.jchips12.profile.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class AppUser {

    @MongoId
    private ObjectId id;

    private String username;
    private String password;
    private List<String> authorities;

}
