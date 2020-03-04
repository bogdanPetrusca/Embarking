package src;

public class Node {
	Node left, right, parent;
	PassengerTypes p;
	int index;
	public Node() {
		
	}
	public Node(Node left, Node right, Node parent, PassengerTypes p, int index) {
		this.left = left; this.right = right; this.p = p;
		this.parent = parent;
		this.index = index;
	}
	
}
