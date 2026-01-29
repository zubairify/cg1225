import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class ConnectionDemo {

	public static void main(String[] args) throws Exception {
		
//		DriverManager.registerDriver(new Driver());
//		String url = "jdbc:mysql://localhost:3306/cgdec25";
//		Connection conn = DriverManager.getConnection(url, "zubair", "oracle");

		Connection conn = JdbcFactory.getConnection();
		System.out.println("Connected successfully");
		
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println(meta.getDatabaseProductName());
		System.out.println(meta.getDatabaseProductVersion());
		System.out.println(meta.getDriverName());
		System.out.println(meta.getDriverVersion());
	}
}
