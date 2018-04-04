import java.util.Random;
import java.util.Scanner;

public class RPC {
	
	public static Scanner sc = new Scanner(System.in);
	public static int score = 0;
	public static int gameCount = 0;
	
	public static void main(String[] args) {
		play();
		while(playAgain()) {
			play();
		}
		
	}

	private static void play() {
		String computer = computerChoice();
		String user = userChoice();
		determineWinner(computer, user);
	}
	
	private static String userChoice() {
		String user = "Defult";
		do {
			System.out.println("Chosse your weapon: Rock, Paper, Scissors");
			user = sc.nextLine();
		} while(!isvalidChoice(user));
		return user;
	}

	private static boolean isvalidChoice(String choice) {
		boolean status;
		if(choice.equals("Rock"))
			status = true;
		else if(choice.equals("Paper"))
			status = true;
		else if(choice.equals("Scissors"))
			status = true;
		else {
			status = false;
			System.out.println("Invalid choice!! Try again!!");
		}
		return status;
	}

	private static String computerChoice() {
		Random rand = new Random();
		
		int cinput = rand.nextInt(3) + 1;
		String computer = "Thing";
		
		if(cinput == 1)
			computer = "Rock";
		if(cinput == 2)
			computer = "Paper";
		if(cinput == 3)
			computer = "Scissors";
		
		return computer;
	}

	private static boolean determineWinner(String computer, String user) {
		gameCount++;
		
		System.out.println("Computer choice: " + computer);
		System.out.println("User choice: " + user);
		
		if(computer.equals("Rock") && user.equals("Scissors")) {
			score--;
			System.out.println("Computer Wins");
		}
		if(computer.equals("Rock") && user.equals("Ppaper")) {
			score++;
			System.out.println("You Win!");
		}
		if(computer.equals("Paper") && user.equals("Scissors")) {
			score++;
			System.out.println("You Win!");
		}
		if(computer.equals("Paper") && user.equals("Rock")) {
			score--;
			System.out.println("Computer Wins");
		}
		if(computer.equals("Scissors") && user.equals("Rock")) {
			score++;
			System.out.println("You Win!");
		}
		if(computer.equals("Scissros") && user.equals("Paper")) {
			score--;
			System.out.println("Computer Wins");
		}
		if(computer.equals(user)) {
			System.out.println("Tie!! Play Again!!");
			return false;
		}
		if(score == 3 || score == -3) {
			System.out.println("You are the ultimate winner!!");
			}
		return true;
	}

	private static boolean playAgain() {
		System.out.println("Play again?(y/n)");
        String input = sc.nextLine();
        
        if (input.toLowerCase().equals("y"))
        {
            return true;
        } else if (input.toLowerCase().equals("n"))
        {
            return false;
        } else
        {
            System.out.println("Invalid Input");
            return playAgain();
        }
	}
}
