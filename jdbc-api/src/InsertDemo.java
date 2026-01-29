import java.sql.Connection;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) throws Exception {
		String sql = "insert into people values (123, 'Drek', 2100)";
		
		Connection conn = JdbcFactory.getConnection();
		// Creating statement object for performing fixed/hard-coded query
		Statement stmt = conn.createStatement();
		// Executing DML operation which returns no of rows affected
		int rec = stmt.executeUpdate(sql);
		System.out.println(rec + " row(s) affected");
	}
}
