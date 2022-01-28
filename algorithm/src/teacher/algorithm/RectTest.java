package algorithm;

import java.util.Scanner;

public class RectTest {

	static void rect(int w) {
		for(int line = 1; line <= w; line++) {//라인수반복 사각형
			for(int i = 1; i <=w; i++) {//1줄출력별반복
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void tri(int w) {
		for(int line = 1; line <= w; line++) {//라인수반복 왼쪽 하단 직각삼각형
			for(int i = 1; i <= line ; i++) {//1줄출력별반복
				//line = 1, i = 1 *
				//line = 1 , i =2 inner for 중단+줄바꿈
				//line = 2 , i = 1 *
				//line = 2,  i = 2 *
				//line= 2, i= 3 inner for 중단+줄바꿈
				//....
				//line = w, 
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("=======================");
		
		for(int line = 1; line <= w; line++) {//라인수반복 왼쪽 상단 직각삼각형
			for(int i = w; i >= line ; i--) {//1줄출력별반복(w(고정)  - line(반복 변경)  + 1)
				//line=1 i=5 *
				//line=1 i=4 *
				//line=1 i=3 *
				//line=1 i=2 *
				//line=1 i=1 *
				//line=1 i = 0 inner for end + 줄바꿈
				
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("=======================");
		
		for(int line = 1; line <= w; line++) {//라인수반복 오른쪽 하단 직각삼각형
			for(int i = w; i > line ; i--) {// w=5 공백(4,3,2,1, 0)  + *(1,2, 3,4,5) 출력
				System.out.print(" ");
			}
			for(int i = 1; i <= line ; i++) {// w=5 공백(4,3,2,1, 0)  + *(1,2, 3,4,5) 출력
				System.out.print("*");
			}		
			System.out.println();
		}
			
		System.out.println("=======================");
		
		for(int line = 1; line <= w; line++) {//라인수반복 오른쪽 상단 직각삼각형
			for(int i = 1; i < line ; i++) {// w=5 공백(0,1,2,3,4)  + *(5,4,3,2,1) 출력
				System.out.print(" ");
			}
			for(int i = w; i >= line ; i--) {
				System.out.print("*");
			}		
			System.out.println();
		}
			
	
	
	System.out.println("=======================");
	
	int su = 65;
	for(int line = 1; line <= w; line++) {//라인수반복 오른쪽 상단 직각삼각형
		for(int i = 1; i < line ; i++) {// w=5 공백(0,1,2,3,4)  + *(5,4,3,2,1) 출력
			System.out.print(" ");
		}
		for(int i = w; i >= line ; i--) {
			System.out.print((char)su++);
		}		
		System.out.println();
	}
		

}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		while(true) {
			System.out.println("숫자 1개를 입력하세요");
			System.out.print("한변의 길이 = "); // 5
			int width = stdIn.nextInt();
			//음수 이거나 0 입력시 종료
			if(width <= 0 ) {break; }
			rect(width);
			System.out.println("===================");
			tri(width);
		}//while end

	}

}


