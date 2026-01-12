
@FunctionalInterface
public interface Greeting {
	String sayHello(String name);
	
	default void sayBye() {
		System.out.println("Goodbye!" + saySomething());
	}
	
	static void sayWhat(String name) {
		System.out.println("Whatsup, " + name);
	}
	
	private String saySomething() {
		return "Blah Blah Blah";
	}
}
