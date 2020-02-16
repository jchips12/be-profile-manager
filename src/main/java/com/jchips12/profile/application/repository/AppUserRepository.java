package com.jchips12.profile.application.repository;

import com.jchips12.profile.application.entity.AppUser;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, MongoId> {

    AppUser findByUsername(String userName);

}
