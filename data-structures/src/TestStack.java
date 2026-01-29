
public class TestStack {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("Suzuki");
		stack.push("Honda");
		stack.push("Toyota");
		stack.push("Skoda");
		
		while(true) {
			String s = stack.pop();
			if(s == null) break;
			System.out.println(s);
		}
	}
}
