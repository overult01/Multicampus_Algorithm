package algorithm;

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
static boolean isPair(String s) {
	
	/* 오픈괄호 stack 저장한다
	 * 클로즈괄호 나오면("}" ) -->  stack 추출하여 "{" 일치 검사
	 *   클로즈괄호 나오면("]" ) -->  stack 추출하여 "[" 일치 검사
	 *    클로즈괄호 나오면(")" ) -->  stack 추출하여 "(" 일치 검사
	 * */
	return false;
}
}
