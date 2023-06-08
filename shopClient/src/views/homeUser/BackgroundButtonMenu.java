package views.homeUser;

import javax.swing.*;
import java.awt.*;

public class BackgroundButtonMenu  extends JPanel{
	private String url ="./resources/imagenes/menu.png";
	
	public BackgroundButtonMenu() {
		this.setSize(30,30);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Dimension dimension= this.getSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width,dimension.height ,null);
		setOpaque(false);
		super.paintChildren(g);
		setOpaque(false);
		super.paintComponent(g);
	}
}
