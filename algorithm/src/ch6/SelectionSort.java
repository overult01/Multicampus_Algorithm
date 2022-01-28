package ch6;

import java.util.Arrays;

// 정렬
// 1. 선택정렬 
// 하나 정하고 제일 작은 것을 정해서, 제일 작은 것과 비교.
// 기준을 하나 정해서, 제일 작은 것을 찾고, 그 작은 것들과 비교.
public class SelectionSort {

	public static void main(String[] args) {
		int data[] = {4, 3, 1, 5, 2};  // 오름차순으로 정렬.
		System.out.println("선택정렬 이전 = " + Arrays.toString(data));
		bubble(data, data.length);
		// data같은 객체 매개변수가 전달되면, bubble 메서드 내부 data 배열내부 값이 변경된다.
		System.out.println("선택정렬 이후 = " + Arrays.toString(data));
	}

	static void bubble(int[] a, int n) {
		for(int i = 0; i < a.length-1; i++) { //데이터가 n개면, n-1번만 비교하면 된다.
			System.out.println("===" + i + "번 데이터 정렬===" + Arrays.toString(a));
			int min = i;
			for(int j = i + 1; j < a.length; j++) {
				System.out.print("i= " + i + ", j =" + j + ", min= " + min +" 반복중 ");
				System.out.println(Arrays.toString(a));
				
				if(a[i] > a[j]) { // 2개 데이터 정렬.
					int temp = a[i]; // 서로 맞교환.
					a[i] = a[j];
					a[j] = temp;

				}
			}
		}
	}
}
