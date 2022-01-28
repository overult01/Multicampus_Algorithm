package algorithm;

import java.util.Arrays;
import java.util.Comparator;

class MyStringSort implements Comparator<String>{//String[] 사용 정렬기준
	public int compare(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
		// s1, s2 대소문자무시같으면 0
		// s1 < s2 대소문자무시 s1 앞쪽 배열 -1(순서 교환x.다음인덱스이동)
		// s1 > s2 대소문자무시 s2 앞쪽 배열  1(순서 교환. 다음인덱스이동)
	}
}

class MyArraySort implements Comparator<int[]>{ //int[][] 사용 정렬기준  데이터갯수 작은--큰
	public int compare(int[] s1, int[] s2) {
	if(s1.length > s2.length) return 1;
	else if(s1.length < s2.length) return -1;
	else return 0;
	}
}

public class ArraysSortComparator {

	public static void main(String[] args) {
		String[] data= {"test", "TEST", "test123", "TeSt123", "가나다"};
		//Arrays.sort(data);//문자열 자연정렬 - 대소문자 구분하지 않고 문자열 같으면 같다. 사전에 순서
		//[TEST, TeSt123, test, test123, 가나다]
		
		Arrays.sort(data , new MyStringSort()); //data String배열, MyStringSort 는 String타입 데이터 비교 구현되어 있어야 한다
		//[test, TEST, test123, TeSt123, 가나다]
		
		System.out.println(Arrays.toString(data));
	
		int [][] data2 = {{1 ,2, 3},{4, 5, 6, 7, 8, 9},{10, 20, 30}};
		//Arrays.sort(data2);// 오류
		Arrays.sort(data2, new MyArraySort());
		
		for( int[] one : data2) {
			System.out.println(Arrays.toString(one));
		}
		
	}

}




