import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TitleLabel extends JLabel {
	
	TitleLabel() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setText("TIC-TAC-TOE");
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Serif", Font.PLAIN, 75));
	}
}
