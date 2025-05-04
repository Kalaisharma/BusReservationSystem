package busreservationsystem;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

public class cancelling {
	String name;
	java.util.Date date;
	cancelling()throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your name: ");
		name=sc.next();
		System.out.print("Enter the date you have booked: ");
		String a=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy");
		java.util.Date date=sdf.parse(a);
		Connection b=connection.db();
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		PreparedStatement st=b.prepareStatement("delete from booking where name=? and booking_date=?;");
		st.setString(1, name);
		st.setDate(2, sqldate);
		int rows=st.executeUpdate();
		if(rows>0) {
			System.out.println("Your booking is cancelled successfully");
		System.out.println("-----------------------------------------");}
		else {
		System.out.println("Invalid entry");
		System.out.println("-----------------------------------------");}
		
	}
}
