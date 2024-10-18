package com.koreait.mzpick_backend.entity.fashion;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="fashion")
@Table(name="fashion")
public class FashionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer fashionNumber;
    private String userId;
    private String fashionTitle;
    private String fashionContent;
    private Integer fashionTotalPrice;
    private Integer fashionViewCount;
    private Date fashionDate;
}
