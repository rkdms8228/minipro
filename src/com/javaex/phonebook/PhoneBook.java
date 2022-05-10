package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		
		//[시작 화면]
		System.out.println("*********************************************");
		System.out.println("*"+"              "+"전화번호 관리 프로그램"+"              "+"*");
		System.out.println("*********************************************");
		
		boolean flag = true;
		List<Person> pArray = new ArrayList<Person>(); //리스트 생성

		
		//phoneDB 읽어 내기
		InputStream is = new FileInputStream("./phoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream os = new FileOutputStream("./phoneDB-1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		while(flag) {
			
			while(true) {
				
				String chart = br.readLine();
				
				if(chart == null) {
					break;
				}else {
					
					//리스트 배열 관리
					String[] person = chart.split(",");
					pArray.add(new Person(person[0], person[1], person[2]));
					
				}
			
				bw.write(chart);
				bw.newLine();
				
			}//while(true)
			
			System.out.println();
			System.out.println(" [1.리스트]  [2.등록]  [3.삭제]  [4.검색]  [5.종료]");
			System.out.println("---------------------------------------------");
			System.out.print(">메뉴 번호: ");
			int num = sc.nextInt();
			

			switch(num) {
	
				case 1: //[리스트]
					System.out.println();
					System.out.println("<1.리스트>");
					System.out.println();
					
					int i = 1;
					
					for(Person p : pArray) {
						System.out.println(i+"."+p.getName()+"\t"+p.getHp()+"\t"+p.getCompany());
						i++;
					}
					break;
					
				case 2:	//[등록]
					System.out.println();
					System.out.println("<2.등록>");
					System.out.println();
					
					sc.nextLine(); //엔터값 제거
					
					System.out.print(">이름: ");
					String name = sc.nextLine();
					
					System.out.print(">휴대전화: ");
					String ph = sc.nextLine();
					
					System.out.print(">회사전화: ");
					String company = sc.nextLine();
					
					pArray.add(new Person(name, ph, company));
					
					System.out.println("[등록되었습니다.]");
					
					bw.close();
					break;
					
				case 3: //[삭제]
					System.out.println();
					System.out.println("<3.삭제>");
					System.out.println();
					
					
					System.out.print(">번호: ");
					int del = sc.nextInt();
					
					pArray.remove(del-1); //배열 번호에서 삭제
					
					System.out.println("[삭제되었습니다.]");
					break;
					
				case 4:
					System.out.println();
					System.out.println("<4.검색>");
					System.out.println();
					
					sc.nextLine(); //엔터값 제거
					
					System.out.print(">이름: ");
					String keyword = sc.nextLine();

					for(Person p : pArray) {
						
						if(p.getName().matches(".*"+keyword+".*")) {
							System.out.println("이름: "+p.getName()+"\t전화번호: "+p.getHp()+"\t회사번호: "+p.getCompany());
						}
						
					}
					break;
					
				case 5: //[종료]
					System.out.println();
					System.out.println("<5.종료>");
					System.out.println();
					
					System.out.println("*********************************************");
					System.out.println("*"+"                  "+"감사합니다"+"                  "+"*");
					System.out.println("*********************************************");
					
					flag = false; //탈출
					break;
					
				default:
					System.out.println();
					System.out.println("[다시 입력해 주세요.]");
					break;
				
				
			}//switch(num)

		
			
		}//while(flag)
		
		br.close();
		sc.close();

	}//main

}//PhoneBook class
