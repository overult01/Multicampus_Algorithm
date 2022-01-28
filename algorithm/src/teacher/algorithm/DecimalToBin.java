package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class DecimalToBin {
	static String[]  toBin(int decimal, int base){
		String [] remains = new String[30];  
		int index = 0;
		while(true) {
			int remain = decimal % base; // 10->A 11->B 12->C 13 14 15 ->f
			decimal = decimal / base;
			
			// A- 65--> (char)(remain+55)
			if(remain >= 10 && remain <= 15) {
				remains[index++] = String.valueOf((char)(remain+55));
			}
			else {
				remains[index++] = String.valueOf(remain);
			}
			if(decimal == 0) break;
		}
		return remains;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("무슨진수로 변환 = ");
		int base = stdIn.nextInt();//8		
		System.out.println("해당진수로 변환할 십진수 = ");
		int count = stdIn.nextInt();//12
		
		//이진수메소드구현
		String[] result = toBin(count, base);
		
		//결과 출력
		for(int i = result.length-1 ; i >= 0; i-- ) {
			if(result[i] != null) System.out.print(result[i]);//1100
		}
		System.out.println();
		System.out.println(Integer.toHexString(count));//16진수
		

	}

}
