package ch1;

import java.util.Scanner;

public class RectangleTest {

	static void rectangle(int width) {
		for (int line = 1; line <= width; line++) {
			for (int i = 0; i <= width; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}


	static void triangle(int width) {
		for (int line = 1; line <= width; line++) {
			for (int i = 1; i <= line; i++) {
				// line = 1, i = 1까지 
				// line = 2, i = 1~2까지 				
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	// 왼쪽상단이 직각인 직각삼각형.
	static void triangle2(int width) {
		for (int line = 1; line <= width; line++) {
			for (int i = width-line + 1; i > 0; i--) { 
				// line = 1, i = 1...5
				// line = 2, i = 1...4 
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	// for(int i = w; i >= line; i--) 도 가능하다.
	// line = 1 i =5 *
	// line = 1 i =4 *
	// line = 1 i =3 *
	// line = 1 i =2 *
	// line = 1 i =1 *  --> 1줄 끝.
	
	// 오른쪽 상단이 직각인 직각삼각형.
	static void triangle3(int width) {
		for (int line = 1; line <= width; line++) {

			for (int i = 1; i < line; i++) {  // 공백 
				// line = 1, i = 1
				// line = 2, i = 1..2 
				System.out.print(" ");
			}
			for (int i = width; i >= line; i--) { // *
				// line = 1, i = 1...5
				// line = 2, i = 1...4 
				System.out.print("*");
			}
			System.out.println();
		}
	}


	// 오른쪽 하단이 직각인 직각삼각형.
	static void triangle4(int width) {
		for (int line = 1; line <= width; line++) {

			for (int i = 1; i < line; i++) {  // 공백 
				// line = 1, i = 1
				// line = 2, i = 1..2 
				System.out.print(" ");
			}
			for (int i = width; i >= line; i--) { // *
				// line = 1, i = 1...5
				// line = 2, i = 1...4 
				System.out.print("*");
			}
			System.out.println();
		}
	}
	

	
	// 오른쪽 상단이 직각인 직각삼각형.(별대신 숫자)
	static void triangle5(int width) {
		
		// 알파벳이 이어지도록. 
		int su = 65;
		
		for (int line = 1; line <= width; line++) {
			
			for (int i = 1; i < line; i++) {  // 공백 
				// line = 1, i = 1
				// line = 2, i = 1..2 
				System.out.print(" ");
			}
//			for (int i = width; i >= line; i--) {
//				// line = 1, i = 5...1
//				// line = 2, i = 1...4 
//				System.out.print(i - line + 1);
//			}
			
			for (int i = width; i >= line; i--) {
				System.out.print((char)su++);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int width = 0;
		
		do {
			System.out.println("숫자 1개를 입력하세요");
			System.out.print("한 번의 길이 = ");
			width = stdIn.nextInt();
		}
		while(width <= 0); // 음수 입력시 종료, 양수이면 1번 실행. 
			rectangle(width);
			System.out.println("=====================");
			triangle(width);
			System.out.println("=====================");
			triangle2(width);
			System.out.println("=====================");
			triangle3(width);
			System.out.println("=====================");
			triangle4(width);
			System.out.println("=====================");
			triangle5(width);
		}
}
