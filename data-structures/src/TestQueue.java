
public class TestQueue {

	public static void main(String[] args) {
		Queue que = new Queue();
		que.offer("Apple");
		que.offer("Google");
		que.offer("Apache");
		que.offer("Oracle");
		
		while(true) {
			String s = que.poll();
			if(s == null) break;
			System.out.println(s);
		}
	}
}
