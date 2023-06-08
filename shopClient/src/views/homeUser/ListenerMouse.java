package views.homeUser;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerMouse implements MouseListener {
	private JPanelHomeUser jPanelHome;
	
	public ListenerMouse(JPanelHomeUser jPanelHome) {
		this.jPanelHome = jPanelHome;
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		jPanelHome.e();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
