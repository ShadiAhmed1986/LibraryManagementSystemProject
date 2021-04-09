package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordAndUsernameValidation {
	
	List<String> passwordDatabase = new ArrayList<>();
	
	public static boolean passwordValidation(List<String> passwordDatabase) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please create a password !");
		System.out.println("Your password should have at least: \r\n"
				+ "	  1 Uppercase letter \r\n"
				+ "	  1 Lowercase letter \r\n"
				+ "	  1 Digit \r\n"
				+ "	  The minimum length of the password should be 8");
				
		String password = scan.next();
		
		int countUppercase = 0;
		int countLowercase = 0;
		int countDigit = 0;
		
		for (int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				countLowercase++;
			}
			if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
				countUppercase++;
			}
			if(Character.isDigit(password.charAt(i))) {
				countDigit++;
			}
		}
		
		if(password.length() >= 8) {
			if(countUppercase > 0 && countLowercase > 0 && countDigit > 0) {
				System.out.println("Password creation succesfull !");
				passwordDatabase.add(password);
				return true;
			}else {
				System.out.println("Please check your password !");
				passwordValidation(passwordDatabase);
			}
		}else {
			System.out.println("The length of the password must be at least 8 characters !");
			passwordValidation(passwordDatabase);
		}
		return true;
	}
	
	
	public static boolean usernameValidation() {
		
		List<String> database = new ArrayList<>();
		
		database.add("sam");
		database.add("johnmary");
		database.add("johnwalker");
		database.add("johnwalker523463146");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an username without any space !");
		
		String username = scan.next();
		
		Random randomNum = new Random();
		int random = randomNum.nextInt(100000001);
		
		boolean notAvailable = database.contains(username);
		
		if(!notAvailable) {
			System.out.println("This username is available !");
			database.add(username);
			return true;
		}else {
			System.out.println("This username is already taken ! "
					+ "You can use this: " + username + random +"\nDo you want to use it ? (yes/no)");
			String userChoice = scan.next().toLowerCase();
			
			if(userChoice.equals("yes")) {
				database.add(username + random);
				System.out.println("Username Created Successfully !\nAdded to the DataBase !");
				return true;
			}else {
				System.out.println("Not Created !");
				return false;
			}
		}	
	}
}
