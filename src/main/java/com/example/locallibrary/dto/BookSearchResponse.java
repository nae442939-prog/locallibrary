package com.example.locallibrary.dto;

import java.util.List;

// 책 검사 결과 DTO
public class BookSearchResponse {
    
    //검색 결과 예) 총 0건이 검색되었습니다
    private Long resultCount;
    // 검색 결과 (내부클래스)
    private List<ResultBook> resultbooks;

    //생성자 
    public BookSearchResponse () {}

    //게터 /세터
    public Long getResultCount () {
        return resultCount;
    }
    public void setResultCont (Long resultCount) {
        this.resultCount = resultCount;
    }
    public List<ResultBook> getResultBooks () {
        return resultbooks;
    }
    public void setResultBooks (List<ResultBook> resultBooks) {
        this.resultbooks = resultBooks;
    }

    //검색 결과 나오는 책 정보
    public static class ResultBook {

        private String title; // 책 제목
        private String authorName; // 저자
        private Long instanceCount; // 책에 딸린 사본의 개수
        private String url; //책 상세 페이지 링크 

        public ResultBook () {}

        //게터 /세터

        public String getTitle () {
            return title;
        }
        public void setTitle (String title) {
            this.title = title;
        }
        public String getAuthorName () {
            return authorName;
        }
        public void setAuthorName (String authorName) {
            this.authorName = authorName;
        }
        public Long getInstanceCount () {
            return instanceCount;
        }
        public void setInstanceCount (Long instanceCount) {
            this.instanceCount = instanceCount;
        }
        public String getUrl () {
            return url;
        }
        public void setUrl (Long id) {
            this.url = "/book/" + id;
        }
    }
}
