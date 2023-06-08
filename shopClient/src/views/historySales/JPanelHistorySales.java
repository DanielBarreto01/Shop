package views.historySales;

import presenters.Presenter;
import views.text.RoundedBorder;
import views.text.TextPrompt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class JPanelHistorySales extends JPanel{
	private JLabel jLabel;
	private JLabel jLabeCod;
	private JLabel jLabelName;
	private JLabel jLabelUserName;
	private JLabel jLabelPassword;
	private JLabel jLabelSearch;
	private JTextField jTextFieldSearch;
	private JTextField jTextFieldCod;
	private JTextField jTextFieldName;
	private JTextField jTextFieldUserName;
	private JTextField jTextFieldPassword;
	private JComboBox jComboBoxTypePerson;
	private JLabel jLabelTypePerson;
	private ListenerHistorySales listenerHistorySales;
	private JButton jButtonDelete;
	private JButton jButtonExit;
	private JButton jButtonSearch;
	private JButton jButtonUpdate;
	private JScrollPane jScrollPaneListSales;



	private String url = "./resources/imagenes/fondoS.jpeg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Image img = new ImageIcon(url).getImage();
		g.drawImage(img, 0, 0, (int)dimension.getWidth(), (int) dimension.getHeight(), this);
	}

	public JPanelHistorySales(Presenter presenter) {
		listenerHistorySales = new ListenerHistorySales(this, presenter);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		jLabel = new JLabel();
		jLabel.setLayout(null);
		jLabel.setBounds(0, height - 700, width, height -300);
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(210, 201, 216));
		this.add(jLabel);
		init();
	}

	private void init() {
		int heightC = jLabel.getSize().height;
		int widthC = jLabel.getSize().width;

		jButtonSearch = new JButton();
		BackgroundImageSearch searchIcon = new BackgroundImageSearch();
		jButtonSearch.add(searchIcon);
		jButtonSearch.setBounds(336, 60, 30, 30);
		jButtonSearch.setBackground(Color.white);
		jButtonSearch.addActionListener(listenerHistorySales);
		jButtonSearch.setActionCommand(ActionsInvoice.SEARCH.toString());
		jButtonSearch.setBorder(new RoundedBorder(5));
		jButtonSearch.setVisible(true);
		jLabel.add(jButtonSearch);

		jLabelSearch = new JLabel("Buscar");
		jLabelSearch.setBounds(50, 60, 110, 30);
		jLabel.add(jLabelSearch);

		jTextFieldSearch = new JTextField();
		jTextFieldSearch.setBounds(190, 60, 139, 30);
		new TextPrompt("Ingrese el codigo de la persona",  jTextFieldSearch);
		jLabel.add(jTextFieldSearch);


		jButtonExit = new JButton("Salir");
		jButtonExit.setBounds(400, 310, 130, 40);
		jButtonExit.addActionListener(listenerHistorySales);
		jButtonExit.setActionCommand (ActionsInvoice.EXIT.toString());
		jLabel.add(jButtonExit);


		jButtonUpdate = new JButton("Buscar");
		jButtonUpdate.setBounds(50, 310,  130, 40);
		jButtonUpdate.setBackground(new Color(242, 152, 27));

		jLabel.add(jButtonUpdate);

		jScrollPaneListSales = new JScrollPane();
		jScrollPaneListSales.setBounds ( 550 , 150,660, 300 );


	}

	public void showProducts(String listSales) {
		System.out.println(listSales);
		String [] header = {"cod venta", "cod cajero", "nombre cliente", "fecha"};
		String []listProduct = new String[0];
		listProduct = listSales.split("\n");
		String [][] body = new String[listProduct.length][4];
		for (int i = 0; i < body.length; i++) {
			String [] ShowProduct = listProduct[i].split("-");
			for (int j = 0; j < body[0].length; j++) {
				body[i][0] = ShowProduct[0];
				body[i][1] = ShowProduct[1];
				body[i][2] = ShowProduct[2];
				body[i][3] = ShowProduct[3];
			}
		}
		DefaultTableModel model = new DefaultTableModel(body, header);
		JTable table = new JTable(model);
		table.setVisible(true);
		table.getTableHeader().setBackground(new Color(127, 180, 211, 170));
		table.getTableHeader().setBorder(new RoundedBorder(2));
		table.setBackground(new Color(127, 180, 211));
		table.setBorder(new RoundedBorder(2));
		//table.setEnabled(false);
		table.setOpaque(true);
		//table.setShowGrid(true);

		jScrollPaneListSales.setViewportView(table);
		jScrollPaneListSales.setBorder(new RoundedBorder(2));
		jScrollPaneListSales.setOpaque(false);
		jScrollPaneListSales.setBorder(BorderFactory.createEmptyBorder());
		jScrollPaneListSales.getViewport().setOpaque(false);
		jLabel.add(jScrollPaneListSales);
		jScrollPaneListSales.setVisible(true);
		//jScrollPaneListSales.repaint();
		//jLabel.repaint();

	}

	public void loadData(String person){
		jButtonUpdate.addActionListener(listenerHistorySales);
		jButtonUpdate.setActionCommand(ActionsInvoice.UPDATE.toString());

	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public JTextField getjTextFieldCod() {
		return jTextFieldCod;
	}

	public JTextField getjTextFieldName() {
		return jTextFieldName;
	}

	public JTextField getjTextFieldUserName() {
		return jTextFieldUserName;
	}

	public JTextField getjTextFieldPassword() {
		return jTextFieldPassword;
	}

	public JComboBox getjComboBoxTypePerson() {
		return jComboBoxTypePerson;
	}

	public JTextField getjTextFieldSearch() {
		return jTextFieldSearch;
	}
}
