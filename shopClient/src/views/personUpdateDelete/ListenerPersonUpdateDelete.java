package views.personUpdateDelete;

import presenters.Presenter;
import router.Option;
import router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListenerPersonUpdateDelete implements ActionListener{
	private JPanelPersonUpdateDelete jPanelPersonUpdateDelete;
	private Presenter presenter;
	private int codPersonActual;


	public ListenerPersonUpdateDelete(JPanelPersonUpdateDelete jPanelPersonUpdateDelete, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelPersonUpdateDelete= jPanelPersonUpdateDelete;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsInvoice actionsInvoice = views.personUpdateDelete.ActionsInvoice.valueOf(e.getActionCommand());
		switch (actionsInvoice){
			case UPDATE:
				boolean com = true;
				try {
					com = presenter.updatePerson(jPanelPersonUpdateDelete.getjTextFieldCod().getText(),
							jPanelPersonUpdateDelete.getjTextFieldName().getText(),
							jPanelPersonUpdateDelete.getjTextFieldUserName().getText(),
							jPanelPersonUpdateDelete.getjTextFieldPassword().getText(),
							jPanelPersonUpdateDelete.getjComboBoxTypePerson().getSelectedItem().toString(),
							codPersonActual);

				} catch (IOException ex) {
					ex.printStackTrace();
				}
				if (com){
					JOptionPane.showMessageDialog(null,"Se actualizo correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
					Router.instance.navigate(Option.homeAdministrator, presenter);

				}
				else{
					JOptionPane.showMessageDialog(null,"ya hay una persona registrada con ese unsuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case DELETE:
				boolean validate = false;
				try {
					validate = presenter.deltePerson(codPersonActual);
					if (validate){
						JOptionPane.showMessageDialog(null,"Se elimino correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
						Router.instance.navigate(Option.homeAdministrator, presenter);
					}else {
						JOptionPane.showMessageDialog(null,"debe haber minimo un administrador", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				break;
			case SEARCH:
				String person = null;
				try {
					person = presenter.searchUpdatePerson(
							Integer.parseInt(jPanelPersonUpdateDelete.getjTextFieldSearch().getText()));
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (NumberFormatException em){
					JOptionPane.showMessageDialog(null,"El codigo debe ser numerico", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				if (!person.equals("0")){
					codPersonActual = Integer.parseInt(jPanelPersonUpdateDelete.getjTextFieldSearch().getText());
					jPanelPersonUpdateDelete.loadData(person);
				}else{
					JOptionPane.showMessageDialog(null,"No se encontro a la persona", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.homeAdministrator, presenter);
				break;
		}
	}
}
