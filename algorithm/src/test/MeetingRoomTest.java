package test;

//정렬 실습(Comparator)
//Arrays.sort(meetings, new Comparator구현객체())

//greedy알고리즘.(최대한 많이) : 그리디에서는 정렬이 필수이다. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*한 개의 회의실이 있다.
이를 사용하고자 하는 N개의 회의들에 대하여 회의실 사용표를 만들려고 한다. 
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 

회의의 시작 시간과 끝나는 시간이 주어질 때
어떻게 정렬을 해서 문제를 풀어야 가장 최적의 답으로 구하는 것인지가 중요한 문제이다.

회의 시간을 정렬할 때 가장 많은 회의를 선택하도록 정렬하는 방법은 끝나는 시간을 기준으로 정렬을 하는 것이다.

가장 빨리 끝나는 회의를 먼저 고려한다면 그만큼 뒤에 남아있는 회의가 많기 때문이다.
이는 sort시 종료시간을 기준으로 오름차순 정렬 후, 시작시간과 비교한다.

-회의 정보가 다음과 같이 입력될 때,
N=6
{1  ,1 , 10} - 1번 회의 1시 시작 10시 종료
{ 2, 5, 6 } - 2번 회의 5시 시작 6시 종료
{ 3, 13, 15 } - 3번 회의 13시 시작 15시 종료
{ 4, 14, 17 } - 4번 회의 14시 시작 17시 종료
{ 5, 8, 14 } - 5번 회의 8시 시작14시 종료
{ 6, 3, 12 } - 6번 회의 3시 시작 12시 종료

2번 회의 - 5번 회의 - 4번 회의
출력된다.
*/
//
class EndTimeSort implements Comparator<int[]>{

	@Override
	public int compare(int[] meeting1, int[] meeting2) { // 미팅이 여러개라도 2개만 매개변수로 주면 되는구나.
		// 종료시간 순으로 오름차순 정렬
		if(meeting1[2] > meeting2[2]) return 1; // 순서 바꿔라.
		else if(meeting1[2]< meeting2[2]) return -1;
		else return 0;
	}
}


public class MeetingRoomTest {

	public static void main(String[] args) {
		int N  = 6;
		int[][] meetings = {{1  ,1 , 10}, { 2, 5, 6 }, { 3, 13, 15 },{ 4, 14, 17 }, { 5, 8, 14 },  { 6, 3, 12 }};

		//회의종료시간 기준 오름차순 정렬
//		Arrays.sort(meetings); // 2차원 정렬기준 구현해야.(Comparator)

		Arrays.sort(meetings, new EndTimeSort());
		
		for(int[] m :meetings) {
			System.out.println(Arrays.toString(m));
		}
		/*
[2, 5, 6]
[1, 1, 10]
[6, 3, 12]
[5, 8, 14]
[3, 13, 15]
[4, 14, 17]

		 */
		
		// 정렬된 첫 번째 회의를 시작하자.
		ArrayList<int[]> list = new ArrayList();
		list.add(meetings[0]);  // 종료시간이 가장 빠른 회의 넣기
		
		// meetings 배열의 나머지 회의의 시작 시간과 list 회의 종료시간을 비교.
		for (int i = 1; i < meetings.length; i ++) {
			if(list.get(list.size()-1/*가장 마지막에 저장된 회의*/)[2] <= meetings[i][1]) {
				list.add(meetings[i]);
			}
		}
		
		// list에 저장된 회의들.
		for (int[] one : list) {
			System.out.println("회의번호: " + one[0] + " , 시작시간: "+ one[1] + " , 종료시간: "+ one[2]);
		}
	}
	
}

