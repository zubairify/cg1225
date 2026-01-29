
public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		list.add("Kiwi");
		
		list.addFirst("Grapes");
		list.insert("Guava", 2);
		list.traverse();
		
		list.delete(3);
		System.out.println("After delete");
		list.traverse();
	}
}
