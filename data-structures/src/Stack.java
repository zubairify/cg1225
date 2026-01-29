
public class Stack {

	private class Node {
		public String data;
		public Node prev;
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	private Node head;
	
	public void push(String data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		} else {
			n.prev = head;
			head = n;
		}
	}
	
	public String pop() {
		if(head != null) {
			Node t = head;
			head = head.prev;
			t.prev = null;
			return t.data;
		} else {
			System.out.println("Stack is empty!");
			return null;
		}
	}
}
