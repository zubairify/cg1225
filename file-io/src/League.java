import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Helper {
	
	public static void save(List<String[]> data) {
		// code to save all string arrays elements separated with , in file name data.txt
		
	}
}

public class League {
	// Sample: 123 Polo 1200
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int rows = Integer.parseInt(reader.readLine());
		List<String[]> data = new ArrayList<String[]>();
		
		for(int c=1; c<=rows; c++) {
			// code to accept data from console and add into list as string array
		}
		
		Helper.save(data);
	}
}
