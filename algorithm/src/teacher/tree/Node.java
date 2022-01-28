package tree;

public class Node {
	String name;
	Node left;
	Node right;
	
	public Node(String name, Node left, Node right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
	public Node(String name) {
		this.name = name;
	}
	
	public Node() {	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
