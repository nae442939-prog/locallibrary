package com.example.locallibrary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// 이 클래스를 엔티티로 정의한다
@Entity // 엔티티: 데이터베이스 테이블과 매핑되는 객체 (도메인)
public class Book {
    
    @Id // 이 필드를 기본키(Primary Key)로 설정
    // 기본키의 생성방식(Generation Type)을 AUTO_INCREMENT로 설정
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    // 책 제목
    private String title;

    // 책 요약
    @Column(length = 1000) // 최대 길이 1000자 = varchar(1000)
    private String summary;

    // 외래키 지정하기
    // @ManyToOne: 다대일(N:1) 관계를 정의하는 어노테이션
    // 다대일: 여러개의 책(Book)이 하나의 저자(Author)에 속하는 관계
    // fetch: 데이터 가져오기 전략. EAGER, LAZY가 있다
    // EAGER(즉시 가져오기): 연관된 엔티티를 항상 함께 조회한다
    // LAZY(미루기): 연관된 엔티티가 필요한 순간에 가져온다
    // 예) Book 테이블에서 집계 함수(COUNT 등)을 활용할 때 저자 조회를 할 필요가 없음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    //ISBN (국제 책 번호 )
private String isbn;

//기본 생성자 
public Book () {}

// 객체 생성용 생성자
public Book(String title, String summary, String isbn, Author author) {
    this.title = title;
    this.summary = summary;
    this.isbn = isbn;
    this.author = author;
};

public long getId () {
    return id;
}

public String getTitle () {
    return title;
}
public String getSummary() {
    return summary;
}
public Author getAuthor () {
    return author;
}
public String getIsbn () {
    return isbn;
}
}
