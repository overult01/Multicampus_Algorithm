package test;

import java.util.Scanner;
import java.util.Stack;

// 최소 개수로 잔돈받기

public class MoneyChangeTest {

	static Stack<Integer> coinStack = new Stack<Integer>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("지불할 돈: ");
		int money = sc.nextInt(); // 내가 낸 돈.
		
		System.out.println("가격 입력: ");		
		int price = sc.nextInt(); // 상품가격.
		
		// 잔돈 총액 계산
		int mymoney = money - price;
		System.out.println(mymoney);
		
		int[] coins = {10, 50, 100, 300, 500};
		for(int i : coins) {
			coinStack.push(i);
		}
		charge(mymoney, 0); //
	}
	
	static int charge(int mymoney, int count) {
		if (!coinStack.isEmpty()) {
			int coinValue = coinStack.pop();
			int coinCount = mymoney / coinValue;
			int totalCount = coinCount + count;
			System.out.println(coinValue + "원 동전은 " + coinCount + "개 받습니다.");
			if(mymoney == 0) return totalCount;
			return charge(mymoney % coinValue, totalCount);
			
		}
		return mymoney;
	}
}
