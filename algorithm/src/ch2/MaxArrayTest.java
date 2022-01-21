package ch2;
// 배열에서의 최대값 찾기 
import java.util.Scanner;

public class MaxArrayTest {
	static int max(int[] data) {
		// 어떤 변수들을 키보드로 입력받았는지 확인. 지정한 숫자가 넘어가면 안받는다. 
		System.out.println("===max메서드 내부===");
		for(int i = 0; i < data.length; i++) { // 이 반복문은 length -1 만큼 반복한다. 
			System.out.println("data[" + i + "]=" + data[i]);
		}
		
		
		
		// max 초기값 세팅
		int max = data[0];
		System.out.println("max 최초값= " + max);
		// data 배열 중에서 최대값 리턴		
		for(int i = 1; i < data.length; i++) { // 이 반복문은 length -1 만큼 반복한다. 
			if(data[i] > max) {
				max = data[i];
				System.out.println("max 변경값 = " + max);
			}
		}

		for(int i = 1; i < data.length; i++) { 
			if(data[i] > max) {
				max = data[i];
				System.out.println("max 변경값 = " + max);
			}
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		System.out.println("숫자 개수 = "); // 5개 
		int count = stdIn.nextInt();
		stdIn.nextLine(); // 아래 println의 엔터를 위해
		
		System.out.println("최대값을 찾을 숫자들 = "); //(println:엔터1) 1 5 67 18 88 (엔터2)
		String line = stdIn.nextLine(); //nextLine(): 엔터가 나올 때까지 한 줄을 읽어온다.
		stdIn.close();
		// 읽어온 값을 공백 기준으로 분리  
		String[] number = line.split(" ");  
		// 정수 변환
		int[] numInt = new int[count];
		// numInt배열로 입력값을 정수로 담기
		for(int i = 0; i < count; i ++) {
			numInt[i] = Integer.parseInt(number[i]);
		}
		
		int result = max(numInt);
		System.out.println("==최대값 : " + result + "==");
		
		// call by value: 기본형 + 참조형 매개변수 전달할 때.
		// 참조형 주소값을 복사해서 전달하면 data, numInt가 같은 주소의 동일 배열 객체를 참조하게 된다. 
		System.out.println("===메인 메서드 내부===");
		for(int i = 0; i < numInt.length; i++) { // 이 반복문은 length -1 만큼 반복한다. 
			System.out.println("numInt[" + i + "]=" + numInt[i]);
		}

	}

}
