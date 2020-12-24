import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class Button extends JButton {
	
	Button(String text, boolean isBack) {
		this.setText(text);
		
		if(isBack) {
			this.setPreferredSize(new Dimension(150,50));
		}
		else {
			this.setPreferredSize(new Dimension(300,100));
			this.setFont(new Font("Serif", Font.BOLD, 25));
		}
	}
}
