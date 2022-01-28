package hash;
// 체인법에 의한 해시

public class ChainHash<K,V> {
	// 해시를 구성하는 노드

	private int	size;						// 해시 테이블의 크기
	private Node<K,V>[] table;				// 해시 테이블

	// 생성자
	// ChaunHash는 해시테이블의 크기를 정한 것이다(보통은 크기에 소수 지정) 
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {		// 테이블을 생성할 수 없음
			this.size = 0;
		}
	}

	// 해시값을 구함. 해시함수 구현. key.hashCode() : 해시코드 구하기 위해서. 
	public int hashValue(Object key) {
		return key.hashCode() % size;  // ex
	}

	// 키 값 key를 갖는 요소의 검색 (데이터를 반환) - 조회
	public V search(K key) {
		int hash = hashValue(key);			// 검색할 데이터의 해시값
		Node<K,V> p = table[hash];			// 선택 노드

		while (p != null) { // p가 테이블에서 없을 때까지 반복. 
			if (p.getKey().equals(key))
				return p.getValue();		// 검색 성공
			p = p.getNext();				// 다음 노드에 주목
		}
		return null;						// 검색 실패
	}

	// 키 값 key, 데이터 data를 갖는 요소의  추가
	
	// add(1, "삼성컴퓨터" ) -> p: null / Node(1, "", null( / 01자리에 저장 / return 0.
	// add(1, "애플컴퓨터" ) -> p: null x / 중복 / 저장 x / return 1
	// add(14, "삼성프린터" ) -> hash = 1 -> hash / Node(1, "", null( / return 0  / 01자리에 저장 / return 0.
	public int add(K key, V data) {
		int hash = hashValue(key);			// 추가할 데이터의 해시값. 지금은 % 13 값이다.
		
		// 체이닝 구현 
		Node<K,V> p = table[hash];			// 테이블에서 해시값에 해당되는 노드를 하나 가져온다. 

		while (p != null) {
			if (p.getKey().equals(key))		// 이 키 값은 이미 등록됨
				return 1;
			p = p.getNext();				// 다음 노드에 주목
		}
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
//		key마다 한 개 값만 저장하려고 할 때 사용한다.(체이닝 미적용)
		// Node<K,V> temp = new Node<K,V>(key, data, null);
		table[hash] = temp;					// 노드를 삽입
		return 0;
	}

	// 키 값 key를 갖는 요소의 삭제
	public int remove(K key) {
		int hash = hashValue(key);			// 삭제할 데이터의 해시 값
		Node<K,V> p = table[hash];			// 선택 노드
		Node<K,V> pp = null;				// 바로 앞의 선택 노드

		while (p != null) {
			if (p.getKey().equals(key)) {	//  찾으면
				if (pp == null)
					table[hash] = p.getNext();
				else
					pp.setNext(p.getNext());  // 삭제는 연결만 끊으면 된다. (본인을 삭제한다고 하면, 내 다음의 노드값을 내 ?? 노드값으로 연결)
					// pp.next = p.next; // 같은 클래스 내부일 때 이렇게도 쓸 수 있다. P삭제.
				return 0;
			}
			pp = p;
			p = p.getNext();						// 다음 노드를 가리킴
		}
		return 1;							// 그 키 값은 없습니다. 
	}

	// 해시 테이블을 덤프(모든 것을 출력) 
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
				p = p.getNext(); // 현재 노드의 다른 노드를 알려달라. 
			}
			System.out.println();
		}
	}
}