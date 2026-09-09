package com.example.locallibrary.enums;

//도서 사본의 상태를 나타내는 이넘 (관련있는 상수의 집합)
public enum Status {
    
     MAINTENACE ("보수중"),
     AVAILABLE("대출가능"),
     LOANED("대출 중"),
     RESERVED("예약됨");

     //enum 상수의 속성 
     //label : 뷰에서 출력용으로 활용할 데이터 이다 
     private final String label;

     //enum 생성자 : 이넘에 속한 상수에게 속성을 할당한다 
     private Status(String label) { //기본값이 private 이다
        this.label = label;
     }

    //getter: 라벨에 접근용
    public String getLabel() {
        return label;
    }
    }
