package hash;

public class Node <K, V> {
	K key;
	V value;
	Node<K, V> next; // 체이닝(동일 key에 대한 충돌방지) 하기 위해서 
	
	// 생성자
	Node(K key, V value, Node<K, V> next) { // 제너릭: 형변환 할 필요 없어져서 편리/
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	// getter, setter 
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
