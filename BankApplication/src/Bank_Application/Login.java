package Bank_Application;
import java.io.IOException;
import java.util.Scanner;
public class Login {
    //public void Login(String username, String password) throws IOException
    public void Login(){
        Scanner in1=new Scanner(System.in);
        System.out.println("Enter your username");
        String username = in1.nextLine();
        System.out.println("Enter your Password");
        String password = in1.nextLine();

        if("Nivethetha".equals(username) && "nivi".equals(password))
        {
            System.out.println("Welcome Nivethetha");
        }
        else if("Rahul".equals(username) && "rahul".equals(password))
        {
            System.out.println("Welcome Rahul");
        }
        else if("Tanu".equals(username) && "tanu".equals(password))
        {
            System.out.println("Welcome Tanu");
        }
        else
        {
            System.out.println("Invalid username or password");
        }

    }
}
