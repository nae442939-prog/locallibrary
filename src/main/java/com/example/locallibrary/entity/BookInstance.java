package com.example.locallibrary.entity;


import java.time.LocalDate;

import com.example.locallibrary.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookInstance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //책Id (외래키)
    // 다대일: 여러개의 책 사본이 하나의 책에 속한다
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name= "book_id") //외래키 이름
    private Book book;

    //출판사
    private String imprint;
    
    //상태
    private Status status;

    //반납 일자,데이터베이스의 date  자료형과 대응한다
    //date: yyyy-mm-dd (년-월-일)
   private LocalDate dueBack;

   //생성자 게터
   public BookInstance() {}

   public BookInstance(Book book, String imprint, Status status, LocalDate duBack) {
   
         this.book = book;
        this.imprint =imprint;
        this.status = status;
        this.dueBack = duBack;
   }
    public Long getId() {
        return id;
    }
    public Book getBook() {
        return book;
    }
     public String getImprint () {
        return imprint;
     }
     public Status getStatus () {
        return status;
     }
     public LocalDate getDueBack() {
        return dueBack;
     }


}
 