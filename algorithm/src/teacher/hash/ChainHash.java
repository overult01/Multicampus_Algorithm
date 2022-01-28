package hash;
// 체인법에 의한 해시

public class ChainHash<K,V> {
	// 해시를 구성하는 노드

	private int	size;						// 해시 테이블의 크기
	private Node<K,V>[] table;				// 해시 테이블

	// 생성자
	//ChainHash c =  new ChainHssh(13);    
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {		// 테이블을 생성할 수 없음
			this.size = 0;
		}
	}

	// 해시값을 구함-해시함수   key=10 key.hashCode()=10  10 / 13--> 10
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}

	// 키 값 key를 갖는 요소의 검색 (데이터를 반환)-조회
	public V search(K key) {
		int hash = hashValue(key);			// 검색할 데이터의 해시값
		Node<K,V> p = table[hash];			// 선택 노드

		while (p != null) {
			if (p.getKey().equals(key))
				return p.getValue();		// 검색 성공
			p = p.getNext();				// 다음 노드에 주목
		}
		return null;						// 검색 실패
	}

	// 키 값 key, 데이터 data를 갖는 요소의  추가
	//add (1, "삼성컴퓨터")-> p-null / Node(1, "", null) / 01 자리에 저장 / return 0
	//add(1, "애플컴퓨터");-:> p= 01 / 중복 / x / return 1 
	//add (14, "삼성프린터")=> hash = 1 table[1] / p = 01 /  / 01 자리에 저장 01 - 14 : --> 1
	public int add(K key, V data) {
		int hash = hashValue(key);			// 추가할 데이터의 해시값. key % 13
		Node<K,V> p = table[hash];			// 선택 노드

		while (p != null) {//중복
			if (p.getKey().equals(key))		// 이 키 값은 이미 등록됨
				return 1;
			p = p.getNext();						// 다음 노드에 주목
		}
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
		//Node<K,V> temp = new Node<K,V>(key, data, null);
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
					pp.setNext(p.getNext());
				return 0;
			}
			pp = p;
			p = p.getNext();						// 다음 노드를 가리킴
		}
		return 1;							// 그 키 값은 없습니다. 
	}

	// 해시 테이블을 덤프
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
				p = p.getNext();
			}
			System.out.println();
		}
	}
}