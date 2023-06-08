package views.sales;

import presenters.Presenter;
import router.Option;
import router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListenerSales implements ActionListener{
	private JPanelSales jPanelSales;
	private Presenter presenter;
	private int codActualProduct;


	public ListenerSales(JPanelSales jPanelSales, Presenter presenter) {
		this.presenter = presenter;
		this.jPanelSales = jPanelSales;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsSale actionsInvoice = ActionsSale.valueOf(e.getActionCommand());
		switch (actionsInvoice) {
			case SEARCH:
				String actualProduct = "";
				try {
					actualProduct = presenter.searchUpdateAndDelteProduct(
							Integer.parseInt(jPanelSales.getjTextFieldSearchProduct().getText()));
					if (!actualProduct.equals("")) {
						jPanelSales.loadProduct(actualProduct);
						codActualProduct = Integer.parseInt(jPanelSales.getjTextFieldSearchProduct().getText());
					}else{
						JOptionPane.showMessageDialog(null,"No se encotro el producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException ed){
					ed.printStackTrace();
					Router.instance.navigate(Option.login, presenter);
				}
				break;
			case CREATE:
				try {
							actualProduct = presenter.searchUpdateAndDelteProduct(
							Integer.parseInt(jPanelSales.getjTextFieldSearchProduct().getText()));
					int unitsAdviable = Integer.parseInt(jPanelSales.getjTextFieldUnitsAdviable().getText());
					int unitsSales = Integer.parseInt(jPanelSales.getjTextFieldUnitsProduct().getText());
					if (Integer.parseInt(actualProduct.split("-")[3]) >= unitsSales) {
						presenter.registerSoldProducts(
								Integer.parseInt(jPanelSales.getjTextFieldSearchProduct().getText()),
								jPanelSales.getjTextFieldNameProduct().getText(),
								jPanelSales.getjTextFieldDescriptionProduct().getText(),
								Double.parseDouble(jPanelSales.getjTextFieldPriceProduct().getText()),
								unitsSales);
						jPanelSales.showSoldProducts(presenter.showSoldProducts());
						jPanelSales.showProducts();
						e.notifyAll();
					}else{
						JOptionPane.showMessageDialog(null,"No hay unidades diponibles", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (NumberFormatException em){
					JOptionPane.showMessageDialog(null,"El umero de unidades debe ser un caracter numericico", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.homeUser, presenter);
				break;
		}
	}
}
