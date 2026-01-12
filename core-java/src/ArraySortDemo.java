
public class ArraySortDemo {
	public static void main(String[] args) {
		
		int[] ar = {3, 1, 5, 2, 4};
		
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = i+1; j < ar.length; j++) {
				if(ar[i] > ar[j]) {
					int x = ar[i];
					ar[i] = ar[j];
					ar[j] = x;
				}
			}
		}
		for (int n : ar) 
			System.out.printf("%d\t", n);
		
		for (int i = ar.length - 1; i > 0; i--) {
			for (int j = 0; j <= i; j++) {
				if(ar[i] > ar[j]) {
					int x = ar[i];
					ar[i] = ar[j];
					ar[j] = x;
				}
			}
		}
		System.out.println();
		for (int n : ar) 
			System.out.printf("%d\t", n);
	}
}
