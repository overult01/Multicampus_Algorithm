package algorithmProject1;

import java.util.Scanner;
// 퀵정렬을 활용한 역순 정렬.
// 최종 
public class QuickSort {
	
	// 배열요소 a[idx1]와 a[idx2]의 값을 바꾼다.
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1]; 
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	// 퀵정렬
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 왼쪽 커서 
		int pr = right; // 오른쪽 커서
		int x = a[(pl+pr)/2]; // 피벗
		
		// 배열을 피벗을 기준으로 피벗보다 작은 그룹, 큰 그룹으로 나눈다.
		do {
			while (a[pl] > x) pl++; // 역순시 유일하게 바꾸는 곳: 피벗보다 작은 값을 만날 때까지 오른쪽 이동.
			while (a[pr] < x) pr--; // 역순시 유일하게 바꾸는 곳: 피벗보다 큰 값을 만날 때까지 왼쪽 이동.
			if (pl <= pr) { 
				swap(a, pl++, pr--);
			} 
		} 
		while(pl <= pr);
		
		if (left < pr) {
			quickSort(a, left, pr);
		}
		if (pl < right) {
			quickSort(a, pl, right);
		}
		
	}
	
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		System.out.print("학생수 입력 : ");
		int number = Integer.parseInt(stdIn.nextLine());

		int[] arr = new int[number];
		
		for (int i = 0; i < number; i++) {
			System.out.print("학생 " + (i+1) + " 점수 입력: ");
			arr[i] = stdIn.nextInt();
		}
		
		// 배열 arr을 퀵정렬(내림차순).
		quickSort(arr, 0, number-1);
		System.out.println("성적 순으로 정렬");
		int cnt = 0;
		for (int score : arr) {
			System.out.println( (cnt+1) + "등 : " + score);
			cnt++;
			}
		}			
}
