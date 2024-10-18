package com.koreait.mzpick_backend.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.auth.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
}
