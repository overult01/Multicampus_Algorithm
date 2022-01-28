package algorithm;

import java.util.Scanner;

public class Max3 {
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("숫자 4개를 입력하세요");
		System.out.print("a= ");
		int a = stdIn.nextInt();
		System.out.print("b= ");
		int b = stdIn.nextInt();
		System.out.print("c= ");
		int c = stdIn.nextInt();
		System.out.print("d= ");
		int d = stdIn.nextInt();
		
		int max = a;//기준값
		System.out.println("max 최초값 =" + max);
		if(b > max) { 
			max = b; 
			System.out.println("max 변경값 =" + max);
		}
		if(c > max) {
			max = c;
			System.out.println("max 변경값 =" + max);
		}
		if(d > max) {
			max = d;
			System.out.println("max 변경값 =" + max);
		}
		System.out.println("최대값=" + max);
		
	}
}
