package com.koreait.mzpick_backend.repository.keyword;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.util.SystemPropertyUtils;

import com.koreait.mzpick_backend.dto.response.keyword.GetKeywordListResponseDto;
import com.koreait.mzpick_backend.entity.keyword.KeywordEntity;
import com.koreait.mzpick_backend.repository.resultSet.GetKeywordResultset;

@Repository
public interface keywordRepository extends JpaRepository<KeywordEntity, Integer> {
    boolean existsByUserId (String userId);
    // boolean existsByKeywordDate(String userId);

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

    @Query(
    value=
        "SELECT keyword_content as keywordContent, count(keyword_content) as count " +
        "FROM keyword " +
        "WHERE keyword_date BETWEEN :startDate AND :endDate " +
        "GROUP BY keyword_content " +
        "ORDER BY count DESC " +
        "LIMIT 10",
    nativeQuery=true
    )
    // resultset받아와서 코드 완성
    List<GetKeywordResultset> getLanking(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
