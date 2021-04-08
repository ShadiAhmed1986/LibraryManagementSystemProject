package librarymanagementsystem;

import java.util.Scanner;

public class Methods {

	Scanner scan = new Scanner(System.in);
		
	public void register(String names[], RegistrationForm regForm){
		System.out.println("Please enter your first name!");
		regForm.setFirstName(scan.next());
		System.out.println("Please enter your last name!");
		regForm.setLastName(scan.next());
		System.out.println("Please enter a password");
		regForm.setPassword(scan.nextInt());
		System.out.println("---=== Registration successfull ! ===---\nThank you for registering " 
		                   +regForm.getFirstName().toUpperCase() 
		                   + " " + regForm.getLastName().toUpperCase()+ "\nPlease Log In using your name and password !");
		regForm.setRegistered(true);
		login(names,regForm);
	}
	
	public void checkIfCustomer(RegistrationForm regForm) {
		System.out.println("Are you a member ?(yes/no)");
		String answer = scan.next();
		if(answer.equals("yes")){
			regForm.setMember(true);
		}else {
			regForm.setMember(false);
		}
	}
	
	public void login(String names[], RegistrationForm regForm) {
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		int count = 0;
		for (int i = 0; i < names.length; i++) {
			if(names[i].equalsIgnoreCase(name)) {
				System.out.println("Log in succesfull !");
				break;
			}else {
				count++;		
			}
		}
		if(count > 0) {
			System.out.println("You are not registered !");
			register(names,regForm);
		}
	}
	
}
