
public class RegexDemo {

	public static void main(String[] args) {
		
		String name = "Zubair";
		String nameExp = "[A-Z][a-z]{3,}";
		System.out.println(name.matches(nameExp));
		
		String mobile = "9820982247";
		String mobileExp = "[6-9][0-9]{9}";
		System.out.println(mobile.matches(mobileExp));
		
		String email = "zubairify@gmail.com";
		String emailExp = "^[a-zA-Z0-9_.-]+@[a-z0-9]+.[a-z0-9]{2,3}";
		System.out.println(email.matches(emailExp));
		
	}
}
