package ch4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 큐(FIFO)
// 인큐, 디큐가 다 통로에서 이뤄진다. 
public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();  // LinkedList로도 큐를 사용할 수 있다.

		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		
		while(true) {
			System.out.println("+, -, = 중 하나를 입력하세요 ");
			String selection = sc.next();  
			if (selection.equals("+")) {
				queue.add(++cnt +"번 고객 번호표 발권");   // 가장 마지막인 rear에 데이터가 저장된다.
				System.out.println(cnt +"번 고객 번호표 발권");
			}
			else if(selection.equals("-")) {
				if (queue.isEmpty()) {
					System.out.println("이미 모두 처리 완료, 업무 종료");
					break;
				}
				else {
					String result = queue.poll(); // 가장 앞에있는 front 데이터 삭제.
					System.out.println(result + "- 업무 처리");
				}
			}
			else if (selection.contentEquals("=")) {
				// 번호표를 발권한 모든 고객이 처리되었다면 "업무종료"출력			
				// 만약 처리가 남았다면, X번 고객 번호표 발권 - "업무 미처리" 출력
				// queue내부에 데이터가 남아있는지는 isEmpty로 확인.
				while (!queue.isEmpty()) {
					System.out.println(queue.poll() + " - 업무미 처리");
					}
				System.out.println("번호표 모두 처리, 업무종료.");
				break;
			}
			
			else {
				System.out.println("잘못된 요청");
				break;
			}
		}
		
	}

}
