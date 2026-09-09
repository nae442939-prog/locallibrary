package com.example.locallibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.locallibrary.dto.AuthorDetailsRespose;
import com.example.locallibrary.entity.Author;
import com.example.locallibrary.repostitory.AuthorRepository;

@Controller
public class AuthorController {

    //의존성 선언
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    @GetMapping("/author/{id}")
    public String getOne(@PathVariable("id") Long id, Model model) {

    Author author = authorRepository.findById(id)
    .orElseThrow(() ->new IllegalArgumentException("저자 정보가 존재하지 않습니다: " + id));


    AuthorDetailsRespose dto = new AuthorDetailsRespose();
    dto.setName(author.getName());
    dto.setBirthDate(author.getBithDate());
    dto.setDeathDate(author.getDeatDate());

    model.addAttribute("author", dto);

    return "author_detail";
    }
}
