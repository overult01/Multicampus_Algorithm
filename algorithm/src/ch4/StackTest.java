package ch4;

import java.util.Scanner;
import java.util.Stack;

// 스택(LIFO)
public class StackTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		// java.util패키지의 Stack클래스 사용.
		Stack<Integer> stack = new Stack();
		
		// peek: 제거하지 않고 꼭대기의 데이터를 보여주기만 한다. 
		// stack이 비어있으므로 peek를 가져오지 않는다. 
		if (stack.isEmpty() == false) { 
			System.out.println("마지막 푸시 데이터= " + stack.peek());  // java.util.EmptyStackException
		}

		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		System.out.println("데이터 푸시 종료");

		if (stack.isEmpty() == false) { 
			System.out.println("마지막 푸시 데이터= " + stack.peek());  // java.util.EmptyStackException
		}
		
		// 데이터 삭제 시작
		System.out.println("데이터 팝 시작");
		
		while(!stack.isEmpty() /*스택이 비어있지 않으면*/) {
			int value = stack.pop(); // 스택의 데이터를 보여주면서 삭제.	
			System.out.println(value);
			
/* 데이터를 푸시했던 순서와 반대로 팝되었음을 확인.
8
7
6
5

  */			
			
		}
		System.out.println(stack.size());  // 스택은 리스트 계열이므로 size메서드도 리스트계열에서 상속받았다.
	}

}
