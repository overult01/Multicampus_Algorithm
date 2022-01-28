package algorithm;

public class GcdTest {

	public static void main(String[] args) {
/*		int a=12;
		int b=18;
		for(int i = 1; i <= a; i++) {
			if(a % i == 0) {
				System.out.println(i + " 는 " + a + " 의 약수");
			}
		}
		for(int i = 1; i <= b; i++) {
			if(b % i == 0) {
				System.out.println(i + " 는 " + b + " 의 약수");
			}
		}
		for(int i = 1; i <= a; i++) {
			if(b % i == 0 && a % i == 0) {
				System.out.println(i + " 는 " +  a + " 와 " + b + " 의 공약수");
			}
		}
		// 두 수의 공약수 규칙
		// 18 - 12 = 6 , 12 - 6 = 6,  6- 6=0
		//두 수 최대값 찾기
		int max , min ; 
		if(a > b) {
			max = a;
			min = b;
		}
		else {
			max = b;
			min = a;
		}
		*/
		
		int max = 248;
		int min = 24;
		//두 수 최대공약수 방법1
		while(true) {
			System.out.println(max + ":" + min);
			int temp = max - min;
			if(temp == 0) break;
			if( temp < min ) {
				max = min;
				min = temp;
			}
			else {
				max = temp;
			}
		}
		
		System.out.println("최대공약수=" + max);
		
		
		//두 수 최대공약수 방법2
		max = 248;
		min = 24;
		
		while(true) {
			System.out.println(max + ":" + min);
			int temp = max % min;
			if(temp == 0) break;
			max = min;
			min = temp;
		}//재귀호출로 변경
		
		System.out.println("최대공약수=" + min);
		System.out.println("최대공약수(재귀호출법)=" + gcd(248, 24));
		
	}//main
	//두 수 최대공약수 방법3
	static int gcd(int max, int min) {
			System.out.println(max + ":" + min);
			int temp = max % min;
			if(temp == 0) return min;//종료조건
			return gcd(min, temp);
	}

}
