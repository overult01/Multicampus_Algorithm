package algorithm;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int data[] = {1,2,3,3,5,5,4,3,1,1,1,2,3,2,1};//1-5 사이 범위 데이터들만. 동일값 갯수 
		System.out.printf("data 배열은 1-5 범위값 배열 - %s\n" , Arrays.toString(data));
		
		//각 숫자 분포표 저장
		int count[] = new int[5];
		for(int i = 0; i < data.length; i++) {
			count[data[i]-1]++;
		
		}
		System.out.printf("count 배열은 1-5 범위 숫자분포값 배열 - %s\n" , Arrays.toString(count));
		
		for(int i=0; i < count.length; i++) {//5번
			for(int j = 1; j <=count[i] ; j++ ) {//?
				System.out.print( (i+1) +  "  " );
				
			}
		}
	}

}
