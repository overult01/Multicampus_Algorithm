package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 스택 실습
// 괄호 짝 맞는지 확인하는 예제.
public class PairStackTest {
public static void main(String args[]) {
	// 괄호짝찾기에 적용  . {} () []
	String s= "{[()]}";//t
	System.out.println(isPair(s));//true
	s= "{}[]()";//t
	System.out.println(isPair(s));
	s= "{{[]()[]{}}";//f
	System.out.println(isPair(s));
	s = "{[}](}";//f
	System.out.println(isPair(s));
	}


// 괄호가 제대로 닫혔는지 확인하는 메서드
static boolean isPair(String s) {
	
	Stack<String> stack = new Stack<String>(); // 빈 스택
	
	for(int i = 0; i < s.length(); i++) {
		String t = s.substring(i, i+1); // substring(시작, 끝) : 한글자씩 분리.
		
		if (stack.isEmpty()) {
			stack.push(t);
		}
		else if (stack.peek() == "{") {
			
		}
		
		if(t.equals("{") || t.equals("[")  || t.equals("(")) {
			stack.push(t);
			System.out.println(t);
		}
		else {  // if(one.equals("}") || one.equals("]")  || one.equals(")"))
//			String delone = stack.pop(); // 이게 문제야 
			
			if (t.equals("}")) {
				if(stack.peek() != "{") return false;
				else stack.pop();
			}
			
			else if (t.equals("]")) {
				if(stack.peek() != "[") return false;
			}
			
			else {
				if(stack.peek() != "(") return false;
			}
		}
	}


		// for문을 다 돌았는데 스택이 비어있으면 모두 짝이 맞는 것.
		if(stack.isEmpty()) {
			return true;}
		else { 
			return false;} // for문을 다 돌았는데 스택이 남으면 짝이 안맞는 것.(1개 이상의 오픈괄호가 남은 것)	
	}

}

/* 오픈괄호 stack 저장한다
 * 클로즈괄호 나오면("}" ) -->  stack 추출하여 "{" 일치 검사
 *   클로즈괄호 나오면("]" ) -->  stack 추출하여 "[" 일치 검사
 *    클로즈괄호 나오면(")" ) -->  stack 추출하여 "(" 일치 검사
 * */
