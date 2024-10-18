package com.koreait.mzpick_backend.repository.fashion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;

@Repository
public interface FashionHashtagRepository extends JpaRepository<FashionHashtagEntity, Integer> {
    
}
