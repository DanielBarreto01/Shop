package views.historySales;

import presenters.Presenter;
import router.Option;
import router.Router;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListenerHistorySales implements ActionListener{
	private JPanelHistorySales jPanelHistorySales;
	private Presenter presenter;
	private int codPersonActual;


	public ListenerHistorySales(JPanelHistorySales jPanelHistorySales, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelHistorySales = jPanelHistorySales;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsInvoice actionsInvoice = ActionsInvoice.valueOf(e.getActionCommand());
		switch (actionsInvoice){
			case SEARCH:
				try {
					jPanelHistorySales.showProducts(presenter.showSales(
							Integer.parseInt(jPanelHistorySales.getjTextFieldSearch().getText().toString())
					));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.homeAdministrator, presenter);
				break;
		}
	}
}
