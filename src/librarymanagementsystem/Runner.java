package librarymanagementsystem;

public class Runner{
	
	public static void main(String[] args) {
		
		String names[] = {"Emily","Hannah","Madison","Ashley","Sarah","Alexis",
				"Samantha","Jessica","Elizabeth","Taylor","Lauren","Alyssa","Kayla",
				"Abigail","Brianna","Olivia","Emma","Megan","Grace","Victoria",
				"Rachel","Anna","Sydney","Destiny","Morgan","Jennifer","Jasmine",
				"Haley","Julia","Kaitlyn","Nicole","Amanda","Katherine","Natalie",
				"Hailey","Alexandra","Savannah","Chloe","Rebecca","Stephanie","Maria",
				"Sophia","Mackenzie","Allison","Isabella","Amber","Mary","Danielle",
				"Gabrielle","Jordan","Brooke","Michelle","Sierra","Katelyn","Andrea",
				"Madeline","Sara","Kimberly","Courtney","Erin","Brittany","Vanessa",
				"Jenna","Jacqueline","Caroline","Faith","Makayla","Bailey","Paige"};
		
		RegistrationForm regForm = new RegistrationForm();
		Methods methods = new Methods();
		
		System.out.println("-----===== Welcome to our Library =====-----");
		methods.checkIfCustomer(regForm);
		
		if(!regForm.isMember) {
			System.out.println("-----===== Please Register First =====-----");
			methods.register(names,regForm);
		}else {
			System.out.println("Great !!! Please Log In using your username and password !");
			methods.login(names,regForm);
		}
		
	
	}

}
