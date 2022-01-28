package algorithm;

public class SearchAlgorithm2 {

	public static void main(String[] args) {
	//이진검색
	// 1> 정렬상태의 데이터셋 준비
	// 2> 중앙값 찾을값 비교
	//    중앙값 > 찾을값  4 앞의 데이터셋 비교 
	//	  중앙값  <  찾을값 4 뒤의 데이터셋 비교
	//  중앙값 == 찾을값 찾았다	
	int [] data = {6, 4, 3, 2, 1, 5, 8};	
	//정렬 상태 가정.
	int [] data2 = {1, 2, 3, 4, 5, 6, 8};
	int target = 10;
	int pl = 0; //시작위치
	int pr = data2.length-1;//끝위치
	
	while(true) {
	//중앙위치 찾아라
	int pc = (pl + pr)/2;//중앙위치
	if(target == data2[pc]) {
		System.out.println("dat2[" + pc + "]에서 " + target + " 찾음 "); 
		break;
	}
	else if(target > data2[pc]) {	
		pl = pc+1; //검색 시작위치를 중앙위치 다음인덱스로 변경(마지막위치 무변)
	}
	else if(target < data2[pc]) {
		pr = pc-1; // 검색 마지막위치를 중앙위치 이전인덱스로 변경(시작위치 무변)
	}
	if( pl > pr ) {  
		System.out.println("못찾음");
		break;
	}
	}//while end
	
	System.out.println("pl=" + pl + " , pr=" + pr);
	
}//main end

}//class end
