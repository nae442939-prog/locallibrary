package com.example.locallibrary.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.locallibrary.dto.BookListResponse;
import com.example.locallibrary.dto.BookSearchResponse;
//내부 클래스를 단독적으로 임포트 할 수 있다 
import com.example.locallibrary.dto.BookSearchResponse.ResultBook;
import com.example.locallibrary.repostitory.BookInstanceRepository;
import com.example.locallibrary.repostitory.BookRepository;

import org.springframework.ui.Model;

@Controller
public class HomeController {

    private final BookRepository bookRepository;
    private final BookInstanceRepository bookInstanceRepository;

    public HomeController(BookRepository bookRepository , BookInstanceRepository bookInstanceRepository){
        this.bookRepository = bookRepository;
        this.bookInstanceRepository = bookInstanceRepository;
        
    }
    
    @GetMapping("/")
    public String home(Model model) {

        List<BookListResponse> books = bookRepository.findAll().stream()
        .map((book) -> {
            BookListResponse dto = new BookListResponse();
            dto.setTitle(book.getTitle());
            dto.setAuthorName(book.getAuthor().getName());
            dto.setUrl(book.getId());
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("books",books);
  
        return "home";
    }

   @GetMapping("/search")
   public String search(@RequestParam(name = "keyword")String keyword, Model model) {

    //검색어를 포함하는 책들을 DB에서 가져온다
    //검색결과 DTO로 변환한다 
    List<ResultBook> resultBooks = bookRepository.findByTitleContainingIgnoreCase(keyword).stream()
    .map(book -> {
        ResultBook dto = new ResultBook();
        dto.setTitle(book.getTitle());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setInstanceCount(bookInstanceRepository.countByBookId(book.getId()));
        dto.setUrl(book.getId());
        return dto;
        }).collect(Collectors.toList());

        //최종 DTO 검색결과 DTO
        BookSearchResponse dto = new BookSearchResponse();
        dto.setResultBooks(resultBooks);
        dto.setResultCont(bookRepository.countByTitleContainingIgnoreCase(keyword));

        //뷰 완성
        model.addAttribute("keyword",keyword); //사용자의 검색어를 출력한다 
        // 예) 검색어- "사과"에 대한 검색 결과 입니다 
        model.addAttribute("result", dto);

        // 서버 응답
        return "search_result";
   }
}
