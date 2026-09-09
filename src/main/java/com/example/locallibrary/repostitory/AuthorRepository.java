package com.example.locallibrary.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.Author;

// 저자 엔티티 관리
public interface AuthorRepository extends JpaRepository<Author, Long> {

}