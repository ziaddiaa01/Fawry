import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
	Account MyAcc = new Account();
	public void SignIn()
	{
		String record = null;
	    FileReader input = null;
	    try {
	    	input = new FileReader("UsersData.txt");
	        BufferedReader br = new BufferedReader(input);
	        try (Scanner keyboard = new Scanner(System.in)) {
				System.out.print("Username: ");
				MyAcc.UserName = keyboard.nextLine();

				System.out.print("Password: ");
				MyAcc.Password = keyboard.nextLine();
				
				System.out.print("Email: ");
				MyAcc.Email = keyboard.nextLine();

				boolean Found = false;

				while ((record = br.readLine()) !=null) {
				    // Split line by a whitespace character
				    // split[0] <- username
				    // split[1] <- password
					// split[2] <- password
				    String[] split = record.split("\\s");

				    if (MyAcc.UserName.equals(split[0]) && MyAcc.Password.equals(split[1]) && MyAcc.Email.equals(split[2]) ) {
				    	Found=true;
				    	System.out.print("Loged In Successfully");
				        break;
				    }
				}
				if (Found == false) {
					System.out.print("User not found");
				}
			}
	    } 
	    catch (IOException e) {
	        e.getCause();
	    }
	}
	public void SignUp()
	{
		String record = null;
	    FileReader input = null;
	    try {
	    	input = new FileReader("UsersData.txt");
	        BufferedReader br = new BufferedReader(input);
	        try (Scanner keyboard = new Scanner(System.in)) {
				System.out.print("Username: ");
				MyAcc.UserName = keyboard.nextLine();

				System.out.print("Password: ");
				MyAcc.Password = keyboard.nextLine();
				
				System.out.print("Email: ");
				MyAcc.Email = keyboard.nextLine();

				boolean Found = false;

				while ((record = br.readLine()) !=null) {
				    // Split line by a whitespace character
				    // split[0] <- username
				    // split[1] <- password
					// split[2] <- password

				    String[] split = record.split("\\s");

				    if (MyAcc.UserName.equals(split[0]) && MyAcc.Password.equals(split[1]) && MyAcc.Email.equals(split[2]) ) {
				    	Found=true;
				    	System.out.print("User is already found");
				        break;
				    }
				}
				if (Found == false) {
					FileWriter out = new FileWriter("UsersData.txt"); // Step 2
			        out.write(MyAcc.UserName);
			        out.write(MyAcc.Password);
			        out.write(MyAcc.Email);
			        out.close();
				}
			}
	    } 
	    catch (IOException e) {
	        e.getCause();
	    }
	}
	public boolean SearchService(String ServiceName)
	{
		boolean Found =false;
		final Scanner scanner = new Scanner("ServiceRecords.txt");
		while (scanner.hasNextLine()) {
		   final String lineFromFile = scanner.nextLine();
		   if(lineFromFile.contains(ServiceName)) { 
			   Found=true;
			   break;
		   }
		}
		return Found;
	}
	public boolean CheckDiscount(String ServiceName)
	{
		boolean Found =false;
		final Scanner scanner = new Scanner("AppliedDiscount.txt");
		while (scanner.hasNextLine()) {
		   final String lineFromFile = scanner.nextLine();
		   if(lineFromFile.contains(ServiceName)) { 
			   Found=true;
			   break;
		   }
		}
		return Found;
	}
}
