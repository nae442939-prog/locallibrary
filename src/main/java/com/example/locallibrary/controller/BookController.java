package com.example.locallibrary.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.locallibrary.dto.BookDetailsResponse;
import com.example.locallibrary.dto.BookDetailsResponse.InstanceOfBookListResponse;
import com.example.locallibrary.entity.Book;
import com.example.locallibrary.entity.Genre;
import com.example.locallibrary.repostitory.BookGenreRepository;
import com.example.locallibrary.repostitory.BookInstanceRepository;
import com.example.locallibrary.repostitory.BookRepository;


@Controller //컨트롤러 빈으로 등록
public class BookController { // 책 요청 . 응답 처리한다

    //의존성
    private final BookRepository bookRepository;
    private final BookInstanceRepository bookInstanceRepository;
    private final BookGenreRepository bookGenreRepository;

    public BookController(BookRepository bookRepository, BookInstanceRepository bookInstanceRepository, BookGenreRepository boolGenreRepository) {
        this.bookRepository = bookRepository;
         this.bookInstanceRepository = bookInstanceRepository;
         this.bookGenreRepository = boolGenreRepository;
    }
    
    //책 상세보기 요청을 처리하는 핸들러
    @GetMapping ("/book/{id}") //GET /book/99
    //id: 클라이언트가 요청한 책의 ID
    //@PathVariable : 경로 변수를 지정해주는 어노테이션
    // URL 경로에서 지정한 자리에 있는 데이터를 변수로 인식 하도록 만든다 
    // 경로 변수도 요청 매개변수(@RequestParam) 처럼 요청 주소 (URL) 에 서버에 전송 할 데이터를
    // 담는 방식이다
    public String getOne(@PathVariable("id") Long id , Model model) {

    // DB에서 전송 받은 id와 일치하는 책을 찾는다
    Book book = bookRepository.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("도서 정보가 존재하지 않습니다" + id));

    // 이 책의 사본목록 DTO 를 만든다
    List<InstanceOfBookListResponse> bookInstances = bookInstanceRepository.findByBookId(id)
    .stream()
    .map((bookInstance) -> {
        InstanceOfBookListResponse dto = new InstanceOfBookListResponse();
        dto.setTitle(bookInstance.getBook().getTitle());
        dto.setUrl(bookInstance.getId());
        dto.setStatus(bookInstance.getStatus().getLabel());
        return dto;
     }) .collect(Collectors.toList());

     //이 책의 장르목록 DTO를 만들어준다
     List<String> genres = bookGenreRepository.findByBookId(id).stream()
     .map((bookGenre) -> {
        Genre genre = bookGenre.getGenre();
        return genre.getName();
     }).collect(Collectors.toList());

     //최종 DTO 책 상세보기
     BookDetailsResponse dto = new BookDetailsResponse();
     dto.setTitle(book.getTitle());
     dto.setSummary(book.getSummary());
     dto.setAuthorName(book.getAuthor().getName());
     dto.setAuthorUrl(book.getAuthor().getId());
     dto.setIsbn(book.getIsbn());
     dto.setBookGenres(genres);
     dto.setBookInstanceCount(bookInstanceRepository.countByBookId(id));
     dto.setBookInstances(bookInstances);

     //뷰 에게 DTO전달
     model.addAttribute("book", dto);

     // 서버의 응답
     return "book_detail";
  
    }
}
