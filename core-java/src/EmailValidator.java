
public class EmailValidator {

	// 1- One and only 1 occurrence of @ and .
	// 2- Min 4 chars before @
	// 3- Min 3 chars between @ and .
	// 4- Min 2 chars after .
	// 5- No use of Regex
	public static void main(String[] args) {
		String email = "zubair@gmail.co";
		String emailEx = "[a-zA-Z0-9]{4,}@[a-z0-9]{3,}.[a-z]{2,}";
		
		int iat = email.indexOf('@');
		int idt = email.indexOf('.');
		
		System.out.println(iat == email.lastIndexOf('@') && idt == email.lastIndexOf('.') && 
				iat >= 4 && (idt - iat) > 3 && (email.length() - idt) > 2 ? "Valid Email" : "Invalid Email");
	}
}
