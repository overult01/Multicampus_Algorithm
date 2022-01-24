package ch3;
// Comparator 인터페이스 : 객체의 대소관계 비교 기준을 직접 지정하기.
import java.util.Arrays;
import java.util.Comparator;

class MyStringSort implements Comparator<String> { // String 배열의 정렬 기준에 사용 
	@Override
	public int compare(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);  // 대소비교를 하는데 대소문자 무시하고 비교.
		// 	대소문자 무시하고 비교
		// s1 == s2 이면 0
		// s1 > s2 이면 1 (순서 교환x, 다음 인덱스로 이동)
		// s1 < s2 이면 -1 (순서 교환, 다음 인덱스로 이동)
	}

}

class MyArraySort implements Comparator<int[]> { // int[][] 배열의 정렬 기준에 사용.
	@Override
	public int compare(int[] arr1, int[] arr2) {
		// 1차원 배열의 데이터 갯수가 작은 것부터 큰 순서대로 정렬하도록 지정.
		if(arr1.length > arr2.length) return 1; // 뒤에 것이 더 작으므로 순서를 바꿔야 한다.
		else if(arr1.length < arr2.length) return -1;
		else return 0; // 같으면 0.
	}

}


public class ArraySortComparator {

	public static void main(String[] args) {
		String[] data = {"test", "TEST", "test123", "Test123", "가나다"};
		Arrays.sort(data); // 문자열 자연정렬. (숫자는 오름차순이었다)
		// 대문자가 소문자보다 우선한다. 
		System.out.println(Arrays.toString(data));  // [TEST, Test123, test, test123, 가나다]

		// 문자열 자연정렬 변형. 대소문자 구분하지 않게.
		Arrays.sort(data, new MyStringSort()); // 내가 지정한 정렬방법 확인하려고. (대소문자 무시) 
		// data는 String 배열이어야 하고, MyStringSort는 String 타입의 데이터비교가 구현되어 있어야 한다.
		
		System.out.println(Arrays.toString(data));  // [TEST, test, Test123, test123, 가나다]
		
		// 2차원 배열 
		int[][] data2 = {{1, 2, 3}, {4, 5, 6, 7, 8 , 9}, {10, 11, 12}};
		
		// 오류
		// Arrays.sort(data2); // 2차원 배열 안에는 1차원 바열이 있다. 자바에서는 이렇게 2차원 안의 1차원 배열을 정렬할 수 있는 방법이 없다.

		Arrays.sort(data2, new MyArraySort());
		
		for( int[] one : data2) {
			System.out.println(Arrays.toString(one));
		}
		/*
		[1, 2, 3]
		[10, 11, 12]
		[4, 5, 6, 7, 8, 9]
		*/
	}

}
