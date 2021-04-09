package librarymanagementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Methods extends PasswordAndUsernameValidation{

	Scanner scan = new Scanner(System.in);
		
	public void register(String names[], RegistrationForm regForm){
		System.out.println("Please enter your first name!");
		regForm.setFirstName(scan.next());
		System.out.println("Please enter your last name!");
		regForm.setLastName(scan.next());
		System.out.println("===========================================");
		while (!passwordValidation(passwordDatabase)) {
			passwordValidation(passwordDatabase);		
		};
		System.out.println("===========================================");
		while(!usernameValidation()) {
			usernameValidation();
		};
		System.out.println("===========================================");
		System.out.println("---=== Registration successfull ! ===---\nThank you for registering " 
                +regForm.getFirstName().toUpperCase() 
                + " " + regForm.getLastName().toUpperCase());
		System.out.println("===========================================");
		System.out.println("Please Log In using your username and password !");
		regForm.setRegistered(true);
		login(names,regForm);
		
	}
	
	public void checkIfCustomer(RegistrationForm regForm) {
		System.out.println("Are you a member ?(yes/no)");
		String answer = scan.next();
		if(answer.equals("yes")){
			regForm.setMember(true);
		}else if(answer.equals("no")) {
			regForm.setMember(false);
		}else {
			System.out.println("Invalid input ! Please try again !");
			checkIfCustomer(regForm);
		}
	}
	
	public void login(String names[], RegistrationForm regForm) {
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
			System.out.println("You are not registered ! Please register !");
			register(names,regForm);
		}
	}
	
	public static Map<String, String> bookSearch(){
		
		BufferedReader br;
		List<String> linesList1 = new ArrayList<>();
		HashMap<String, String> hm = new HashMap<>();
		
		try {
			br = new BufferedReader(new FileReader("/Users/shadiahmed/eclipse-workspace/LibraryManagementSystemProject/src/librarymanagementsystem/bookdatabase.csv"));
			
			String lines1 = br.readLine();
			
			while(lines1 != null) {
				linesList1.add(lines1);
				lines1 = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("The book couldn't be found !" + e.getMessage());
		}
		
		for (String w : linesList1) {
			
			String arr[] = w.split(",");
			hm.put(arr[0].trim(), arr[1].trim());
		}
		
		System.out.println("Search a book");
		
		for (Entry<String, String> w : hm.entrySet()) {
			Scanner scan2 = new Scanner(System.in);
			if(hm.keySet().contains(scan2.nextLine())){
				System.out.println("You selected " + w.getKey() + ", " +w.getValue());
			}else {
				System.out.println("This book is not available !");
			}
		}
		
		return hm;
		
	}	
}
