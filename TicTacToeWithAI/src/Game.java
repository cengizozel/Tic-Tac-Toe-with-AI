import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Connect Four AI");
        System.out.println("__________________________");
        System.out.println("What would you like to play?");
        System.out.println("a) Tiny 3x3x3 Connect-Three Game");
        System.out.println("b) Standard 6x7x4 Connect-Three Game");
        System.out.printf(":");
        String choice = s.next();
        while(!choice.equals("a") && !choice.equals("A") && !choice.equals("b") && !choice.equals("B")) {
            System.out.println("Invalid Input Try Again");
            choice = s.next();
        }
		
	}
	
}
