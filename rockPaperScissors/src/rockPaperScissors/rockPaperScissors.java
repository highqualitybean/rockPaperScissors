package rockPaperScissors;
import java.util.*;
public class rockPaperScissors
{
	public static int humanWins = 0;
	public static int robotWins = 0;
	public static int ties = 0;
	public static void main(String [] args)
	{		
		Scanner input = new Scanner(System.in);
		
		ArrayList<ternary> humanMoveHistory = new ArrayList<ternary>();
		ArrayList<ternary> winHistory = new ArrayList<ternary>();
		System.out.println("0 quit\n1 rock\n2 paper\n3 scissor");
		
		while(true)
		{
			ternary userChoice = new ternary(0);
			
			userChoice.set(userInput(input));
			
			ternary robot = ai.logic(winHistory, humanMoveHistory);
			
			winHistory.add(winLose(userChoice, robot));
			humanMoveHistory.add(userChoice);
			System.out.print("\nYou: ");
			
			switch(userChoice.get())
			{
				case 1:
					System.out.print("scissor");
					break;
				case 0:
					System.out.print("paper");
					break;
				case -1:
					System.out.print("rock");
					break;
			}
			
			System.out.print("\nThem: ");
			
			switch(robot.get())
			{
				case 1:
					System.out.print("scissor");
					break;
				case 0:
					System.out.print("paper");
					break;
				case -1:
					System.out.print("rock");
					break;
			}
			
			switch(winLose(userChoice, robot).get())
			{
				case 1:
					System.out.print("\nWin\n--------------------\n");
					humanWins++;
					break;
				case 0:
					System.out.print("\nTie\n--------------------\n");
					ties++;
					break;
				case -1:
					System.out.print("\nLose\n--------------------\n");
					robotWins++;
					break;
			}
		}
	}

	public static int userInput(Scanner input)
	{
		int userInput = input.nextInt();
		if(userInput < 0 || userInput > 3)
		{
			throw(new IllegalArgumentException("Invalid input"));
		}else if(userInput == 0)
		{
			quit();
		}else
		{
			userInput -= 2;
			return userInput;
		}
		System.out.print(userInput);
		return userInput;
	}
	
	public static ternary winLose(ternary human, ternary robot) //-1 = lose, 0 = tie, 1 = win
	{
		ternary output = new ternary(0);
		output.add(human.get() - robot.get());//if human is 1 larger than robot than human wins (ie output == 1)
		return output;
	}
	
	public static void quit()
	{
		System.out.println("--------------------");
		System.out.println("W:T:L");
		System.out.println(humanWins + ":" + ties + ":" + robotWins);
		System.exit(0);
	}
}
