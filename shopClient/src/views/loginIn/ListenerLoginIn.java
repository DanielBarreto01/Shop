package views.loginIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import presenters.Presenter;
import router.Router;
import router.Option;


public class ListenerLoginIn implements ActionListener {
	private JPanelLogin jFrameLoginIn;
	private Presenter presenter;

	public ListenerLoginIn(JPanelLogin jFrameLoginIn, Presenter presenter) {
		this.jFrameLoginIn = jFrameLoginIn;
		this.presenter = presenter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OptionLoginIn actionsRegistry = OptionLoginIn.valueOf(e.getActionCommand());
		switch (actionsRegistry) {
			case ENTER:
				try {
					String option = presenter.searchPerson(jFrameLoginIn.getJNameUse().getText(),
							jFrameLoginIn.getJNamePassword().getText());
					if (option.equals("1")) {
						Router.instance.navigate(Option.homeAdministrator, presenter);
					}else if (option.equals("2")){
						Router.instance.navigate(Option.homeUser, presenter);
					}else{
						JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				break;
		}
	}
}
