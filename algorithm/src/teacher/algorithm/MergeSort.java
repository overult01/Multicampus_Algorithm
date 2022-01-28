package teacher.algorithm;

import java.util.Arrays;

public class MergeSort {
	static int[] buff ; 
	public static void main(String[] args) {
		//int data[] = {2, 5 ,4, 1, 3};//오름차순  {1, 2, 3, 4, 5}
		int data[] = {33, 51, 4, 2, 100, 56, 7876,87, 500, 400};
		
		System.out.println("병합정렬 이전 =" + Arrays.toString(data));
		merge(data, data.length);
		//data 객체 매개변수 전달되면 bubble 메소드 내부 data 배열내부 값 변경.
		System.out.println("병합정렬 이후 =" + Arrays.toString(data));
	}//main
	
	static void merge(int[] a, int n) {
		buff =new int[n];
		_merge(a, 0, n-1);
		buff = null;
	}

	static void _merge(int[]a, int left, int right) {
		//1개그룹 분할
		if(left < right) {
			int i;
			int center = (left+right)/2;
			int p = 0;
			int j = 0;
			int k = left;
			
			_merge(a, left, center);
			_merge(a, center+1, right);
			
		//합병 정렬
		//buff 합병하면서 정렬배열, 	a배열 분할배열
		//a[] 왼쪽 반만 저장
		for(i = left; i <=center; i++ ) {
			buff[p++] = a[i];
		}
		
		while(i <= right && j < p) {//a[]오른쪽 반
			a[k++]=buff[j] <= a[i] ? buff[j++]:a[i++];
			//buff에 a배열 왼쪽반  < 배열 오른쪽 반  
		}
		
		while(j < p) {
			a[k++] = buff[j++];//남아있는 내용들 복사
		}
		System.out.printf("left=%d , right=%d 일때 합병 중간 결과=%s\n", left, right, Arrays.toString(a));	
		
		}
	}
}

