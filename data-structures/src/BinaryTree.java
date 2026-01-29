
public class BinaryTree {
	private class Node {
		public int data;
		public Node left, right;
		
		public Node(int data) {
			this.data = data;
		}
	};
	
	private Node root;
	private int left, right;
	
	public void add(int data) {
		if(root == null) 
			root = new Node(data);
		else {
			if(data < root.data) left++; else right++;
			Node t = root;
			while(true) {
				if(data == t.data) break;
				if(data > t.data) 
					if(t.right == null){
						t.right = new Node(data); 
						break;
					}
					else
						t = t.right;
				if(data < t.data){
					if(t.left == null) {
						t.left = new Node(data);
						break;
					} else
						t = t.left;
				}
			}
		}
	}
	
	public void sortedTraversing() {
		print(root);
	}
	
	private void print(Node root) {
		if(root != null) {
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}
	
	public void status() {
		System.out.println("Left: " + left + "\tRight: " + right);
	}
}
