package busreservationsystem;
import java.sql.*;
import java.lang.*;
import java.util.*;

public class busres extends Thread{
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	int useropt=1;
	while(useropt!=3) {
		System.out.println("Enter 1 to book \nEnter 2 to cancel booking\nEnter 3 to exit");
		System.out.print("Enter your option: ");
		useropt=sc.nextInt();
		if(useropt==1) {
			bus a=new bus();
			System.out.println("Your Booking goes here....");
			booking b=new booking();	
			System.out.println("Checking for availability......");
			Thread.sleep(5000);
			int capacity=b.getcapacity();
			int availability=b.isavailable();
			if(availability<capacity) {
				System.out.println("Booking confirmed");
				System.out.println("---------------------------------------");
			     b.insert();}
			else {
				System.out.println("Sorry! Its full");
				System.out.println("---------------------------------------");
}
		
			
			}
		else if(useropt==2) {
			cancelling a=new cancelling();
		}
		else if(useropt>3) {
			System.out.println("Enter a valid option !!!");
		}
		else {
			System.exit(0);
	}

	}
} 

}