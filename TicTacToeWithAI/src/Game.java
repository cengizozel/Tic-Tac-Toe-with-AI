import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	static int square = 1;
	static String emptyChar = " ";
	static String[][] boardNum = new String[3][3];
	static String winner = null;
	
	public static void initiateBoard(String[][] boardNum) {
		for(int i = 0; i <3; i++) {
            for(int j = 0; j < 3; j++) {
            	boardNum[i][j] = emptyChar;
            }
        }
	}
	
    public static void printBoard() {
    	
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.printf(" %s", "_");
        }
        System.out.printf("\n");

        for(int i = 0; i <3; i++) {
            System.out.printf("|");
            for(int j = 0; j < 3; j++) {
                System.out.printf("%s|",String.valueOf(boardNum[j][i]));
                square++;
            }
            System.out.printf("\n");
        }

        for(int i = 0; i < 3; i++) {
            System.out.printf(" %s", "-");
        }
        System.out.printf("\n \n");
    }
    
    public static String XorY(boolean yourTurn) {
    	if (yourTurn) {
    		return "X";
    	}
    	else {
    		return "O";
    	}
    }
    
    public static void placeMove(int choice, String letter) {
    	if (choice%3!=0) {
        	boardNum[(choice+3)%3-1][(int) Math.floor(choice/3)] = letter;
        }
        else {
        	boardNum[2][(choice/3)-1] = letter;
        }
    }
	
	public static boolean isOver() {
    	for(int i = 0; i <3; i++) {
	    	// Horizontal
	    	if ((boardNum[0][i] == boardNum[1][i]) && (boardNum[1][i] == boardNum[2][i]) && (boardNum[0][i] != emptyChar)) {
	    		winner = boardNum[0][i];
	    		return true;
	    	}
	    	// Vertical
	    	else if ((boardNum[i][0] == boardNum[i][1]) && (boardNum[i][1] == boardNum[i][2]) && (boardNum[i][0] != emptyChar)) {
	    		winner = boardNum[i][0];
	    		return true;
	    	}
    	}
	    	// Right Diagonal
    	if((boardNum[0][0] == boardNum[1][1]) && (boardNum[1][1] == boardNum[2][2]) && (boardNum[1][1] != emptyChar)) {
    		winner = boardNum[1][1];
    		return true;
    	}
    	// Left Diagonal
    	else if((boardNum[2][0] == boardNum[1][1]) && (boardNum[1][1] == boardNum[0][2]) && (boardNum[1][1] != emptyChar)) {
    		winner = boardNum[1][1];
    		return true;
    	}
    	// Tie
        for(int i = 0; i <3; i++) {
            for(int j = 0; j < 3; j++) {
                if (boardNum[j][i] == emptyChar) {
                	return false;
                }
            }
        }
        winner = "tie";
        return true;
    }
    
    public static boolean alreadyPlayed(int choice) {
    	if (choice%3!=0) {
        	if (boardNum[(choice+3)%3-1][(int) Math.floor(choice/3)] == " ") {
        		return false;
        	}
        }
        else {
        	if (boardNum[2][(choice/3)-1] == " ") {
        		return false;
        	}
        }
    	return true;
    }
    
    public static void minimax(Board board, int depth, int alpha, int beta, boolean isMaximizer) {
        if(depth == 0 || isOver()) {
            return;
        }
        if(isMaximizer) {
        	int maxEval = Integer.MIN_VALUE;
        	ArrayList<Integer> pActions = board.possibleActions();
        	for(int i = 0; i < pActions.size(); i ++) {
                Board cb = Board.copyBoard(board);
                cb = Board.dropChip(cb, pactions.get(i));
        		
        		int eval = minimax(cb, depth -1, alpha, beta, false)
        		maxEval = Math.max(maxEval, eval);
        	}
        }
    }
    
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		initiateBoard(boardNum);
        System.out.println("Welcome to Tic-Tac-Toe AI");
        System.out.println("You are X");
        printBoard();
        
        boolean yourTurn = true;
        
        while(!isOver()) {
        
	        System.out.println("Where do you want to move?");
	        int choice = Integer.parseInt(s.next());
	        
	        while (alreadyPlayed(choice)) {
	        	System.out.println("Already played.");
	        	System.out.println("Where do you want to move?");
		        choice = Integer.parseInt(s.next());
	        }
	        
	        placeMove(choice, XorY(yourTurn));
	        printBoard();
	        yourTurn = !yourTurn;
	        
	        if(!isOver()) {
		        while (alreadyPlayed(choice)) {
		        	choice = rand.nextInt(8)+1;
		        }
		        placeMove(choice, XorY(yourTurn));
		        printBoard();
		        yourTurn = !yourTurn;
	        }
        }
        if (winner != "tie") {
        	System.out.println( winner + " won!");
        }
        else {
        	System.out.println( "Tie.");
        }
	}
	
}
