package views;

import javax.swing.*;
import java.awt.*;

public class JFrameMain extends JFrame {
	
	public JFrameMain() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		this.setBounds(0,0, width, height);
		this.setTitle("Directorio");
		this.setLocationRelativeTo(null);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		//this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


		setVisible(true);
	}
}
