package views.homeUser;

import javax.swing.*;
import java.awt.*;

public class BackgroundUser  extends JPanel{
	private String url ="./resources/imagenes/usuario.png";
	
	public BackgroundUser() {
		this.setSize(80,80);
	}

	@Override
	public void paint(Graphics g) {
		Dimension dimension= this.getSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width,dimension.height ,null);
		setOpaque(false);
		super.paintChildren(g);
	}
}
