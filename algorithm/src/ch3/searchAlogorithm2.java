package ch3;
// 검색 - 이진검색: 이미 정렬되어 있다는 전체로 검색. 중앙값을 기준으로.
// 이진검색은 선형검색보다 빠르다. 
public class searchAlogorithm2 {

	public static void main(String[] args) {
		// 이진검색 구현 순서 
		// 정렬상태의 데이터 셋 준비(오름차순, 내림차순) 
		// 중앙값과 찾을값 비교. 
		// 만약 중앙 값 > 찾을 값 이면 중앙값 앞의 중앙값 앞의 데이터와 비교.
		// 만약 중앙 값 < 찾을 값 이면 중앙값 앞의 중앙값 뒤의 데이터와 비교.
		// 계속 남은 데이터들 중에서, 중앙값과 찾을 값을 비교한다.(위쪽의 로직과 동일 )
		// 중앙 값 == 찾을 값 일 때 찾은 것이다.  
		int[] data = {1, 2, 3, 4, 5, 6, 8};
		
		int target = 10;
		int start = 0;  // 시작위치
		int end = data.length-1; // 끝위치 
		
		while(true) {
			// 중앙값. (위치상 중앙에 있는 값)
			int median = (start + end)/2;
			if(target == data[median]) {
				System.out.println("data[" + median  + "]에서 " + target + "찾았습니다. ");
				break;
			}
			else if (target > data[median]) {
				// 중앙값보다 크면 중앙값 뒤 범위에서 new 중앙값을 찾는다.
				start = median + 1;
			}
			else if (target < data[median]) {
				// 중앙값보다 작으면 중앙값 앞 범위에서 new 중앙값을 찾는다.
				end = median - 1;
			}
			if(start > end) { // start는 계속 커지기만 하고, end는 계속 작아지기만 하므로.
				System.out.println(start + "\t" + end);
				System.out.println("찾을 수 없습니다. ");
				break;
			}

		}
	}

}
