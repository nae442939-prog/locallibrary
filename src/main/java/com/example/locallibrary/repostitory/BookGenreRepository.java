package com.example.locallibrary.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.BookGenre;

public interface BookGenreRepository extends JpaRepository<BookGenre, Long> {

    //장르 ID의  값이 전달받은 id와 일치하는 행동을 조회한다
    // 특정 장르에 해당하는 책들을 찾을 때 활용한다
    List<BookGenre> findByGenreId(Long id);

    //장르 id값이 입력받은 id와 일치 하는 행의 개수를 센다 
    //특정 장르에 해당하는 책의 개수를 센다
    Long countByGenreId(Long id);
    

    // 책ID 의 값이 전달받은 id와 일치하는 행동을 조회한다
    // 특정 책의 장르들을 확인 할 때 사용한다 
    List<BookGenre> findByBookId(Long id);

}
