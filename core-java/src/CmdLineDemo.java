import static java.lang.System.*;

public class CmdLineDemo {

	public static void main(String[] args) {
		int sum = 0;
		for (String a : args) { 
			System.out.println(a);
			sum += Integer.parseInt(a);
		}
		out.println("Sum: " + sum);
		
		int a = 10;
		// Auto-boxing
		Integer b = a;	//  Boxing
		int c = a * b;	// Unboxed
		
		out.println(Math.PI);
		out.println(currentTimeMillis());
		
	}
}

// >java CmdLineDemo hi hello bye
