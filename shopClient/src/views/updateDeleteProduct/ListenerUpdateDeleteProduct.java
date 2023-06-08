package views.updateDeleteProduct;

import presenters.Presenter;
import router.Option;
import router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListenerUpdateDeleteProduct implements ActionListener{
	private JPanelUpdateDeleteProduct jPanelUpdateDeleteProduct;
	private Presenter presenter;
	private int codActualProduct;


	public ListenerUpdateDeleteProduct(JPanelUpdateDeleteProduct jPanelUpdateDeleteProduct, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelUpdateDeleteProduct= jPanelUpdateDeleteProduct;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsInvoice actionsInvoice = ActionsInvoice.valueOf(e.getActionCommand());
		switch (actionsInvoice) {
			case SEARCH:
				String validate = "";
				try {
					validate = presenter.searchUpdateAndDelteProduct(
							Integer.parseInt(jPanelUpdateDeleteProduct.getjTextFieldSearchProduct().getText()));
					if (!validate.equals("")) {
						jPanelUpdateDeleteProduct.loadProduct(validate);
						codActualProduct = Integer.parseInt(jPanelUpdateDeleteProduct.getjTextFieldCodProduct().getText());
					}else{
						JOptionPane.showMessageDialog(null,"No se encotro el producto", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException ed){
					ed.printStackTrace();
					Router.instance.navigate(Option.login, presenter);
				}
				break;
			case UPDATE:
				boolean validateUpdate = false;
				try {
					validateUpdate = presenter.updateProduct(
							Integer.parseInt(jPanelUpdateDeleteProduct.getjTextFieldCodProduct().getText()),
							jPanelUpdateDeleteProduct.getjTextFieldNameProduct().getText(),
							jPanelUpdateDeleteProduct.getjTextFieldDescriptionProduct().getText(),
							Integer.parseInt(jPanelUpdateDeleteProduct.getjTextFieldUnitsProduct().getText()),
							Double.parseDouble(jPanelUpdateDeleteProduct.getjTextFieldPriceProduct().getText()),
							codActualProduct
							);
					if (validateUpdate){
						JOptionPane.showMessageDialog(null,"registro correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						Router.instance.navigate(Option.homeAdministrator, presenter);
					}
					else{
						JOptionPane.showMessageDialog(null,"ya hay una producto registrado con ese codigo", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException | IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"El codigo debe ser numerico", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case DELETE:
				boolean validateOptionDelete = false;
				try {
					validateOptionDelete = presenter.deleteProduct(codActualProduct);
					if (validateOptionDelete) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente", "infromacion", JOptionPane.INFORMATION_MESSAGE);
						Router.instance.navigate(Option.homeAdministrator, presenter);
					}else{
						JOptionPane.showMessageDialog(null,"No se pudo eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
					Router.instance.navigate(Option.login, presenter);

				}
				break;
			case EXIT:
				Router.instance.navigate(Option.homeAdministrator, presenter);
				break;
		}
	}
}
