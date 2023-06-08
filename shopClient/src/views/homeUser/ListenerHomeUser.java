package views.homeUser;

import presenters.Presenter;
import router.Option;
import router.Router;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerHomeUser implements ActionListener, MouseListener{
private JPanelHomeUser jPanelHomeUser;
private Presenter presenter;
	
	public ListenerHomeUser(JPanelHomeUser jPanelHomeUser, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelHomeUser = jPanelHomeUser;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsHome actionsHome = ActionsHome.valueOf(e.getActionCommand());
		boolean validateAge = true;
		switch (actionsHome) {
			case EXIT:
				Router.instance.navigate(Option.login, presenter);
				break;
			case SALE:
				Router.instance.navigate(Option.registerSale, presenter);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			jPanelHomeUser.lateral();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
