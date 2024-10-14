package com.koreait.mzpick_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="telAuthNumber")
@Table(name="tel_auth_number")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelAuthNumberEntity {

    @Id 
    private String telNumber;

    private String authNumber;
}
