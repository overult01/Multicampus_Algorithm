package test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int w = stdIn.nextInt();
		
		for(int line = 1; line <= w; line++) { // 라인 수 만큼 반복
			// 라인의 공백
			for(int space = w - line; space > 0; space --) {
				System.out.print(" ");
			}
			// 라인에 * 반복
			for(int star = 1; star <= 2*line - 1; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		정삼각형 별 출력
		5 입력
		        *
		       ***
		      *****
		     *******
		    *********
		
		5가 입력되었으면
		1번줄: 공백 4개, 별 1개
		2번줄: 공백 3개, 별 3개
		3번줄: 공백 2개, 별 5개
		
		i번줄 == > 공백 5-i, 별 2*i -1
		*/

	}

}
