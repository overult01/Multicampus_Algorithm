package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while(true) {
			System.out.println("+ - = 를 입력하세요");
			String selection = sc.next();
			if(selection.equals("+")) {
				queue.add(++num + "번 고객 번호표 발권");
				System.out.println(num + "번 고객 번호표 발권");
			}
			else if(selection.equals("-")) {
				if(!queue.isEmpty()) {
					String result = queue.poll();
					System.out.println(result + " - 업무 처리");
				}
				else {
					System.out.println("대기중인 고객 처리 완료");
				}
				
			} 
			else if(selection.contentEquals("=")) { 
				//queue 내부 데이터 남아있다면 isEmpty() 메소드 판단 
				//그렇다 - 번호표 발권 모든 고객이 처리되지 못했다면 x번 고객 번호표 발권 - 업무 미처리  + " 업무 종료" 출력
				//번호표 발권 모든 고객이 처리되었다면 "업무 종료" 출력
				while(!queue.isEmpty()) {
					System.out.println(queue.poll()  + " - 업무 미처리");
				}
				System.out.println("업무 종료");
				
				
			}
			else {
				System.out.println("잘못된 요청");
				break;
			}
		}

	}

}
