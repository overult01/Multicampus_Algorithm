package test;

import java.util.Scanner;
import java.util.Stack;

/*- 잔돈 받기
2000원 내고 물건을 샀다.
1350원짜리 물건이다.
잔돈 받자
650원 – 500원 1개, 100원 1개, 50원 1개
2830원 – 500원 5개 , 300원 1개, 10원 3개
int[] coins = {10, 50, 100, 300, 500}; (잔돈 종류)
int money = 2000; 내가 낸돈
int price = 1350; 상품 가격

잔돈 계산하여 잔돈 갯수를 최소화하여 받자
출력예) 650원 – 500원 1개, 100원 1개, 50원 1개
출력예) 2830원 – 500원 5개 , 300원 1개, 10원 3개


*/
public class CoinCharge {

	static Stack<Integer> coinStack = new Stack();
	
	public static void main(String[] args) {
		//키보드 내가 낸 돈 , 상품가격 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("내가 낸 돈 : ");
		int money = sc.nextInt();
		System.out.println("상품 가격 : ");
		int price = sc.nextInt();
		// 잔돈 총액 계산
		int mymoney = money - price;
		System.out.println(mymoney);
		
		int[] coins = {10, 50, 100, 300, 500};//오름차순정렬
		for(int i : coins ) {
			coinStack.push(i);//5개
		}
		System.out.println("총동전갯수는= " + charge(mymoney, 0));//동전갯수 0 
	}//main end
	
	// 잔돈 총액 charge(잔돈총액) 전달
	static int charge(int mymoney, int count) {
			//stack pop isEmpty
			int coinValue = coinStack.pop();
			int coinCount = mymoney / coinValue;//500, 300, 100, 50, 10.... 동전 갯수
			int totalCount = coinCount + count;
			System.out.println(coinValue+ " 원 동전은 " + coinCount + " 개 받습니다.");
			if(mymoney == 0) { return totalCount; }
			return charge(mymoney % coinValue , totalCount );
			
			
		}//charge end


}












