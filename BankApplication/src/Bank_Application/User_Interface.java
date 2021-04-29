package Bank_Application;

import java.io.IOException;
import java.util.Scanner;

public class User_Interface  {

	public static void main(String[] args) throws IOException {
		DisplayCustomer a=new DisplayCustomer();
		System.out.println("WELCOME TO OUR BANK");
		Scanner in=new Scanner(System.in);
        System.out.println("Please Select the Option you want to perform");
        System.out.println("1.Display your account Details");
        System.out.println("2.Withdraw Amount ");
        System.out.println("3.Deposit Amount");
        System.out.println("4.Create a New Account");
        int option=in.nextInt();
		switch(option)
		{
		case 1:
			System.out.println("Enter your Id to view your details");
			int id=in.nextInt();
			DisplayCustomer d=new DisplayCustomer();
			d.customerdetails(id);
			break;
		case 2:
			System.out.println("Enter your ID ");
			int iden=in.nextInt();
			System.out.println("Enter the amount you want to withdraw");
			int amount=in.nextInt();
			Withdraw w= new Withdraw();
			w.withdraw_amount(amount, iden);
			break;
			
		default:
			System.out.println("Invalid Option");
			break;
		}
	}

}
