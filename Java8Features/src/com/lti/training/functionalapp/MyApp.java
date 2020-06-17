package com.lti.training.functionalapp;

// extension in existing functionality

class GreetingBase{
	/*
	// tightly coupled code
	public void conveyGreetings(String message) {
		// conveys message to console
		System.out.println(message);
	}*/
	// adding more method
	
	// loosly coupled code
	// inject the Greeting interface (what)
	public void conveyMessage(String message, Greetings greetings) {
		greetings.sendGreetings(message);
	}
}

public class MyApp {
	
	public void instanceMethod(String str) {
		System.out.println("Instance method : " + str);
	}

	public static void staticMethod(String str) {
		System.out.println("Static method : " + str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetingBase app = new GreetingBase();
		// app.conveyGreetings("Hello All");
		
		// Classical OO approach : (Imperative)
		Greetings emailGreeting = new EmailGreetings();
		Greetings smsGreeting = new SmsGreetings();
		
		app.conveyMessage("Hello All", emailGreeting);
		app.conveyMessage("Hello All", smsGreeting);
		
		app.conveyMessage("Hello All", new Greetings() {

			@Override
			public void sendGreetings(String message) {
				// TODO Auto-generated method stub
				System.out.println("Message Conveyed over Network : " + message);
			}
		});
		
		// like to inject functionality directly
		// FunctionalType variable = System.out.println("Message Conveyed over Network : " + message);
		// app.conveyMessage("Hello All", variable);
		
		// FunctionalType ~ interface (Functional interface)
		// lambda expression
		Greetings customGreeting = 
				(message)->System.out.println("Message Conveyed over Custom location :" + message);
		
		// app.conveyMessage("Hello All", customGreeting);
		app.conveyMessage("Hello All", 
						  message->System.out.println("Message Conveyed over Custom location :" + message));		
		
		// method reference
		Greetings instanceGreeting = new MyApp() :: instanceMethod;
		app.conveyMessage("Hello All", instanceGreeting);
		
		Greetings staticGreeting = MyApp :: staticMethod;
		app.conveyMessage("Hello All", staticGreeting);
		
		app.conveyMessage("Hello All", System.out::println);
		
	}

}
