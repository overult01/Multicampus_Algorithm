package ch2;
// 10진수 -> 2진수 
// 10진수 -> n진수 

import java.util.Scanner;

public class DecimalToBin {

	// 메서드 (16진수 까지)
	static String[] toBin(int oldnum, int newnum) {
		String[] remains = new String[30];  // 임의의 크기. 
		int index = 0;
		while(true) {
			int remain = oldnum % newnum; // 나머지
			
			// 16진수 
			if(newnum == 16) {
				if( 10 <= remain && remain <= 15 ) {
					remains[index++] = String.valueOf((char)(remain + 55)); // A: 65 // int -> char -> String  
				}
				else {
					remains[index++] = String.valueOf(remain);
				}
			}
			oldnum = oldnum / newnum; // 몫 
// 나중에 여러 진수 변환하려고 String 배열에 저장. 
			if (oldnum == 0) break;
		}
		return remains;
	}
	
	
	public static void main(String[] args) {
		// 데이터를 입력받는 부분
		Scanner stdIn = new Scanner(System.in);
		System.out.println("변환할 10진수 = "); 
		int oldnum = stdIn.nextInt();
		System.out.println("변환하고 싶은 진수 = "); 
		int newnum = stdIn.nextInt();

		// 이진수 메서드 구현
		String[] result = toBin(oldnum, newnum);
		
		// 결과 출력(나머지를 생성된 거꾸로 해야 결과가 나오므로. )
		for(int i = result.length-1; i >=0; i--) {
			if (result[i] != null) {
			System.out.print(result[i]);
			}
		}
		System.out.println();
		System.out.println("API의 16진수: " + Integer.toHexString(oldnum));
	}

}
