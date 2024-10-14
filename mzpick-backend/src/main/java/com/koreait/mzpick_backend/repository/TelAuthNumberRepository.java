package com.koreait.mzpick_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.TelAuthNumberEntity;

@Repository
public interface  TelAuthNumberRepository extends JpaRepository<TelAuthNumberEntity, String>{

    boolean existsByTelNumberAndAuthNumber(String telNumber, String authNumber);
}
