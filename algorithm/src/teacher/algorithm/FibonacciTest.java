package algorithm;

public class FibonacciTest {

	public static void main(String[] args) {
		//1 1 2 3 5 8 13 21 34 55
		int result = 0;
		int i1 = 1;
		int i2 = 1;
		System.out.print(i1 + " , " + i2 + " , ");
		for(int i = 3; i <= 10; i++) {
			result = i2 + i1;
			i2 = i1;
			i1 = result;
			System.out.print(result + " , ");
			
		}
		System.out.println();
		
		//fibo(10);
		System.out.println(fibo(10));
		
		System.out.println((int)'*');
	}

	
	static int fibo(int su) {
		System.out.println("=== " + su + " 일 때 fibo 시작===");
		if( su == 1 || su == 2) {return 1; }
		System.out.println("=== " + su + " 일 때 fibo 시작===");
		return fibo(su - 1) + fibo(su - 2);
	}
	
	static int fiboBottomUp(int su) {
		System.out.println("=== " + su + " 일 때 fibo 시작===");
		if( su == 1 || su == 2) {return 1; }
		System.out.println("=== " + su + " 일 때 fibo 시작===");
		return fibo(su - 1) + fibo(su - 2);
	}
	
}
