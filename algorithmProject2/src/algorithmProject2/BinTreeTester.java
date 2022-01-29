package algorithmProject2;
import java.util.Scanner;
// 이진검색트리 클래스 BinTree<K,V>의 이용
// 최종 
class BinTreeTester {
	static Scanner stdIn = new Scanner(System.in);

	// 데이터 (상품번호 + 상품명)
	static class Data {
		public static final int NO   = 1;	// 번호를 읽어 들일까요?
		public static final int NAME = 2;	// 이름을 읽어 들일까요?

		private Integer no;					// 상품번호 (키 값)
		private String  name;				// 상품명 

		// 키 값
		Integer keyCode() {
			return no;
		}

		// 문자열을 반환합니다.
		public String toString() {
			return name;
		}

		// 데이터를 입력합니다.
		void scanData(String guide, int sw) {
			System.out.println("\n" + guide);

			if ((sw & NO) == NO) {
				System.out.print("상품 번호 입력：");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("상품명 입력：");
				name = stdIn.next();
				System.out.println();
			}
		}
	}

	// 메뉴 열거형
	enum Menu {
		ADD(      "상품 등록"),
		REMOVE(   "상품 삭제"),
		SEARCH(   "상품 검색"),
		PRINT(    "전체 상품 조회"),
		TERMINATE("종료");

		private final String message;			// 출력할 문자열 

		static Menu MenuAt(int idx) {			// 서수가 idx인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx-1) // 1~5번으로 변경해서.
					return m;
			return null;
		}

		Menu(String string) {					// 생성자
			message = string;
		}

		String getMessage() {					// 출력할 문자열을 반환
			return message;
		}
	}

	// 메뉴 선택
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal()+1, m.getMessage()); // 1~5번으로 변경해서.
			System.out.println();
			System.out.print("메뉴 선택：");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal()+1 || key > Menu.TERMINATE.ordinal()+1); // 1~5번으로 변경해서.

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;								// 메뉴
		Data data;								// 추가용 데이터 참조
		Data ptr;								// 검색용 데이터 참조
		Data temp = new Data();					// 입력용 데이터
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

		do {
			switch (menu = SelectMenu()) {
			 case ADD :							// 노드를 삽입
					data = new Data();
			 		data.scanData("상품 등록", Data.NO | Data.NAME);
			 		tree.add(data.keyCode(), data);
			 		break;

			 case REMOVE :						// 노드를 삭제
					temp.scanData("상품 삭제", Data.NO);
			 		tree.remove(temp.keyCode());
			 		break;

			 case SEARCH :						// 노드를 검색
					temp.scanData("상품 검색", Data.NO);
			 		ptr = tree.search(temp.keyCode());
			 		if (ptr != null)
						System.out.println("\n 상품명 : " + ptr + "\n");
					else
			 			System.out.println("\n 해당 데이터가 없습니다. \n");
			 		break;

			 case PRINT :						// 모든 노드를 키 값의 오름차순으로 출력
					tree.print();
					break;
			}
		} while (menu != Menu.TERMINATE);
		if(menu == Menu.TERMINATE) {
			System.out.println("종료합니다.");
		}
	}
}