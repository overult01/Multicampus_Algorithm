package algorithm;

import java.util.Scanner;

public class PrimeNumberTest {

	static boolean isPrime(int num){
		// 1 ~ num 반복
		int cnt = 0;
		for(int i = 3; i < num; i = i + 2) { //1 , 2, 4 , 6, 8-2로 나누어 떨어지는 수
			if(num % i == 0) {
				cnt++; 
			}
		}
		if(cnt == 0 && num%2 == 1) return true;//소수
		return false;

	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("소수인지 판단할 숫자(양수) = ");
		int num = stdIn.nextInt();

		boolean result = isPrime(num);
		if(result) {
			System.out.println(num + ": 소수이다");
		}
		else {
			System.out.println(num + ": 소수가 아니다");
		}
		// 숫자 입력 = 100
		// 2 ~ 100 모든 숫자들 각각이 소수인지 판별하여 소수이면 int [] prime 저장 출력
		// {2, 3, 5, 7, 11, 13, .......}

		//소수 판단되면 배열 저장
		//배열 저장 자동값 - int 0 / String null
		int [] prime = new int[num];
		
		int j = 0;
		for(int i = 2; i <= num ; i++) {
			if(isPrime(i)) { prime[j++] = i; }
		}
		//출력
		for(int i = 0; i < j; i++) {
			/*if(prime[i] != 0)*/ System.out.println(prime[i]);
		}
		
		
	}

}
