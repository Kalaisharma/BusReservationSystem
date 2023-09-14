package busreservationsystem;
import java.sql.*;

public class connection {

	public static Connection db() throws SQLException {
	String url="jdbc:mysql://localhost:3306/busres";
	String uname="root";
	String pwd="kalai5503";
	Connection con=DriverManager.getConnection(url, uname, pwd);
	return con;
	}
}
