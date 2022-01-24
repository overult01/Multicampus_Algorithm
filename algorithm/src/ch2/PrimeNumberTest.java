package ch2;
// 기본 자료구조 
import java.util.Scanner;

//소수(prime) : 자기자신과 1로만 나누어지는 2 이상의 자연수 
// 2 3 5 7 11 13 17 19 23 ..

public class PrimeNumberTest {

	static boolean isPrime(int num) {
	
		// 1~ num 반복해서 나눈다.
//		int cnt = 0;
//		for(int i = 0; i <= num; i++) {
//			if(num % i == 0) {
//				cnt++;  // 나머지가 0일 때마다 cnt +1 
//			}
//		}
//		
//		// 자기자신, 1만 나누어지는지 확인.
//		if (cnt == 2 ) return true;  // 1문장 밖에없으면 괄호 생략가능.
//		return false;
		
//		2~ num-1 반복해서 나눈다.
		int cnt = 0;
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				cnt++;  // 나머지가 0일 때마다 cnt +1 
			}
		}
		
		// 자기자신, 1만 나누어지는지 확인.
		if (cnt == 0 ) return true;  // 1문장 밖에없으면 괄호 생략가능.
		return false;

		
		

	}	
	
	
	// 2~n 모든 숫자들 각각이 소수인지 판별하여 소수이면 int[] prime에 저장하고 출력.
	// 사실은 가변길이가 되는 list가 되는 것이 좋다. 
	static int[] allPrime(int rangenum) {
		
		int[] allprime = new int[rangenum]; 
		int index = 0;
		
		// 2이상의 수만 체크 
		for (int num = 2; num <= rangenum; num++) {
				
			// 소수인지 판별
			int cnt = 0;
			for (int i = 2; i < num-1; i++) {
				if(num % i == 0) cnt++;
			}
			// 소수만 배열에 넣기. 
			if (cnt == 0) {
				allprime[index] = num;
				index++;
			}

		}
		
		return allprime; // int[] 의 없는 값은 0으로 출력.
	}
	
	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int num = stdIn.nextInt();
//		
//		boolean result = isPrime(num);
//		if (result) {
//			System.out.println(num + "소수이다");
//		}
//		else {
//			System.out.println(num + "소수가 아니다");			
//		}
//		
		// 소수 배열 
		// 숫자입력 = n
		Scanner stdIn = new Scanner(System.in);
		int rangenum = stdIn.nextInt();
		int[] allprime = allPrime(rangenum);
		System.out.println("===소수출력===");
		for(int prime : allprime) {
			System.out.println(prime);
		}
		
		
		
		// 강사님 코드 
//		int[] prime = new int[num];
//		for(int i = 2; i <= num; i ++) {
//			if(isPrime(i)) {
//				prime[j++] = i;
//			}
//		}
	}

}
