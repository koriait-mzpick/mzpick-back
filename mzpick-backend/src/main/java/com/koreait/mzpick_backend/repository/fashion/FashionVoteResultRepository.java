package com.koreait.mzpick_backend.repository.fashion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionVoteResultEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionVoteResultpk;

@Repository
public interface FashionVoteResultRepository extends JpaRepository<FashionVoteResultEntity, FashionVoteResultpk> {
    
}
