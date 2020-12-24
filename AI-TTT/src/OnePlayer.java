import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class OnePlayer extends JPanel implements ActionListener {
	
	Button random = new Button("Random", false);
	Button easy = new Button("Easy", false);;
	Button medium = new Button("Medium", false);
	Button hard = new Button("Hard", false);
	Button impossible = new Button("Impossible", false);
	Button back = new Button("Back", true);
	
	OnePlayer() {
		this.setBounds(0,0,MainMenu.width,MainMenu.height);
		this.setLayout(new FlowLayout(1,1000,37));

		this.add(random);
		this.add(easy);
		this.add(medium);
		this.add(hard);
		this.add(impossible);
		this.add(back);
		
		random.addActionListener(this);
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		impossible.addActionListener(this);
		back.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==random) {
			MainMenu.dif = "random";
			MainMenu.cl.show(MainMenu.panelCont, "3");
		}
		if (e.getSource()==easy) {
			MainMenu.dif = "easy";
			MainMenu.cl.show(MainMenu.panelCont, "3");
		}
		if (e.getSource()==medium) {
			MainMenu.dif = "medium";
			MainMenu.cl.show(MainMenu.panelCont, "3");
		}
		if (e.getSource()==hard) {
			MainMenu.dif = "hard";
			MainMenu.cl.show(MainMenu.panelCont, "3");
		}
		if (e.getSource()==impossible) {
			MainMenu.dif = "impossible";
			MainMenu.cl.show(MainMenu.panelCont, "3");
		}
		if (e.getSource()==back) {
			MainMenu.cl.show(MainMenu.panelCont, "1");
		}
	}	
}
