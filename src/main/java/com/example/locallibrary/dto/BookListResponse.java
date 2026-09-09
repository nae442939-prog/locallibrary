package com.example.locallibrary.dto;

//책 목록 조회용 DTO
public class BookListResponse {

    private String title; // 책 제목
    private String authorName; // 저자 이름 
    // 유틸리티 기능
    // 책 상세보기 페이지로 이동하는 링크 주소를 만들어서 보낸다 
    private String url;

   //
    public BookListResponse() {}

    //Getter / Setter
    public String getTitle () {
        return title;
    }
    public void setTitle (String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authoerName) {
        this.authorName = authoerName;
    }
    public String getUrl () {
        return url;
    }
    public void setUrl (Long id) {
        this.url = "/book/" + id;
        
    }
    
}
