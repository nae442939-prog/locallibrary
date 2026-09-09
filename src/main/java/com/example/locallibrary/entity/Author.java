package com.example.locallibrary.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//저자 엔티티로 등록한다
@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //이름
    private String firstName;
    
    //성
    private String familyName;

    //출생일
    private LocalDate birthDate;

    //사망일
    private LocalDate deathDate;

    //생성자, 게터

    public Author () {}

    public Author (String firstName , String familyName, LocalDate birthDate, LocalDate deathDate) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }
    public Long getId () {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getFamilyName () {
        return familyName;
    }
    public LocalDate getBithDate() {
        return birthDate;
    }
    public LocalDate getDeatDate() {
        return deathDate;
    }

    //전체 이름을 반환한다 (유틸리티용)
    public String getName() {
        return firstName+ " " + familyName;
    }
}
