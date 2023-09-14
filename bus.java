package busreservationsystem;

import java.sql.*;

public class bus {
	private int busno;
	private boolean ac;
	private int capacity;
	private String route;
	public void setbusno(int a) {
		busno=a;
	}
	public int getbusno() {
		return busno;
	}
	public void setac(boolean a) {
		ac=a;
	}
	public boolean getac() {
		return ac;
	}
	public void setcapacity(int a) {
		capacity=a;
	}
	public int getcapacity() {
		return capacity;
	}
	public void setroute(String a) {
		route=a;
	}
	public String getroute() {
		return route;
	}
	 bus()throws SQLException {
	Connection a=connection.db();
	Statement st=a.createStatement();
	ResultSet rs=st.executeQuery("select * from bus");

	System.out.println("------------------------------");
	System.out.println("Displaying the bus information");
	System.out.println("------------------------------");
	while(rs.next()) {
		System.out.println("BusNo: "+rs.getInt(1)+" ");
		boolean b=rs.getBoolean(2);
		if(b)
			System.out.println("Ac : yes");
		else
		System.out.println("Ac : No");
		System.out.println("Bus Route: "+rs.getString(3));
		System.out.println("Bus Capacity: "+rs.getInt(4));	
		System.out.println("------------------------------");
	}a.close();
}
}