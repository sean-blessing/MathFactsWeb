package com.mathfacts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import com.mathfacts.business.UserRepository;
import com.mathfacts.business.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mathfacts.business.FactsNumbers;
import com.mathfacts.business.Game;
import com.mathfacts.business.Operation;
import com.mathfacts.business.User;
import com.mathfacts.util.Console;

@SpringBootApplication
@EnableJpaRepositories("com.mathfacts.business")
public class MathFactsWebApplication {
	private static boolean loggedOn = false;
	private static User user = null;
	private static UserService userSvc;


	public static void main(String[] args) {
		SpringApplication.run(MathFactsWebApplication.class, args);
		StringBuilder msg = new StringBuilder("Welcome to the math facts app!\n");
		msg.append("Each option will present 10 problems.  Your stats will be recorded\n");
		msg.append("and a summary will be displayed upon completion.\n");
		msg.append("Good luck!!!\n");
		System.out.println(msg);

		userLogin();
		String choice = Console.getString(displayMenu());
		while (!choice.equalsIgnoreCase("x")) {
			long startTime = System.currentTimeMillis();
			Timestamp datePlayed = new Timestamp(startTime);
			Game g = playMathFacts(choice);
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			g.setDatePlayed(datePlayed);
			g.setStartTime(startTime);
			g.setEndTime(endTime);
			SimpleDateFormat sdf = new SimpleDateFormat("K:mm:ss' 'a");
			System.out.println("\n====================================");
			System.out.println("Thanks for playing, "+user.getFirstName()+"!!!");
			System.out.println("Start time = "+sdf.format(startTime));
			System.out.println("End time = "+sdf.format(endTime));
			BigDecimal secondsBD = new BigDecimal(elapsedTime);
			secondsBD = secondsBD.divide(new BigDecimal(1000)).setScale(1, RoundingMode.HALF_UP);
			System.out.println("Elapsed time (seconds) = "+secondsBD);
			g.setElapsedTime(secondsBD.doubleValue());
			System.out.println("# right: "+g.getNumRight());
			System.out.println("# wrong: "+g.getNumWrong());
			System.out.println("====================================");
			choice = Console.getString(displayMenu());
		}
		System.out.println("Bye!");
	}
	
	private static Game playMathFacts(String choice) {
		Operation opr = null;
		switch (choice.toUpperCase()) {
			case "A":	opr = new Operation("Addition", "+");
						break;
			case "S":	opr = new Operation("Subtraction", "-");
						break;
			case "M":	opr = new Operation("Multiplication", "*");
						break;
			case "D":	opr = new Operation("Division", "/");
						break;
		}
		System.out.println(opr.getOperationString()+" Facts\n");
		int numRight = 0;
		int numWrong = 0;
		Game g = new Game(user,choice);
		boolean correct = false;
		
		for (int i=1; i<=10; i++) {
			FactsNumbers fn = FactsNumbers.generateFactsNumbers(opr);
			int num1 = fn.getNumber1();
			int num2 = fn.getNumber2();
			while (!correct) {
				System.out.println("Question #"+i+":");
				int ans = Console.getInt(num1 +" "+opr.getOperationSymbol()+" " + num2 + " = ");
				int expResult = getExpectedResult(num1,num2,opr);
				if  (ans == expResult) {
					numRight++;
					correct = true;
					System.out.println("Correct!");
				}
				else {
					numWrong++;
					System.out.println("Wrong!  Try again.");
				}
			}
			correct = false;
		}
		g.setNumRight(numRight);
		g.setNumWrong(numWrong);
		return g;
	}
	
	private static int getExpectedResult(int n1, int n2, Operation opr) {
		int er = 0;
		IntBinaryOperator ibo = null;
		switch (opr.getOperationSymbol()) {
		case "+":	ibo = (a, b) -> a + b;
					break;
		case "-":	ibo = (a, b) -> a - b;
					break;
		case "*":	ibo = (a, b) -> a * b;
					break;
		case "/":	ibo = (a, b) -> a / b;
					break;
		}
		er = ibo.applyAsInt(n1, n2);
		return er;
	}
	
	private static void playMultiplicationFacts() {
		System.out.println("Multiplication Facts\n");
		int numRight = 0;
		int numWrong = 0;
		boolean correct = false;
		
		for (int i=1; i<=10; i++) {
			int num1 = getRandomNbr();
			int num2 = getRandomNbr();
			while (!correct) {
				System.out.println("Question #"+i+":");
				int ans = Console.getInt(num1 +" x " + num2 + " = ");
				if  (ans == num1 * num2) {
					numRight++;
					correct = true;
					System.out.println("Correct!");
				}
				else {
					numWrong++;
					System.out.println("Wrong!  Try again.");
				}
			}
			correct = false;
		}
		System.out.println("Stats:");
		System.out.println("# right = "+ numRight);
		System.out.println("# wrong = "+ numWrong);
	}
	
	private static void playDivisionFacts() {
		System.out.println("Function not yet implemented.");
	}

	private static void playAdditionFacts() {
		System.out.println("Function not yet implemented.");
	}

	private static void playSubtractionFacts() {
		System.out.println("Function not yet implemented.");
	}

	private static String displayMenu() {
		StringBuilder msg = new StringBuilder("Math Facts Menu:\n");
		msg.append("A - Addition\n");
		msg.append("S - Subtraction\n");
		msg.append("M - Multiplication\n");
		msg.append("D - Division\n");
		msg.append("X - Exit\n");
		msg.append("Please select an option:\n");
		return msg.toString();
	}
	
	private static int getRandomNbr() {
		int a = (int)(Math.random()*10);
		return a;
	}

	private static void userLogin() {
		while (!loggedOn) {
			String userName = Console.getString("Enter userName:  ");
			String pwd = Console.getString("Enter Password:  ");

			UserService uSvc = new UserService();
			User u = uSvc.userRepo.findByUserNameAndPassword(userName,pwd);
			if (u!=null) {
				System.out.println("Welcome "+u.getFirstName()+"!!");
				user = u;
				loggedOn = true;
			}
			else {
				System.err.println("Invalid login.  Please try again.");
			}
		}
	}

}
