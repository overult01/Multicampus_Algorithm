package ch2;
//다차원 배열
// 재확인 필요.
public class LeafYearTest {

	public static void main(String[] args) {
		int[][] datasample = {{2022, 1, 24}, {2020, 12, 12}, {1999, 1 , 1}, {2000, 12, 12}};
		// 각 연도 추출하여 해당 연도가 윤년인지 판단.
		// 윤년이 4년마다 돌아온다.
		// 그런데 그 가운데 100년에 한 번은 윤년이 아니다. 
		// 또는 400년에 한 번은 윤년이 돌아온다.
		
		for(int i = 0; i < datasample.length; i++) {
			
			int year = datasample[i][0];   // 연도만 가져오기 
			if (year % 4 ==0 && year % 100 != 0 || year%400 ==0) {
				System.out.println("윤년이다. ");
			}
				
		}
		
		
	}

}
