package com.koreait.mzpick_backend.entity.fashion;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="fashionHashtag")
@Table(name="fashion_hashtag")
public class FashionHashtagEntity {
    private Integer fashionHashtagNumber;
    private Integer fashionNumber;
    private String fashionHashtagContent;
}
