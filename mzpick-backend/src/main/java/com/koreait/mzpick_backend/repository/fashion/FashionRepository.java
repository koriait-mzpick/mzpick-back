package com.koreait.mzpick_backend.repository.fashion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
@Repository
public interface FashionRepository extends JpaRepository<FashionEntity, Integer> {
    FashionEntity findByFashionNumber(Integer fashionNumber);

    // ! 5개의 게시글 을 출력하고 Param을 이용한 페이지네이션 구현 //
    @Query(value=
    "SELECT * FROM fashion " +
    "ORDER BY fashion_date DESC " + 
    "LIMIT :paging, 5", 
    nativeQuery=true)
    List<FashionEntity> findByPaging(@Param("paging") Integer paging);

}
