package ch6;

import java.util.Arrays;

// 정렬
// 1. 버블정렬 
// 인접한 데이터들끼리 비교 후 위치를 교환하여 정렬.
// 데이터 개수가 n개이면, n-1번만큼 비교하여 정렬이 일어난다.
// 단점은 너무 정렬이 많이 일어난다는 것이다. 이미 정렬이 된 상태인 데이터라도 정렬해서 비효율적이다.
public class BubbleSort {

	public static void main(String[] args) {
		int data[] = {4, 5, 2, 3, 1};  // 오름차순으로 정렬.
		System.out.println("버블정렬 이전 = " + Arrays.toString(data));
		bubble(data, data.length);
		// data같은 객체 매개변수가 전달되면, bubble 메서드 내부 data 배열내부 값이 변경된다.
		System.out.println("버블정렬 이후 = " + Arrays.toString(data));
	}

	static void bubble(int[] a, int n) {
		for(int i = 0; i < a.length -1; i++) { //4번만 비교하면 된다. 마지막은 어차피 정렬 되어있으므로.
			for(int j = 0; j < a.length - i -1; j++) {
				// 오름차순: a[j] > a[j+1]. 앞의 값이 더 클 경우 맞교환.
				// 내림차순: a[j] < a[j+1]. 뒤의 값이 더 클 경우 맞교환.
				System.out.print("i= " + i + ", j =" + j + " 반복중 ");
				if(a[j] > a[j+1]) {
					int temp = a[j]; // 서로 맞교환.
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			System.out.println(Arrays.toString(a));
			}
		}
	}
	
	
}
