import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedDemo {

	public static void main(String[] args) throws Exception {
		// ? is placeholder, index starts from 1
		String sql = "insert into people values (?,?,?)";
		
		Connection conn = JdbcFactory.getConnection();
		// Creating Prepared statement for query with dynamic inputs
		PreparedStatement stmt = conn.prepareStatement(sql);
		// Replacing placeholder with values
		stmt.setInt(1, Integer.parseInt(args[0]));
		stmt.setString(2, args[1]);
		stmt.setDouble(3, Double.parseDouble(args[2]));
		
		// Executing DML operation
		int rec = stmt.executeUpdate();
		System.out.println(rec + " row(s) affected");
	}
}
