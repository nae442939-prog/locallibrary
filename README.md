# locallibrary — 동네 도서관

더조은컴퓨터아카데미 풀스택 부트캠프 Spring 실습 (2026.09)

MDN 의 'Local Library' 예제를 Spring Boot 로 옮겨 만든 도서관 사이트입니다. 책 · 저자 · 장르 · 책 사본(대출 상태)을 JPA 연관관계로 다뤘습니다.

## 기능

- 홈: 책 · 저자 · 사본 수 요약
- 책 · 저자 · 책 사본 상세 페이지
- 책 검색
- 실행할 때 예시 데이터 넣기(`SeedDatabase`), 공통 예외 처리

## 기술

Java · Spring Boot 4 · Spring Data JPA · Thymeleaf · Gradle

## 실행

`./gradlew bootRun` → http://localhost:8080 (DB 설정은 `src/main/resources/application.properties`)
