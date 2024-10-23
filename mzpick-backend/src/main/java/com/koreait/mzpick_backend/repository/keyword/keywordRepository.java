package com.koreait.mzpick_backend.repository.keyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

import com.koreait.mzpick_backend.dto.response.keyword.GetKeywordListResponseDto;
import com.koreait.mzpick_backend.entity.keyword.KeywordEntity;

@Repository
public interface keywordRepository extends JpaRepository<KeywordEntity, Integer> {
    boolean existsByUserId (String userId);
    @Query(
    value=
        "SELECT " +
        "    C.customer_number as customerNumber, " +
        "    C.name as name, " +
        "    C.birth as birth, " +
        "    C.location as location, " +
        "    N.name as chargerName, " +
        "    N.user_id as chargerId " +
        "ORDER BY C.customer_number DESC ",
    nativeQuery=true
    )
    List<GetKeywordListResponseDto> getKeywords();


}
