package com.javaex.phonebook3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaex.phonebook.Person;

public class PhoneBook {
		
	/*
	main 함수에는 기본 구조만 구현 --> 전체의 흐름을 파악하기 좋다.
	주요기능은 PhoneManager클래스 만들어서 구현
	*/
	
	 public static void main(String[] args) throws IOException {

        //PhoneManager 생성
        //파일에서 데이터를 읽어오고, 스케너를 연결한다.
        PhoneManager pManager = new PhoneManager();
        
        //시작 타이틀 출력
        pManager.showTitle();

        // while 시작
        boolean run = true;
        while(run){
            // 메뉴 출력, 입력값 리턴
            int menuNum = pManager.showMenu();

            // switch() 시작
            switch(menuNum){
                
	            // 1(리스트)
	            case 1:
	                pManager.showList();
	                break;
	                
	            // 2(등록)
	            case 2:
	                pManager.showAdd();
	                break;
	                
	            // 3(삭제)
	            case 3:
	                pManager.showRemove();
	                break;
	                
	            // 4(검색)
	            case 4:
	                pManager.showSearch();
	                break;
	                
	            // 5(종료)
	            case 5:
	                run = false;
	                break;
	                
				// 없는 번호일때
	            default :
	            	pManager.showEtc();
	                break;
            
            }// switch() 종료
            
        }// while 종료

        // 종료화면
        pManager.showEnd();
    }

}
