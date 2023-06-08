package views.homeAdministrator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presenters.Presenter;
import java.awt.*;
import views.text.RoundedBorder;
import java.io.IOException;

public class JPanelHomeAdministrator extends JPanel{

	private ListenerHomeAdministrator listenerHome;
	private JPanel Jpannel;
	private JLabel jLabelUser;
	private JLabel jLabeName;
	private JLabel jLabeDespriction;
	private JLabel jLabelLocation;
	private JLabel jLabelPrice;
	private JLabel jLabelContac;
	private JButton jButtonRegisterPerson;
	private JButton jButtonRegisterProduct;
	private JButton jButtonUpdatePerson;
	private JButton jButtonUpdateProduct;
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
	private JScrollPane jScrollPaneListPerson;
	private JButton jButtonCashierHistory;

	private Dimension dimension;

	
	public JPanelHomeAdministrator(Presenter presenter) {
		this.setLayout(null);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.presenter = presenter;
		listenerHome = new ListenerHomeAdministrator(this , presenter);
		jLabel = new JLabel();
		jLabel.setBounds(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight());
		icon = new ImageIcon("./resources/imagenes/principal.jpg");
		init();
		this.add(jLabel);
		setEnabled(true);
		setVisible(true);	
	}

	private void init() {
		jLabelUser = new JLabel("Administrador");
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

		jLabeDespriction = new JLabel("de vivveres");
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

		jButtonUpdateProduct = new JButton("Actualizar o eliminar productos");
		jButtonUpdateProduct.setBounds(270, 85, 220, 34);
		jButtonUpdateProduct.setBorder(new RoundedBorder(10));
		jButtonUpdateProduct.setBackground(new Color(242, 152, 27));
		jButtonUpdateProduct.addActionListener(listenerHome);
		jButtonUpdateProduct.setActionCommand(ActionsHome.UP_PRODUCT.toString());
		jLabel.add(jButtonUpdateProduct);

		jButtonCashierHistory = new JButton("Hostorial cajero");
		jButtonCashierHistory.setBorder(new RoundedBorder(10));
		jButtonCashierHistory.setBackground(new Color(242, 152, 27));
		jButtonCashierHistory.addActionListener(listenerHome);
		jButtonCashierHistory.setActionCommand(ActionsHome.CASHIER_HISTORY.toString());
		jButtonCashierHistory.setBounds(730, 85, 190 ,34);
		jLabel.add(jButtonCashierHistory);

		jButtonRegisterProduct= new JButton("Registrar productos");
		jButtonRegisterProduct.setBounds(510, 85, 140, 34);
		jButtonRegisterProduct.setBorder(new RoundedBorder(10));
		jButtonRegisterProduct.setBackground(new Color(242, 152, 27));
		jButtonRegisterProduct.addActionListener(listenerHome);
		jButtonRegisterProduct.setActionCommand(ActionsHome.REGISTRY_PRODUCT.toString());
		jLabel.add(jButtonRegisterProduct);

		jButtonRegisterPerson = new JButton("Registrar Persona");
		jButtonRegisterPerson.setBounds((int)dimension.getWidth() - 390, 85, 150, 34);
		jButtonRegisterPerson.setBorder(new RoundedBorder(10));
		jButtonRegisterPerson.setBackground(new Color(242, 152, 27));
		jButtonRegisterPerson.addActionListener(listenerHome);
		jButtonRegisterPerson.setActionCommand(ActionsHome.REGISTRY_PERSON.toString());
		jLabel.add(jButtonRegisterPerson);

		jButtonUpdatePerson = new JButton("Actualizar o eliminar persona");
		jButtonUpdatePerson.setBounds((int)dimension.getWidth() - 225, 85, 200, 34);
		jButtonUpdatePerson.setBorder(new RoundedBorder(10));
		jButtonUpdatePerson.setBackground(new Color(242, 152, 27));
		jButtonUpdatePerson.addActionListener(listenerHome);
		jButtonUpdatePerson.setActionCommand(ActionsHome.UP_PERSON.toString());
		jLabel.add(jButtonUpdatePerson);

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
		BackgroundAdministrator backgroundAdministrator = new BackgroundAdministrator();
		jPanelIcon.add(backgroundAdministrator);
		menu1.add(jPanelIcon);
		menu1.setOpaque(true);
		menu1.setVisible(false);

		showPersons();
	}

	public void showPersons() {
		jScrollPaneListPerson = new JScrollPane();
		jScrollPaneListPerson.setBounds ( 200 , 150,660, 500 );

		String [] header = {"Codigo", "Nombre", "user", "Tipo de persona"};
		String []listPerson = new String[0];
		try {
			listPerson = presenter.showPerson().split("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String [][] body = new String[listPerson.length][4];
		for (int i = 0; i < body.length; i++) {
			String [] ShowPerson = listPerson[i].split("-");
			for (int j = 0; j < body[0].length; j++) {
				body[i][0] = ShowPerson[0];
				body[i][1] = ShowPerson[1];
				body[i][2] = ShowPerson[2];
				body[i][3] = ShowPerson[4];
			}
		}
		DefaultTableModel model = new DefaultTableModel(body, header);

		JTable table = new JTable(model);
		table.setVisible(true);
		table.getTableHeader().setBackground(new Color(127, 180, 211, 170));
		table.getTableHeader().setBorder(new RoundedBorder(2));
		table.setBackground(new Color(127, 180, 211, 170));
		table.setBorder(new RoundedBorder(2));
		table.setEnabled(false);
		table.setOpaque(true);
		table.setShowGrid(true);


		jScrollPaneListPerson.setBounds ( 220 , 280,540, 200 );
		jScrollPaneListPerson.setViewportView(table);
		jScrollPaneListPerson.setBorder(new RoundedBorder(2));
		jScrollPaneListPerson.setOpaque(false);
		jScrollPaneListPerson.setBorder(BorderFactory.createEmptyBorder());
		jScrollPaneListPerson.getViewport().setOpaque(false);
		jLabel.add(jScrollPaneListPerson);
		BackgroundFondo backgroundFondo = new BackgroundFondo();
		jLabel.add(backgroundFondo);
		backgroundFondo.addMouseListener(new ListenerMouse(this));
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
