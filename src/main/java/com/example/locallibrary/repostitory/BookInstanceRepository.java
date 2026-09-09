    package com.example.locallibrary.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.BookInstance;

// 책 사본 관리 DAO
public interface BookInstanceRepository extends JpaRepository<BookInstance, Long>{

    // 책 ID로 사본 찾기
    List<BookInstance> findByBookId(Long id);

    // 책 ID로 사본의 개수 구하기
    Long countByBookId(Long id);
}
