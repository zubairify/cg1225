import java.sql.Connection;
import java.sql.ResultSet;

public class ResultDemo {

	public static void main(String[] args) throws Exception {
		String sql = "select * from people";
		
		Connection conn = JdbcFactory.getConnection();
		// ResultSet represents a record pointer
		// pointing before the first records of returned results of the select query
		ResultSet rs = conn.createStatement().executeQuery(sql);
		
		while(rs.next()) 
			System.out.println(rs.getInt(1) + ", " + rs.getString(2) + 
					", " + rs.getDouble(3));
		
	}
}
