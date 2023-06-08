package router;

import javax.swing.JPanel;

import presenters.Presenter;
import views.JFrameMain;
import views.historySales.JPanelHistorySales;
import views.homeUser.JPanelHomeUser;
import views.personRegister.JPanelPersonRegister;
import views.homeAdministrator.JPanelHomeAdministrator;
import views.loginIn.JPanelLogin;
import views.personUpdateDelete.JPanelPersonUpdateDelete;
import views.productRegister.JPanelProductRegister;
import views.sales.JPanelRegisterSale;
import views.sales.JPanelSales;
import views.updateDeleteProduct.JPanelUpdateDeleteProduct;

public record Router(JFrameMain jFrameMain) {
	
	public static Router instance = null;

	public void navigate(Option route, Presenter presenter) {
        switch (route) {
			case login -> goTo(new JPanelLogin(presenter));
        	case add -> goTo(new JPanelPersonRegister(presenter));
			case homeAdministrator -> goTo(new JPanelHomeAdministrator(presenter));
			case homeUser -> goTo(new JPanelHomeUser(presenter));
			case update -> goTo(new JPanelPersonUpdateDelete(presenter));
			case registerProduct -> goTo(new JPanelProductRegister(presenter));
			case updateDeleteProduct -> goTo(new JPanelUpdateDeleteProduct(presenter));
			case sales -> goTo(new JPanelSales(presenter));
			case registerSale -> goTo(new JPanelRegisterSale(presenter));
			case cashier_history -> goTo(new JPanelHistorySales(presenter));
        }
    }

   private void goTo(JPanel jPanel) {
    	jPanel.setLayout(null);
    	jFrameMain.setContentPane(jPanel);
    	jFrameMain.revalidate();
	}
}
