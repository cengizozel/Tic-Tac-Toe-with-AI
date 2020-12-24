import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWindow2 extends JPanel implements ActionListener {
    
    AI ai = new AI_Minimax();
    Board board = new Board(3,3,3);
    Random r = new Random();
	boolean playerTurn = getRandomBoolean();
	boolean isAI = false;
	Font gameFont = new Font("MV Boli",Font.BOLD,75);
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	Button back = new Button("Back", true);
	
    GameWindow2() {
    	reset();
    	firstTurn();
    }

    
    public void reset() {
        ai = new AI_Minimax();
        board= new Board(3,3,3);
        r = new Random();
    	playerTurn = getRandomBoolean();
    	isAI = false;
    	gameFont = new Font("MV Boli",Font.BOLD,75);
    	titlePanel = new JPanel();
    	buttonPanel = new JPanel();
    	textfield = new JLabel();
    	buttons = new JButton[9];
    	back = new Button("Back", true);
    	
		this.removeAll();
		this.revalidate();
		
    	this.setLayout(new BorderLayout());
    	
    	textfield.setFont(gameFont);
    	textfield.setHorizontalAlignment(JLabel.CENTER);
    	textfield.setText("Tic-Tac-Toe");
    	textfield.setOpaque(true);
    	textfield.setBackground(Color.WHITE);
    	
    	titlePanel.setLayout(new BorderLayout());
    	
    	buttonPanel.setLayout(new GridLayout(3,3,5,5));
    	buttonPanel.setBackground(Color.BLACK);
    	
    	for(int i=0;i<9;i++) {
    		buttons[i] = new JButton();
    		buttonPanel.add(buttons[i]);
    		buttons[i].setBackground(Color.WHITE);
    		buttons[i].setFont(gameFont);
    		buttons[i].setFocusable(false);
    		buttons[i].addActionListener(this);
    	}
    	
    	titlePanel.add(textfield);
    	this.add(titlePanel,BorderLayout.NORTH);
    	this.add(buttonPanel);
    	
    	back.addActionListener(this);
    	back.setBackground(Color.WHITE);
    	this.add(back,BorderLayout.SOUTH);
    	
    	firstTurn();
    }
    
    public void p2Play(int choice) {
    	if(!board.isTerminal()) {
			buttons[choice].setForeground(new Color(0,0,255));
	    	buttons[choice].setText("O");
	        board = Board.playHere(board, choice);
	        board.setManTurn(true);
	        textfield.setText("X Turn");
    	}
    	check();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(board.getManTurn()) {
	            	int input = i;
                	int columnChoice = input;
                	if (board.squarePlayable(columnChoice)) {
                		System.out.println(i);
                    	buttons[i].setForeground(new Color(255,0,0));
                    	buttons[i].setText("X");
                        board = Board.playHere(board, columnChoice);
                        board.setManTurn(false);
                        textfield.setText("O Turn");
                        check();
                    }
	            }
	            else {
            		if(!board.isTerminal()) {
	            		p2Play(i);
	            	}
	            }
			}
		}
		GameIO.printBoard(board);
		if (e.getSource()==back) {
			
			reset();
			
			MainMenu.cl.show(MainMenu.panelCont, "1");
		}
	}
	
	public void check() {
		if(board.isTerminal()) {
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			
	        if(board.scoreBoard() <= -10000000) {
	        	textfield.setText("X Won!");
	        }
	        else if (board.scoreBoard() >= 10000000) {
	        	textfield.setText("O Won!");
	        }
	        else {
	        	textfield.setText("Tie");
	        }
		}
	}
	
	public void firstTurn() {
		AI_Minimax.depth = 25;

        board.setManTurn(playerTurn);
        
        if (board.getManTurn()) {
        	textfield.setText("X Turn");
        }
        else {
        	textfield.setText("O Turn");
        }
	}
	
    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}