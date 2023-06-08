package views.homeUser;

import presenters.Presenter;
import views.homeAdministrator.BackgroundFondo;
import views.text.RoundedBorder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class JPanelHomeUser extends JPanel{

	private ListenerHomeUser listenerHome;
	private JPanel Jpannel;
	private JLabel jLabelUser;
	private JLabel jLabeName;
	private JLabel jLabeDespriction;
	private JLabel jLabelLocation;
	private JLabel jLabelPrice;
	private JLabel jLabelContac;
	private JButton jButtonRegisterPerson;
	private JLabel menu;
	private JLabel menu1;
	private JButton jButtonExit;
	private JLabel JlabelUser;
	private JLabel JlabelUserClose;
	private JLabel JlabelUserCloseTwo;
	private JLabel jPanelIcon;
	private JLabel jLabelNameUser;
	private Presenter presenter;
	private JLabel jLabel;
	private ImageIcon icon;

	private Dimension dimension;

	
	public JPanelHomeUser(Presenter presenter) {
		this.setLayout(null);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.presenter = presenter;
		listenerHome = new ListenerHomeUser(this , presenter);
		jLabel = new JLabel();
		jLabel.setBounds(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight());
		icon = new ImageIcon("./resources/imagenes/principal.jpg");
		init();
		this.add(jLabel);
		setEnabled(true);
		setVisible(true);	
	}

	private void init() {
		jLabelUser = new JLabel("Usuario");
		jLabelUser.setBounds(10, 15, 150, 50);
		Font fuente = new Font("Calibri", 3, 18);
		jLabelUser.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelUser.setFont(fuente);
		jLabelUser.setForeground(new Color(255,255,255));
		jLabel.add(jLabelUser);
		
		jLabelContac = new JLabel("(+52) 3209266940");
		jLabelContac.setBounds(1180, 15, 150, 50);
		jLabelContac.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelContac.setFont(fuente);
		jLabelContac.setForeground(new Color(255,255,255));
		jLabel.add(jLabelContac);
		
		jLabelLocation = new JLabel("Ubicacion");
		jLabelLocation.setBounds(920, 15, 150, 50);
		jLabelLocation.setToolTipText("Tunja / Boyaca");
		jLabelLocation.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelLocation.setFont(fuente);
		jLabelLocation.setForeground(new Color(255,255,255));
		jLabel.add(jLabelLocation);
		
		jLabelPrice = new JLabel("Valor Asociacion");
		jLabelPrice.setBounds(1020, 15, 150, 50);
		jLabelPrice.setToolTipText("$$$$$$$");
		jLabelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelPrice.setFont(fuente);
		jLabelPrice.setForeground(new Color(255,255,255));
		jLabel.add(jLabelPrice);
		
		
		jLabeName = new JLabel("Distribuidora");
		jLabeName.setBounds(600, 380, 1000, 120);
		Font fuente2 = new Font("Calibri", 3, 80);
		jLabeName.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabeName.setFont(fuente2);
		jLabeName.setForeground(new Color(109, 109, 109, 140));
		jLabel.add(jLabeName);

		jLabeDespriction = new JLabel("de viveres");
		jLabeDespriction.setBounds(640, 450, 1000, 120);
		Font fuente3 = new Font("Calibri", 3, 58);
		jLabeDespriction.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabeDespriction.setFont(fuente3);
		jLabeDespriction.setForeground(new Color(109, 109, 109, 140));
		jLabel.add(jLabeDespriction);

		Jpannel = new JPanel();
		Jpannel.setBounds(0, 0, 1620, 80);
		Jpannel.setBackground(new Color(110, 81, 40));
		jLabel.add(Jpannel);


		jButtonRegisterPerson = new JButton("Realizar una venta");
		jButtonRegisterPerson.setBounds((int)dimension.getWidth() - 390, 85, 150, 34);
		jButtonRegisterPerson.setBorder(new RoundedBorder(10));
		jButtonRegisterPerson.setBackground(new Color(242, 152, 27));
		jButtonRegisterPerson.addActionListener(listenerHome);
		jButtonRegisterPerson.setActionCommand(ActionsHome.SALE.toString());
		jLabel.add(jButtonRegisterPerson);


		menu = new JLabel();
		menu.setLayout(null);
		menu.setBounds(10,90,40,40);
		BackgroundButtonMenu menuOption = new BackgroundButtonMenu();
		menu.add(menuOption);
		setOpaque(false);
		menu.addMouseListener(listenerHome);
		jLabel.add(menu);
	
		menu1 = new JLabel();
		menu1.setBounds(0,80,200,305);
		menu1.setBackground(new Color(171,217,250,98));
		menu1.setBorder(new RoundedBorder(2));
		jLabel.add(menu1);
	
		
		jButtonExit = new JButton("Salir");
		jButtonExit.setBounds(50,250,80, 30);
		jButtonExit.setBackground(Color.PINK);
		jButtonExit.setBackground(new Color(242, 152, 27));
		jButtonExit.addActionListener(listenerHome);
		jButtonExit.setActionCommand(ActionsHome.EXIT.toString());
		jButtonExit.setBorder(new RoundedBorder(5));
		menu1.add(jButtonExit);
		
		JlabelUserClose = new JLabel("Cooperativa cafetera de");
		JlabelUserClose.setBounds(30, 40, 150, 50);
		Font fuenteClose = new Font("Calibri", 3, 12);
		JlabelUserClose.setFont(new Font("Serif", Font.PLAIN, 14));
		JlabelUserClose.setFont(fuenteClose);
		JlabelUserClose.setForeground(new Color(255,255,255));
		menu1.add(JlabelUserClose);	

		JlabelUserCloseTwo = new JLabel("Colombia");
		JlabelUserCloseTwo.setBounds(70, 60, 150, 50);
		JlabelUserCloseTwo.setFont(new Font("Serif", Font.PLAIN, 14));
		JlabelUserCloseTwo.setFont(fuenteClose);
		JlabelUserCloseTwo.setForeground(new Color(255, 255, 255));
		menu1.add(JlabelUserCloseTwo);

		jLabelNameUser = new JLabel(presenter.getNameActualPerson());
		jLabelNameUser.setBounds(40, 200, 120, 20);
		jLabelNameUser.setForeground(new Color(246, 243, 249));
		jLabelNameUser.setBackground(Color.red);
		menu1.add(jLabelNameUser);

		jPanelIcon = new JLabel("");
		jPanelIcon.setBounds(50, 100, 80, 80);
		jPanelIcon.setBackground(new Color(0, 0, 0, 0));
		BackgroundUser nn = new BackgroundUser();
		jPanelIcon.add(nn);
		menu1.add(jPanelIcon);
		menu1.setOpaque(true);
		menu1.setVisible(false);
		BackgroundFondo backgroundFondo = new BackgroundFondo();
		jLabel.add(backgroundFondo);

	}
	public void lateral() {
		menu1.setVisible(true);
		menu.setVisible(false);
	}

	public void e() {
		menu1.setVisible(false);
		menu.setVisible(true);
	}

}
