import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Start extends JPanel implements ActionListener {

	TitleLabel title = new TitleLabel();;
	Button oneP = new Button("1 Player", false);;
	Button twoP = new Button("2 Players", false);;
	OnePlayer op = new OnePlayer();
	GameWindow1 gw = new GameWindow1();
	
	Start() {
		
		this.setBounds(0,0,MainMenu.width,MainMenu.height);
		this.setLayout(new FlowLayout(1,1000,100));

    	oneP.addActionListener(this);
    	twoP.addActionListener(this);
    	
    	this.add(title);
    	this.add(oneP);
    	this.add(twoP);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==oneP) {
			MainMenu.numPlayers = 1;
			MainMenu.cl.show(MainMenu.panelCont, "2");
		}
		
		if (e.getSource()==twoP) {
			MainMenu.numPlayers = 2;
			MainMenu.cl.show(MainMenu.panelCont, "4");
		}
	}
}
