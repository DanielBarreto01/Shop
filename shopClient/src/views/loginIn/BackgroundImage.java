package views.loginIn;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundImage extends JPanel {
	
	private String url = "./resources/imagenes/fondo.png";
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension= this.getSize();
		ImageIcon ImageIcon = new ImageIcon(getClass().getResource(url));
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width,dimension.height ,null);
		setOpaque(false);	
	}
}
