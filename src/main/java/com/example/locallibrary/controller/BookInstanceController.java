package com.example.locallibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.locallibrary.dto.InstanceOfBookDetailsResponse;
import com.example.locallibrary.entity.BookInstance;
import com.example.locallibrary.repostitory.BookInstanceRepository;

import org.springframework.ui.Model;

public class BookInstanceController {
    
    //의존성 선언 
    private final BookInstanceRepository bookInstanceRepository;

    public BookInstanceController(BookInstanceRepository bookInstanceRepository) {
        this.bookInstanceRepository = bookInstanceRepository;
    }

    //책 사본 상세보기 요청을 처리하는 핸들러
    @GetMapping("/bookinstance/{id}")
    //id: 사용자가 요청한 책 사본의 ID
    public String getOne(@PathVariable("id") Long id, Model model) {
         BookInstance bookInstance = bookInstanceRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("책 사본이 존재하지 않습니다:" + id));
    
    InstanceOfBookDetailsResponse dto = new InstanceOfBookDetailsResponse();
   dto.setTitle(bookInstance.getBook().getTitle());
   dto.setImprint(bookInstance.getImprint());
   dto.setStatus(bookInstance.getStatus().getLabel());
   dto.setDueBack(bookInstance.getDueBack());

   model.addAttribute("bookInstance", dto);
   return "bookinstance_detail";

}
}
