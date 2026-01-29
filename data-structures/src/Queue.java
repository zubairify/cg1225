
public class Queue {
	private class Node {
		private String data;
		public Node next;
		
		public Node(String data) {
			this.data = data;
		}
		
		public String getData() {
			return data;
		}
	};
	
	private Node head, last;
	
	public void offer(String data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
	}
	
	public String poll() {
		if(head != null) {
			Node t = head;
			head = head.next;
			t.next = null;
			return t.getData();
		} else {
			System.out.println("Queue is empty!");
			return null;
		}
	}
}

