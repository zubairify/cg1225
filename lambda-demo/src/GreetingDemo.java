
public class GreetingDemo {

	public static void main(String[] args) {
		
		Greeting g1 = (name) -> "Hello, " + name;
		System.out.println(g1.sayHello("Zubair"));
		
		Greeting g2 = (naam) -> {
			String msg = "Happy Holidays, " + naam;
			return msg;
		};
		System.out.println(g2.sayHello("Frank"));
	
		g2.sayBye();
		
		Greeting.sayWhat("Juliet");
		
	}
}
