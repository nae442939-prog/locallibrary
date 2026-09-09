package com.example.locallibrary.dto;

import java.time.LocalDate;

// 책 사본 상세 페이지 DTO
public class InstanceOfBookDetailsResponse {
    
    private String title; // 책 제목
    private String imprint; // 출판사
    private String status; // 책 상태
    private String dueBack; // 반납예정일(대출 중인 경우에만 출력)

    //생성자
    public InstanceOfBookDetailsResponse () {}

    // 게터 세터
   public String getTitle () {
    return title;
   }
   public void setTitle(String title) {
    this.title = title;
   }
   public String getImprint () {
    return imprint;
   }
   public void setImprint(String imprint) {
    this.imprint = imprint;
   }
   public String getStatus () {
    return status;
   }
   public void setStatus (String status) {
    this.status = status;
   }
   public String getDueBack () {
    return dueBack;
   }
   
    //  LocalDate: 날짜 객체, 바로 출력 할 수 없다 (뷰에서 )
    public void setDueBack (LocalDate dueBack) {
        this.dueBack = dueBack != null? dueBack.toString() : null;
    }

}
