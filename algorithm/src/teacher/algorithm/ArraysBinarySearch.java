package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysBinarySearch {

	public static void main(String[] args) {
		int [] data = {6, 4, 3, 2, 1, 5, 8};	
		//api 배열 정렬 api
		Arrays.sort(data);//data 배열 내부  오름차순 정렬 변경(자연정렬)

		
		//data 전체내용 출력
		System.out.println(Arrays.toString(data));
		
		int target = 5;
		int index = Arrays.binarySearch(data, target);
		//index < 0 - 못찾음
		System.out.println(target + " 을 " + index + " 위치에서 찾았음");
		// 내림차순 정렬 또는 사용자정렬기준 정하여 구현
		
		//Comparator
		//class A implements Comparator{
		//	   compare(){ A 객체들 사용자 정의 정렬 순서 구현  }
		//	}

	}

}
