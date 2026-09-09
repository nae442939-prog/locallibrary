package com.example.locallibrary.dto;

import java.util.List;

//책 상세페이지 DTO
public class BookDetailsResponse {
    
    private String title; // 책 제목
    private String summary; // 책 요약
    private String authorName; // 저자 정보
    private String authorUrl; //저자 페이지로 이동하는 링크
    private String isbn; // 책 번호 
    //이 책의 장르들
    private List<String> genres;
    //책에 딸린 사본의 개수
    private Long bookInstanceCount;
    //책에 딸린 사본들 
    private List<InstanceOfBookListResponse>bookInstances;

    public BookDetailsResponse () {}

    public String getTitle () {
        return title;
    }
    public void setTitle (String title) {
        this.title = title;
    }
    public String getSummary () {
        return summary;
    }
    public void setSummary (String summary) {
        this.summary = summary;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName (String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorUrl () {
        return authorUrl;
    }
    public void setAuthorUrl (Long id) {
        this.authorUrl = "/author/" + id;
    }
    public String getIsbn () {
        return isbn;
    }
    public void setIsbn (String isbn) {
        this.isbn = isbn;
    }
    public List<String> getGenres() {
        return genres;
    }
    public void setBookGenres(List<String> genres) {
        this.genres = genres;
    }
    public Long getBookInstanceCount () {
        return bookInstanceCount;
    }
    public void setBookInstanceCount (Long bookInstanceCount) {
        this.bookInstanceCount = bookInstanceCount;
    }
    public List<InstanceOfBookListResponse> getBookInstances () {
        return bookInstances;
    }
    public void setBookInstances(List<InstanceOfBookListResponse> bookInstances) {
        this.bookInstances = bookInstances;
    }

    //책 사본 목록용 DTO
     public static class InstanceOfBookListResponse {

        private String title; // 책 제목
        private String status; //사본의 상태 (대출 중, 대출 가능)
        private String url; //사본 상페이지로 이동하는 링크

        //생성자
        public InstanceOfBookListResponse () {}

        //게터 /세터

        public String getTitle () {
            return title;
        }
        public void setTitle (String title) {
            this.title = title;
        }
        public String getStatus () {
            return status;
        }
        public void setStatus (String status) {
            this.status = status;
        }
        public String getUrl () {
            return url;
        }
        public void setUrl (Long id) {
            this.url = "/bookinstance/" + id;
        }
     }
}
