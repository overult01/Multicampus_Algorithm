package test;

import java.util.Scanner;
import java.util.Stack;

//스택 실습
//괄호 짝 맞는지 확인하는 예제.

public class MyStackTest_Pair {
	public static void main(String args[]) {
	Scanner key = new Scanner(System.in);
	System.out.println("값을 입력하세요");
	String line = key.nextLine();
	String data [] = line.split(" ");
	

	// 괄호짝찾기에 적용
	String s= "{[()]}";//t
	//String s= "{}[]()";//t
	//String s= "{{[]()[]{}}";//t
	//String s = "{[}](}";//f

	Stack<String> st = new Stack<String>();
	boolean search = false;
	for(int i = 0; i < s.length(); i++) {//종료조건 주의!.substring은 (시작위치, 끝위치이전)
		String one = s.substring(i, i+1);
		if(one.equals("{") || one.equals("[") || one.equals("(")) {
			st.push(one);
			System.out.println(one + " 저장됨");
		}
		else if(one.equals("}") && !st.isEmpty()) {
			String pop = st.pop();
			System.out.println(pop);
			if(pop.equals("{")) { search = true ;System.out.println("{}매칭");}
		}
		else if(one.equals("]")  && !st.isEmpty()) {
			String pop = st.pop();
			System.out.println(pop);
			if(pop.equals("[")) { search = true ;System.out.println("[]매칭");}
		} 
		else if(one.equals(")")  && !st.isEmpty()) {
			String pop = st.pop();
			System.out.println(pop);
			if(pop.equals("(")) { search = true ;System.out.println("()매칭");}
		}
	}//for 
	if(!st.isEmpty()) {search = false;}
	if(!search) {System.out.println("노매칭");}


	}
}
