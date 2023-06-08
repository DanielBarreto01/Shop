package views.homeAdministrator;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundAdministrator extends JPanel{
	private String url ="./resources/imagenes/usuario.png";
	
	public BackgroundAdministrator() {
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
