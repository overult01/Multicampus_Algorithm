package ch3;
// 검색 - 선형검색: 하나씩 꺼내서 전체를 확인해보는 것이다.  
public class searchAlogorithm {

	public static void main(String[] args) {
//		int [] data = {6, 4, 3, 2, 1, 5, 8};
//		int target = 8;
		
		// 선형검색 방법 1 
//		int i = 0;
//		for(i = 0; i < data.length; i++) {
//			System.out.println(i + "번째 반복 중");
//			if(target == data[i]) {
//				System.out.println("data[" + i + "]에서 " + target + " 찾았다. ");
//				break; // 찾으면 검색 중지. 
//			}
//		}
//		if (i == data.length) {
//			System.out.println(target + "못찾았다.");
//		}
		
		
		// 선형검색 방법 2 (보초법)
		int [] data = {6, 4, 3, 2, 1, 5, 8, 0}; // 검색 대상 7개 숫자 + 0을 추가. 못찾으면 마지막 데이터가 0으로 남아있다. 
//		data[data.length-1] == 검색한 데이터 => 찾은 경우. 아니라면 0이 될 것.

		int target = 3;
		int i = 0;
		for(i = 0; i < data.length; i++) {
			System.out.println(i + "번째 반복 중");
			if(target == data[i]) {
				System.out.println("data[" + i + "]에서 " + target + " 찾았다. ");
				data[data.length-1] = data[i];
				break; // 찾으면 검색 중지. 
			}
		}
		System.out.println(data[data.length-1]);  // 찾았으면 검색한 데이터, 없으면 0 출력.
		}

}
