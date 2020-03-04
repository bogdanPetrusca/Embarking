package src;

public class MaxHeap {
	Node root;
	int lvl, size, currNodes;
	
	public MaxHeap(int size) {
		this.size = size;
		this.currNodes = 0;
		this.lvl = 1;
		this.root = null;
	}
	
	public  void addP(PassengerTypes p, Node curr) {
		Node n = new Node(null ,null, null, p, ++currNodes);
		//System.out.println("nodul este: " + p.PType + " currNodes: " + this.currNodes);
		if(this.root == null) {
			//System.out.println("nodul din root: " + p.PType);
			this.root = n;
		}
		else {
			Node parent = this.getParent(curr, n);
			//System.out.println("parent: " + parent.p.PType + " nodul de add: " + n.p.PType);
			if(2 * parent.index == n.index) {
				//System.out.println("stanga: " + n.p.PType);
				parent.left = n;
				parent.left.parent = parent;
				//System.out.println("parent.left: " + parent.left.p.PType);
				this.swapNodes(parent.left);
			}
				
			else {
				//System.out.println("dreapta: " + n.p.PType);
				parent.right = n;
				parent.right.parent = parent;
				//System.out.println("parent.right: " + parent.right.p.PType);
				this.swapNodes(parent.right);
			}
			
		}
			
			
	}
	
	/*public void addP(PassengerTypes p, Node curr) {
		
		if(this.root == null) {
			
			this.root = new Node(null, null, null, p, ++currNodes); 
			return;
		}
		else if(currNodes + 1 == 2 * curr.index) {
			
			curr.left = new Node(null, null, curr, p, ++currNodes); 
			this.swapNodes(curr.left);
			return;
		}
		else if(currNodes == 2 * curr.index) {
			
			curr.right = new Node(null, null, curr, p, ++currNodes ); 
			this.swapNodes(curr.right);
			return; 
		}
		if(curr.left != null)
			addP(p, curr.left);
		else if(curr.right != null)
			addP(p, curr.right);
		
	}
	*/
	
	public Node getParent(Node curr, Node n) {
		if(curr == null) {
			return null;
		}
		if(curr.index * 2 == n.index)  {
			//System.out.println("parent stang: " + curr.p.PType);
			return curr;
		}
			
		if(curr.index * 2 + 1 == n.index) {
			//System.out.println("parent dreapta: " + curr.p.PType);
			return curr;
		}
		if(curr.left != null)
			return getParent(curr.left, n);
		else 
			return getParent(curr.right, n);
	
	}
	
	public void swapInfo(Node n1, Node n2) {
		PassengerTypes aux = null;
		aux = n1.p;
		n1.p = n2.p;
		n2.p = aux;
		
	}
	public void swapNodes(Node n) {
		//System.out.println();
		while(n.parent != null && n.p.score > n.parent.p.score) {
			
			swapInfo(n, n.parent);
			n = n.parent;
		}
	}
	
	public Node getLastNode(Node curr) {
		Node n = null;
		//System.out.println("index: " + curr.index);
		if (this.currNodes == curr.index ) {
			//System.out.println("lvl this: " + this.currNodes + " lvl: " + curr.index + " " + curr.p.PType);
			this.currNodes--;
			n = curr;
		}
		if (curr.left != null && n == null)
			n = getLastNode(curr.left);
		 if(curr.right != null && n == null)
			n =  getLastNode(curr.right);
		return n;
	}
	
	public void embark() {
		Node node = new Node();
		node = getLastNode(this.root);
		//System.out.println("nodeul este: " + node.parent); 
		
		
		if(node.parent != null && node.parent.left.equals(node))
			node.parent.left = null;
		else if(node.parent != null && node.parent.right.equals(node))
			node.parent.right = null;
		node.parent = null;
		
		//System.out.println("lvl: " + this.lvl);
		if(this.currNodes < Math.pow(2, this.lvl) - 1)
			this.lvl--;
		
		
		this.swapInfo(node, this.root);
		
		node = this.root;
		
		while(node != null) {
			if(node.left != null && node.right != null) {
				//System.out.println(node.p.PType);
				if(this.maxChildren(node.left.p, node.right.p) >= 0) {
					if(this.maxChildren(node.left.p, node.p) > 0) {
						this.swapInfo(node.left, node);
						node = node.left;
					}
					else break;
					
				}
					
				else {
					if(this.maxChildren(node.right.p, node.p) > 0){
						this.swapInfo(node.right, node);
						node = node.right;
					}
					else break;
				}
					
			}
			else if(node.right == null && node.left != null) {
					this.swapInfo(node.left, node);
					node = node.left;
			}
			else if(node.left == null && node.right != null) {
				this.swapInfo(node.right, node);
				node = node.right;
			}
			else break;
		}
		
	}
	
		
	public int maxChildren(PassengerTypes p1, PassengerTypes p2) {
		return p1.score - p2.score;
	}
	public void displayAll(Node n) {
		if(n == null) return;
		System.out.print(n.p.PType  + " " );
		displayAll(n.left);
		displayAll(n.right);
	}
}
