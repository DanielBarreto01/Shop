package views.personRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import presenters.Presenter;
import router.Option;
import router.Router;

import javax.swing.*;

public class ListenerPersonRegister implements ActionListener{
	private JPanelPersonRegister frameInvoice;
	private Presenter presenter;


	public ListenerPersonRegister(JPanelPersonRegister home, Presenter presenter) {
		this.presenter = presenter;
		this.frameInvoice= home;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsInvoice actionsInvoice = ActionsInvoice.valueOf(e.getActionCommand());
		switch (actionsInvoice){
			case SAVE:
				boolean com = true;
				try {
					com = presenter.add(Integer.parseInt(frameInvoice.getjTextFieldCod().getText()),
							frameInvoice.getjTextFieldName().getText(),
							frameInvoice.getjTextFieldUserName().getText(),
							frameInvoice.getjTextFieldPassword().getText(),
							frameInvoice.getjComboBoxTypePerson().getSelectedItem().toString());
					if (com){
						JOptionPane.showMessageDialog(null,"registro correcto", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
						Router.instance.navigate(Option.homeAdministrator, presenter);
					}
					else{
						JOptionPane.showMessageDialog(null,"ya hay una persona registrada con ese unsuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException | IOException ex) {
					JOptionPane.showMessageDialog(null,"El codigo debe ser numerico", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.homeAdministrator, presenter);
				break;
		}
	}
}
