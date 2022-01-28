package bst;

public class Main {

	public static void main(String[] args) {
		// 노드의 키값(데이터 값)은 유일하다. 또한, 값이 없는 노드는 없다.
		Node n1 = new Node(1);
		Node n2 = new Node(8);
		Node n3 = new Node(30);
		Node n4 = new Node(11);
		Node n5 = new Node(80);
		Node n6 = new Node(300);
		Node n7 = new Node(200);
		
		BinarySearchTree bst = new BinarySearchTree();
		// 이진탐색트리의 초기값 넣기. 왼 자식: 큰 값, 오 자식: 작은 값. 
		bst.setRoot(n3);
//		n3.setLeft(n2);
//		n3.setRight(n7);
//		n2.setLeft(n1);
//		n2.setRight(n4);
//		n7.setLeft(n5);
//		n7.setRight(n6);
//		bst.display(n3); // 부모 중간 조회 - 오름차순
		System.out.println();
		
		// 이진 검색트리는 빠르다. (왼자식: 큼, 오른자식: 작음 순으로 배열한 경우) 
		System.out.println(bst.find(300)); // 오른쪽
		System.out.println(bst.find(3000)); // 못찾음 
		System.out.println(bst.find(8)); // 왼쪽 

		// 노드를 추가한 경우 
//		bst.insert(100); // insert로 노드를 넘겨준다. key를 매개변수로.
		
		bst.insert(20);
		bst.insert(5000);
		bst.insert(10);
		bst.insert(16);
		
		bst.display(bst.getRoot()); // 부모 중간 조회
		System.out.println();
		
		System.out.println(bst.remove(8)); // true
		bst.display(bst.getRoot()); // 부모 중간 조회
		System.out.println();

		System.out.println(bst.remove(800)); // false
		bst.display(bst.getRoot()); // 부모 중간 조회
		System.out.println();
	
		
	}

}
