import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {
	public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
		// Writer your code here
		return null;
	}
}
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/logs.txt"));

		int logsRows = Integer.parseInt(reader.readLine().trim());
		int logsColumns = Integer.parseInt(reader.readLine().trim());
		
		List<List<String>> logs = new ArrayList<>();
		
		for(int i=0; i<logsRows; i++) {
//			logs.add(Arrays.asList(reader.readLine().replaceAll("\\s+$","").split(" ")));
			logs.add(Arrays.asList("abc efg pqr".split(" ")));
			
		}
	
		List<List<String>> result = Result.extractErrorLogs(logs);
		
		for(int i=0; i<result.size(); i++) {
			for(int j=0; j<result.get(i).size(); j++) {
				writer.write(result.get(i).get(j));
				if(j != result.get(i).size() - 1) {
					writer.write(" ");
				}
			}

			if(i != result.size() - 1) {
				writer.write("\n");
			}
		}
		
		writer.newLine();
		reader.close();
		writer.close();
	}
}
