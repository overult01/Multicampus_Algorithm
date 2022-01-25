package ch5;
// 재귀함수
// 팩토리얼, 반복문 비교
public class FactorialTest {

	public static void main(String[] args) {
		System.out.println("5!(반복문)=" + fact1(5));
		System.out.println("5!(재귀호출)=" + fact2(5));

	}
	
	// 방법1: 반복문 
	static int fact1(int num) {
		int result = 1; // 각각 누적곱
		for(int i = 1; i <= num; i++) {
			result = result * i;
		}
		System.out.println("===" + num + "일 때 fact1 종료===");
		return result;
	}
	
	// 방21: 재귀호출 (반복문과 동일한 결과)  	
	static int fact2(int num) {
		// num 변경하여 같은 메서드 계속 호출 
		System.out.println("===" + num + "일 때 fact2 시작===");
		// 종료조건
		if (num == 0 || num == 1) return 1;
		System.out.println("===" + num + "일 때 fact2 종료===");
		return num * fact2(num-1); // 재귀 호출
	}
}
