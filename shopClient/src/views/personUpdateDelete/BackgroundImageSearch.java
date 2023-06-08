package views.personUpdateDelete;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundImageSearch extends JPanel {
	
	private String url = "./resources/imagenes/search.jpg";
	
	public BackgroundImageSearch() {
		this.setSize(50,50);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension= this.getSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width,dimension.height ,null);
		setOpaque(false);
		
	}
}
