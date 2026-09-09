package com.example.locallibrary.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.Book;
 //리포지토리: 데이터 접근 객체 (DAO) 마이베티스의 매퍼 역할과 같다
//인터페이스 를 정의하면 스프링이 내부적으로 구현 해줌 
//Book: 리포지토리가 관리하는 엔티티
//Long: 엔티티에서 기본키의 타입
public interface BookRepository extends JpaRepository <Book, Long> {
   

 // 기본적인 쿼리들은 여기에 내장되어있다  필요한거만 추가하면 된다

    //검색 할 때 쓸 쿼리
    //keyword: 검색어
    //Containing: 검색아 (Key Word)를 포함하는 제목(title)을 찾는다 => DB의 LIKE 연산자

    List<Book> findByTitleContainingIgnoreCase(String keyword);

     Long countByTitleContainingIgnoreCase(String keyword);
}


