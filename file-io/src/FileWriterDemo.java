import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) {
		String path = "src/hello.txt";
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write("Hello World");
			writer.newLine();
			writer.write("I'm waiting for the chance to see your face");
			writer.newLine();
			writer.write("Waiting to see the different kind of place");
			System.out.println("Writing to file completed.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
