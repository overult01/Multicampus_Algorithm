package algorithm;

public class SearchAlgorithm {

	public static void main(String[] args) {
		//선형검색으로 3 찾기 방법1
/*		int [] data = {6, 4, 3, 2, 1, 5, 8};
		int target = 3;
		int i;
		for(i = 0; i < data.length ; i++ ) { // i=7 종료
			System.out.println(i + " 번째 반복중 ");
			if(target == data[i]) {
				System.out.println("data[" + i + "]에서 " + target + " 찾았다");
				break;
			}
		}//for end
		if( i == data.length ) {//조건 판단 문장 수행 횟수 줄여보자
			System.out.println(target + " 못찾았다");
		}*/
		
		//선형검색으로 3 찾기 방법2 보초법
		int [] data = {6, 4, 3, 2, 1, 5, 8, 0};// 검색대상 7개숫자 + 0 추가
		int target = 10;
		int i;
		for(i = 0; i < data.length-1 ; i++ ) { // 
			System.out.println(i + " 번째 반복중 ");
			if(target == data[i]) {
				System.out.println(target + " 찾았다");
				data[data.length-1] = data[i];
				break;
			}
		}//for end
		System.out.println(data[data.length-1]);
		
		
		
	}//main end

}//class end
