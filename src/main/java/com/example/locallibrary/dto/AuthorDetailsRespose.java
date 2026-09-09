package com.example.locallibrary.dto;

import java.time.LocalDate;

// 저자 상세보기 DTO
public class AuthorDetailsRespose {

    private String name;
    private String birthDate;
    private String deathDate;

    //생성자
    public AuthorDetailsRespose () {}

    //게터 /세터
    public String getName() {
        return name;
    } 
    public void setName (String name) {
        this.name = name;
    }
    public String getBirthDate () {
        return birthDate;
    }
    public void setBirthDate (LocalDate birthDate) {
        //  날짜 객체를 바로 출력가능하도록 문자열로 변환한다
        // 출생일/사망일 정보가 없으면 빈 문자열을 출력한다 
        this.birthDate = birthDate != null? birthDate.toString() : "";
    }
    public String getDeathDate () {
        return deathDate;
    }
    public void setDeathDate (LocalDate deathDate) {
    this.deathDate = deathDate != null ? deathDate.toString() : "";
    }
}
