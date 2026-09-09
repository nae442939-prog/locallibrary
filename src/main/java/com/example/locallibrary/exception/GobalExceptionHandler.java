package com.example.locallibrary.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GobalExceptionHandler {
    
    //기록기 : 서버에서 발생한 중요한 일들을 기록하는 객체
    private static final Logger logger = LoggerFactory.getLogger(GobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resourceNotFoundHandler(IllegalArgumentException e, Model model) {
        
        //예외 상황을 콘솔에 출력한다 (개발자 확인용)
        logger.error("잘못된 요청 발생:" + e);

        //에러 페이지를 생성한다 (클라이언트 전송용)
        model.addAttribute("status", HttpStatus.BAD_REQUEST.value());
        model.addAttribute("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        model.addAttribute("message", e.getMessage());

        //서버 응답
        return "error";
    }

        //기타 예외를 처리하는 핸들러
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public String handeAllException(Exception e, Model model) {

            logger.error("서버 오류 발생: ", e);

        //에러 페이지 생성
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("error",HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        model.addAttribute("message","문제가 발생했습니다. 나중에 다시 시도 하세요");

        //서버 응답 
        return "error";
        
        }
}


