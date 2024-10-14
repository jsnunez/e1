package com.empresa.empresa.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.empresa.empresa.domain.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
