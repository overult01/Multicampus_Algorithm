package algorithm;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int data[] = {3, 5, 4, 2, 1};//오름차순  {1, 2, 3, 4, 5}
		//int data[] = {33, 51, 4, 2, 100, 56, 7876,87, 500, 400};
		System.out.println("삽입정렬 이전 =" + Arrays.toString(data));
		insertion(data, data.length);
		//data 객체 매개변수 전달되면 bubble 메소드 내부 data 배열내부 값 변경.
		System.out.println("삽입정렬 이후 =" + Arrays.toString(data));
		

	}//main
	
	static void insertion(int[] a, int n) {
			for(int i = 1; i < n; i++) {
			int j;
			// 1. 정렬되지 않은 데이터 한개를 선택한다
			int tmp = a[i]; //복사
			//System.out.println(" i= " + i + " , tmp = " +  tmp + " 반복");
			System.out.printf(" i= %d , tmp=%d 반복 : " , i, tmp);
			// 2. 정렬된 데이터들 자리 이동(tmp 크면) 반복 ( 4 0 7 8 - 5
			for(j = i; j > 0 && a[j-1] > tmp  ; j--) {
				System.out.printf("현재 a[j-1]값 %d 은 tmp값 %d보다 크므로 자리 밀리는 중 : " , a[j-1], tmp) ;
				a[j] = a[j-1];	
			}
			// 3. 1번 데이터를 2번 빈 자리에 삽입
			a[j] = tmp;
			System.out.println("==밀어내고 삽입 중간결과 : " + Arrays.toString(a));
		}//outer for end	
  
	}

}
