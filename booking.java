package busreservationsystem;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
public class booking {
	String name;
	int busno;
	Date date;
	Scanner sc=new Scanner(System.in);
	booking()throws Exception{
		System.out.print("Enter your name: ");
		 name=sc.next();
		System.out.print("Enter the busno: ");
		 busno=sc.nextInt();
		System.out.print("Enter the date(dd-mm-yyyy): ");
		String s=sc.next();
		SimpleDateFormat p=new SimpleDateFormat("dd-MM-yyyy");
		date=p.parse(s);
		
		}
	public  int isavailable()throws SQLException {
		Connection a=connection.db();
		PreparedStatement st=a.prepareStatement("select count(name) from booking where date=?;");
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		st.setDate(1, sqldate);
		ResultSet rs=st.executeQuery();
	rs.next();
	return rs.getInt(1);
		
	
	}
	public int getcapacity() throws SQLException {
		Connection a=connection.db();
		PreparedStatement pst=a.prepareStatement("select capacity from bus where busno=?;");
		pst.setInt(1, busno);
		ResultSet rs=pst.executeQuery();
		rs.next();
		return rs.getInt(1);
		
	}
	public void insert() throws SQLException {
		Connection a=connection.db();
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		PreparedStatement pst=a.prepareStatement("insert into booking values(?,?,?);");
		pst.setString(1, name);
		pst.setInt(2, busno);
		pst.setDate(3, sqldate);
		pst.executeUpdate();
		
	}

}
