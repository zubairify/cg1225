import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) {
		String sql1 = "insert into people values (213, 'Sean', 2000)";
		String sql2 = "update people set income=2500 where pid=122";
		String sql3 = "delete from people where pname='Drek'";
		
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			conn.setAutoCommit(false);	// Setting auto-commit off
			
			Statement stmt = conn.createStatement();
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			stmt.executeBatch();
			conn.commit();	// Committing the transaction
			System.out.println("Transaction successful");
		} catch (SQLException e) {
			System.out.println("Transaction failed due to..");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
