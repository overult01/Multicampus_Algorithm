package algorithm;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int data[] = {4, 2, 3, 5, 1};//오름차순  {1, 2, 3, 4, 5}
		System.out.println("선택정렬 이전 =" + Arrays.toString(data));
		selection(data, data.length);
		//data 객체 매개변수 전달되면 bubble 메소드 내부 data 배열내부 값 변경.
		System.out.println("선택정렬 이후 =" + Arrays.toString(data));
		

	}//main
	
	static void selection(int[] a, int n) {
		for(int i = 0;  i < a.length-1; i++) {// i는 각 반복시마다 a[min]이 위치해야 할 자리임.
			System.out.println("===" + i + " 번 데이터 정렬 === " + Arrays.toString(a));
			int min = i;
			for(int j = i+1; j < a.length ; j++) {//각 데이터들을 a[min]과 비교하여 작은값을 앞쪽에 저장
				if(a[j] <  a[min]) {// 2개 데이터 비교 정렬
					min = j;//min 변경
				}//if end
				System.out.print("i=" + i + " , j=" + j + ", min= " + min + " 반복중 ");
				System.out.print(Arrays.toString(a));
				//여기까지 수행하면 a[min]이 주어진 대상에서 가장 작으므로 가장 앞자리와 교환. a[min] == a[i] 상황일 수도 있음
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
				System.out.println(" -> " + Arrays.toString(a));	
			}//inner for end
		}//outer for end
  
	}

}
