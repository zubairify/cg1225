
public class LinkedList {
	private class Node {
		private String data;
		public Node next;

		public Node(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [Data=" + data + "]";
		}
	};

	private Node head, last;

	public void add(String data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
	}

	public void insert(String data, int index) {
		Node n = new Node(data);
		Node t = head;
		for (int c = 1; c <= index; c++, t = t.next) {
			if (c == index) {
				n.next = t.next;
				t.next = n;
			}
		}
	}

	public void addFirst(String data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public void delete(int index) {
		Node t = head;
		for (int c = 1; c <= index; c++, t = t.next) {
			if (c == index) {
				Node x = t.next; 
				t.next = x.next;
				x.next = null;
			}
		}
	}

	public void traverse() {
		Node t = head;
		while (t != null) {
			System.out.println(t);
			t = t.next;
		}
	}
}
