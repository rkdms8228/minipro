package com.javaex.phonebook;

import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("*********************************************");
		System.out.println("*"+"              "+"전화번호 관리 프로그램"+"              "+"*");
		System.out.println("*********************************************");
		System.out.println();
		System.out.println(" [1.리스트]  [2.등록]  [3.삭제]  [4.검색]  [5.종료]");
		System.out.println("---------------------------------------------");
		System.out.print(">메뉴 번호: ");
		
		int num = sc.nextInt();
		
		
		sc.close();

	}

}
