package com.koreait.mzpick_backend.repository.keyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.keyword.KeywordEntity;

@Repository
public interface keywordRepository extends JpaRepository<KeywordEntity, Integer> {
    
}
