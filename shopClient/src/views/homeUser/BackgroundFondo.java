package views.homeUser;

import javax.swing.*;
import java.awt.*;

public class BackgroundFondo extends JLabel{
	private String url = "./resources/imagenes/fondopersona2.jpg";
	
	public BackgroundFondo(){
		this.setSize(1366, 768);
	}
	
	
	@Override
	public void paint(Graphics g) {
		Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintChildren(g);
	}
}
