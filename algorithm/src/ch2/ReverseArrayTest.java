package ch2;
// 배열에서의 역순 정렬(원래 순서를 뒤집어서. 값의 크기와는 무관) 
import java.util.Scanner;

// 순서
// 1. 배열 length/2 반복
// 2. 중앙을 기준으로 나누어서, [0] 값은 [length -1]과 교환, [1]값은 [length - 2]와 교환.. 가운데 만나면 종료.
// 3. 즉 교환 횟수는 버림(length/2).
// 주의 ) 값 교환할 때 임시 저장 변수 만들기 주의.
public class ReverseArrayTest {
	static void reverse(int[] data) {
		// 어떤 변수들을 키보드로 입력받았는지 확인. 지정한 숫자가 넘어가면 안받는다. 
		System.out.println("===max메서드 내부===");
		for(int i = 0; i < data.length; i++) { // 이 반복문은 length -1 만큼 반복한다. 
			System.out.println("data[" + i + "]=" + data[i]);
		}
		
		System.out.println();
		
		// 원래 배열을 역순으로 뒤집기.
//		for (int i = 0; i < data.length/2; i++) { // 5개를 넣었을 때, 5/2 = 2(자바에서는 정수/정수=정수) 
//			int temp = data[i];  // 데이터 맞교환시 임시 저장 변수;
//			data[i] = data[data.length -i -1]; // 0번 인덱스 자리에 마지막값 [length -1 ] 넣음.
//			data[data.length - i - 1] = temp;  // 배열의 마지막자리에 0번 인덱스 복사.		
//		}
		
		for(int i = 0; i < data.length/2; i++) {
			new ReverseArrayTest().swap(data, i, data.length - i - 1);
		}
		
//		return data;  --> call by value 매개변수가 바뀌었으므로 메인에서도 그 바뀐 데이터의 주소값을 전달받아 같은 내용이 출력된다. 
//		return 다른배열;  // 만약 메서드 결과로 다른 배열을 리턴해야 하면 리턴 필수.
	}
	
	void swap(int [] arr, int i, int j) {  // arr 배열 매개변수 전달 변경되면 호출된 메서드 변경 내용을 반영.
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void main(String[] args) {
		// 데이터를 입력받는 부분
		Scanner stdIn = new Scanner(System.in);
		System.out.println("숫자 개수 = "); // 5개 
		int count = stdIn.nextInt();
		stdIn.nextLine(); // 아래의 println의 엔터를 위해
		
		System.out.println("역순으로 찾을 숫자들 = "); //(println:엔터1) 1 5 67 18 88 (엔터2)
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
		
		// 역순으로 정렬하기 
		reverse(numInt);
		
		// call by value: 기본형 + 참조형 매개변수 전달할 때.
		// 참조형 주소값을 복사해서 전달하면 data, numInt가 같은 주소의 동일 배열 객체를 참조하게 된다. 
		System.out.println("===메인 메서드 내부===");
		for(int i = 0; i < numInt.length; i++) { // 이 반복문은 length -1 만큼 반복한다. 
			System.out.println("numInt[" + i + "]=" + numInt[i]);
		}

	}

}
