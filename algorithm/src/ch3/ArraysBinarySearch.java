package ch3;

import java.util.Arrays;

// 자바 api활용 (정렬 : Arrays.sort, 이진검색: Arrays.binarySearch)
public class ArraysBinarySearch {

	public static void main(String[] args) {

		int[] data = {6, 4, 3, 2, 1, 5, 8};
		// api사용해서 배열 정렬
		Arrays.sort(data); // 리턴타입 없이 배열을 정렬해준다. 

		// data전체내용 출력(for문 없이) 
		System.out.println(Arrays.toString(data));
		int target = 15;

		int index = Arrays.binarySearch(data, target);
		// index < 0 : 못찾음. 만약 0외 다른 값은 그 위치에서 찾았다.
		System.out.println(target + "을 " + index + "위치에서 찾았다.");
		
	}

}
