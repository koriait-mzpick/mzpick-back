package com.koreait.mzpick_backend.repository.fashion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionVoteEntity;

@Repository
public interface FashionVoteRepository extends JpaRepository<FashionVoteEntity, Integer> {
   FashionVoteEntity findByFashionVoteNumber(Integer fashionVoteNumber);
}
