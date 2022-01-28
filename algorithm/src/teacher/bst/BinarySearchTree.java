package bst;

public class BinarySearchTree {
	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	//중위 순회 - inorder 오름차순 정렬
	public void display(Node n) {
		if(n != null) {//현재 전달받은 node 가 null 이 아니면
		display(n.getLeft());
		System.out.print(n.getKey() + " - ");
		display(n.getRight());
		}
		
	}
	
	//특정값 트리 조회
	public boolean find(int key) {
		Node current = root;//root 부터 조회 시작
		while(current != null) {
		System.out.println(current.getKey() + ": " + key + " 비교중");
		if( current.getKey() == key) { 
			return true;
		}
		else if(current.getKey() > key) {//왼쪽이동
			current = current.getLeft(); 
		}
		else if(current.getKey() < key) {//오른쪽이동	
			current = current.getRight();
		}
		}//while end
		return false;
	}
	//bst.insert(100);
	public void insert(int key) {
		Node newNode = new Node(key);
		if( root == null) {//트리구성노드 없다면
			root = newNode;
			return;
		}
		Node current = root;//트리구성노드 있다면.root시작
		Node parent = null;
		//새로운 노드 삽입위치 지정, 부모와 자식 재연결
		while(true) {
			parent = current;
			//현재 노드보다 작으면  
			if(current.getKey() > key) {
				//왼쪽 노드로 이동
				current = current.getLeft();
				if(current == null) {//왼쪽 노드 없다면
					parent.setLeft(newNode);//newNode가 왼쪽 노드 설정
					return;
				}
			}
			//현재 노드보다 크면  
			else {
				//오른쪽 노드로 이동
				current = current.getRight();				
				if(current == null) {//오른쪽 노드 없다면
					parent.setRight(newNode);//newNode가 오른쪽 노드 설정
					return;
				}			
			}
			
			System.out.println(parent.getKey());
			if(parent.getLeft() != null) System.out.println(parent.getLeft().getKey());
			if(parent.getRight() != null) System.out.println(parent.getRight().getKey());
		}//while end
		

	}//insert end

	// 키 값이 key인 노드를 삭제
	public boolean remove(int key) {
		Node p = root;							// 스캔 중인  노드
		Node parent = null;						// 스캔 중인  노드의 부모 노드
		boolean isLeftChild = true;						// p는 parent의 왼쪽 자식 노드인가?

		while (true) {
			if (p == null) {								// 더 이상 진행하지 않으면
				return false;							// 그 키 값은 없습니다. 
			}
			if(key == p.getKey()) {						//같으면 검색 성공
				break;
			}
			else {
				parent = p;								// 가지로 내려가기 전에 부모를 설정
				if (key < p.getKey()) {					// key 쪽이 작으면
					isLeftChild = true;					// 왼쪽 자식으로 내려감
					p = p.left;							// 왼쪽 서브트리에서 검색
				} else {								// key 쪽이 크면
					isLeftChild = false;				// 오른쪽 자식으로 내려감
					p = p.right;						// 오른쪽 서브 트리에서 검색
				}
				
			}

		}//while end(삭데할 노드 찾기완료)
		

		//이제 해당 노드 삭제시 삭제 노드의 자식들을 삭제 노드의 부모로 연결
		if (p.left == null) {							// p에는 왼쪽 자식이 없음
			if (p == root)					 
				root = p.right;
			else if (isLeftChild)
				parent.left  = p.right;					// 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
			else
				parent.right = p.right;					// 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
		} else if (p.right == null) {					// p에는오른쪽 자식이 없음
			if (p == root)
				root = p.left;
			else if (isLeftChild)
				parent.left  = p.left;					// 부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
			else
				parent.right = p.left;					// 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
		} else {     //자식 2개 모두 있음
			parent = p;
			Node left = p.left;					// 서브 트리 가운데 가장 큰 노드
			isLeftChild = true;
			while (left.right != null) {				// 가장 큰 노드 left를 검색
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			p.key  = left.key;							// left의 키 값을 p로 옮김
			if (isLeftChild)
				parent.left  = left.left;				// left를 삭제
			else
				parent.right = left.left;				// left를 삭제
		}
		return true;
	}//remove end
	
}



