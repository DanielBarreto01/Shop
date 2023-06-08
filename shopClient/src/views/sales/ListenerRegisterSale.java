package views.sales;

import presenters.Presenter;
import router.Option;
import router.Router;
import views.personRegister.ActionsInvoice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListenerRegisterSale implements ActionListener{
	private JPanelRegisterSale jPanelRegisterSale;
	private Presenter presenter;


	public ListenerRegisterSale(JPanelRegisterSale jPanelRegisterSale, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelRegisterSale = jPanelRegisterSale;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsInvoice actionsInvoice = ActionsInvoice.valueOf(e.getActionCommand());
		switch (actionsInvoice){
			case SAVE:
				String idClient = jPanelRegisterSale.getjTextFieldCod().getText();
				String nameClient = jPanelRegisterSale.getjTextFieldName().getText();
				try {
					if (!(idClient.isBlank() && nameClient.isBlank())) {
						presenter.registerCleint(idClient, nameClient);
						Router.instance.navigate(Option.sales, presenter);
					}else {
						JOptionPane.showMessageDialog(null, "no puede haber campos vacios", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.homeUser, presenter);
				break;
		}
	}
}
