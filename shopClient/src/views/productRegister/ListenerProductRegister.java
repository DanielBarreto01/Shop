package views.productRegister;

import presenters.Presenter;
import router.Option;
import router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListenerProductRegister implements ActionListener{
	private JPanelProductRegister jPanelProductRegister;
	private Presenter presenter;


	public ListenerProductRegister(JPanelProductRegister jPanelProductRegister, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelProductRegister = jPanelProductRegister;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsInvoice actionsInvoice = ActionsInvoice.valueOf(e.getActionCommand());
		switch (actionsInvoice) {
			case REGISTER:
				boolean validate = true;
				try {
					validate = presenter.registerProduct(Integer.parseInt(jPanelProductRegister.getjTextFieldCod().getText()),
							jPanelProductRegister.getJName().getText(),
							jPanelProductRegister.getJDescription().getText(),
							Integer.parseInt(jPanelProductRegister.getJUnits().getText()),
							Double.parseDouble(jPanelProductRegister.getJPrice().getText()));
					if (validate) {
						JOptionPane.showMessageDialog(null, "registro correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						Router.instance.navigate(Option.homeAdministrator, presenter);
					} else {
						JOptionPane.showMessageDialog(null, "ya hay una persona registrada con ese unsuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException | IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "El codigo debe ser numerico", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.homeAdministrator, presenter);
				break;
		}
	}
}
