package com.example.locallibrary.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//책- 장르의 다대다(N:M)관계를 구현하기 위해 필요한 엔티티

@Entity
public class BookGenre {
    
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;

    //책 Id
    //다대일(N:1) 여러개의 책이 같은 장르를 공유 할 수 있다
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id") //책 id를 외래키로 저장한다
    private Book book;

    //장르 Id
    //다대일: 여러개의 장르가 하나의 책에 속할 수있다
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    //기본 생성자
    public BookGenre() {}

    //객체 생성용 셍성자
    public BookGenre(Book book , Genre genre) {
        this.book = book;
        this.genre = genre;
    }

    //게터
    public Long getId() {
        return id;
    }

    public Book getBook () {
        return book;
    }
    
    public Genre getGenre () {
       return genre;
    }

}
