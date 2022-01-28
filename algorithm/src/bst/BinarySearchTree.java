package bst;

public class BinarySearchTree {
	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	// 중위 순회(inorder) : 오름차순 정렬된다.
	public void display(Node n) {
		if(n != null) { // leaf노드(자식이 없는 노드 = 끝노드)가 아니면 계속 반복.
			display(n.getLeft());
			System.out.print(n.getKey() + " - ");
			display(n.getRight());
		}
	}
	
	// 특정 값 트리 조회
	public boolean find(int key) {
		Node current = root; // root부터 조회시작
		
		while(current != null) { // 리프노트이면 자식이 없으므로 while돌지 않는다.
			
			System.out.println(current.getKey() + ": " + key + "비교중");
			
			if(current.getKey() == key) {
				return true; // 벌써 찾은 것.
			}
			else if(current.getKey() > key) { // 왼쪽이동
				current = current.getLeft(); // 현재 노드를 왼쪽걸로 바꿔준다.
			}
			else if(current.getKey() < key) { // 오른쪽 이동 
				current = current.getRight(); // 오른쪽 이동. 
			}
		}
		return false; // 못찾으면 false반환. 
		/* 종료되는 경우의 수
		 * 
		 * 1. 자식이 없는 leaf노드라 while문을 아예 시작하지 못하는 경우.
		 * 2. 못찾은 경우 
		 * */
		
	}
	
	// 노드가 추가된 경우 넣을 메서드 구현 
	public void insert(int key) {
		Node newNode = new Node(key);
		if( root == null ) { // 현재 트리로 구성된 노드가 전혀 없다면.
			root = newNode;
			return; // 이 메서드를종료한다는 뜻의 return이다.
		}
		
		Node current = root; // 트리를 구성중인 노드가 있다면, root부터 조회시작
		Node parent = null;
		// 새로운 노드 삽입위치 지정, 부모와 자식 재연결. 
		while(true) {
			parent = current;
			if(current.getKey() > key) {
				// 현재노드보다 작으면 왼쪽노드.
				current = current.getLeft();
				// 그 위치에서 자식이 없다. 그러면 이 위치(왼쪽노드)에 삽입.
				if(current == null) { 
					parent.setLeft(newNode);
					return; // 메서드 종
				}
			}
			
			// 현재 노드보다 크면
			else {
				//오른쪽 노드로 이동
				current = current.getRight();
				if(current == null) { // 이 자리가 비어있다면 이 위치(오른쪽노드)에 삽입.
					parent.setRight(newNode);
					return; // 이 메서드 종료.
				}
				
			}
			System.out.println(parent.getKey());
			if(parent.getLeft() != null) System.out.println(parent.getLeft().getKey());
			if(parent.getRight() != null) System.out.println(parent.getRight().getKey());		}
	}
	
	// 삭제 메서드 구현.
	// 값으로 자신의 노드 위치 찾고, 자신을 없앤 빈자리가 있으므로 자식들을 부모 노드에 연결해주는 작업.
	
	/*삭제 구현 순서 
	 * 1. 삭제할 노드의 왼쪽 서브 트리에서 키 값이 가장 큰 노드를 검색한다.
	 * 2. 검색한 노드를 삭제 위치로 옮긴다.(검색한 노드의 데이터를 삭제 대상 노드 위치로 복사한다.
	 * 3. 옮긴 노드를 삭제한다, 이때 
	 * 3-1) 옮긴 노드에 자식이 없으면: '자식 노드가 없는 노드의 삭제 순서'에 따라 노드를 삭제한다.
	 * 3-2) 옮긴 노드에 자식이 1개만 있으면: '자식 노드가 1개 있는 노드의 삭제 순서'에 따라 노드를 삭제한다. */
	
	
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

		}//while end(삭제할 노드 찾기완료)
		

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
	}
	
}
