package bst;

public class Node {
	int key; // 노드별 고유한 값. 
	Node left;
	Node right;
	
	public Node(int key) {
		super();
		this.key = key;
	}
	
	// 다른 클래스에서도 사용할 수 있도록.
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	
}
