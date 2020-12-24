import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JFrame {
	
	Start start = new Start();
	OnePlayer op = new OnePlayer();
	GameWindow1 gw1 = new GameWindow1();
	GameWindow2 gw2 = new GameWindow2();
	static JPanel panelCont = new JPanel();
	static CardLayout cl = new CardLayout();
	static String dif = null;
	static int numPlayers = 0;
	
	static int width = 750;
	static int height = 850;
	
	MainMenu() {
		this.setSize(width,height);
		this.setResizable(false);
		this.setTitle("Tic-Tac-Toe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelCont.setLayout(cl);
		panelCont.add(start, "1");
		panelCont.add(op, "2");
		panelCont.add(gw1, "3");
		panelCont.add(gw2, "4");
		
		cl.show(panelCont, "1");
		this.add(panelCont);
		
		this.setVisible(true);
	}
}
