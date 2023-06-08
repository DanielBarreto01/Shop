package views.homeAdministrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import presenters.Presenter;
import router.Option;
import router.Router;


public class ListenerHomeAdministrator implements ActionListener, MouseListener{
private JPanelHomeAdministrator jPanelHomeAdministrator;
private Presenter presenter;
	
	public ListenerHomeAdministrator(JPanelHomeAdministrator jPanelHomeAdministrator, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelHomeAdministrator = jPanelHomeAdministrator;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsHome actionsHome = views.homeAdministrator.ActionsHome.valueOf(e.getActionCommand());
		boolean validateAge = true;
		switch (actionsHome) {
			case EXIT:
				Router.instance.navigate(Option.login, presenter);
				break;
			case REGISTRY_PERSON:
				Router.instance.navigate(Option.add, presenter);
				break;
			case UP_PERSON:
				Router.instance.navigate(Option.update, presenter);
				break;
			case REGISTRY_PRODUCT:
				Router.instance.navigate(Option.registerProduct, presenter);
				break;
			case UP_PRODUCT:
				Router.instance.navigate(Option.updateDeleteProduct, presenter);
				break;
			case CASHIER_HISTORY:
				Router.instance.navigate(Option.cashier_history, presenter);
				break;
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
			jPanelHomeAdministrator.lateral();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
