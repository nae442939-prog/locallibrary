package com.example.locallibrary.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    
    
}
