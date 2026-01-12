
public class PrimeNoDemo {

	public static void main(String[] args) {
		int num = 15;
		boolean flag = true;
		
		for(int n=2; n <= num/2; n++) {
			if(num % n == 0) {
				flag = false;
				break;
			}
		}
		System.out.println(flag ? "Prime":"Composite");
	}
}
