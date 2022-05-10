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
					System.out.println("<1.리스트>");
					int i = 1;
					
					for(Person p : pArray) {
						System.out.println(i+"."+p.getName()+"\t"+p.getHp()+"\t"+p.getCompany());
						i++;
					}

					break;
					
				case 2:	//[등록]
					System.out.println("<2.등록>");
					sc.nextLine();
					System.out.print(">이름: ");
					String name = sc.nextLine();
					
					System.out.print(">휴대전화: ");
					String ph = sc.nextLine();
					
					System.out.print(">회사전화: ");
					String company = sc.nextLine();
					
					pArray.add(new Person(name, ph, company));
					
					bw.close();
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				default:
					break;
				
				
			}//switch(num)

		
			
		}//while(flag)
		
		br.close();
		sc.close();

	}//main

}//PhoneBook class