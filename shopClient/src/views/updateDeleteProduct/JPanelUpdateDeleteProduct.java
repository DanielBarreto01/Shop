package views.updateDeleteProduct;

import presenters.Presenter;
import views.personUpdateDelete.BackgroundImageSearch;
import views.text.RoundedBorder;
import views.text.TextPrompt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.IOException;


public class JPanelUpdateDeleteProduct extends JPanel{
	private JLabel labelName;
	private JLabel labelNameProduct;
	private JTextField jTextFieldNameProduct;
	private JTextField jTextFieldSearchProduct;
	private JLabel labelDescription;
	private JTextField jTextFieldDescriptionProduct;
	private JLabel labelPrice;
	private JLabel jLabelCodPerson;
	private JTextField jTextFieldPriceProduct;
	private JTextField jTextFieldUnitsProduct;
	private JTextField jTextFieldCodProduct;
	private JButton jButtonDelet;
	private JButton jButtonClose;
	private JButton jButtonUpdate;
	private JButton jButtonSearch;
	private JLabel jLabel;
	private ListenerUpdateDeleteProduct listenerUpdateDeleteProduct;
	private JScrollPane jScrollPaneListProducts;
	private Presenter presenter;

	private String url = "./resources/imagenes/fondoS.jpeg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Image img = new ImageIcon(url).getImage();
		g.drawImage(img, 0, 0, (int)dimension.getWidth(), (int) dimension.getHeight(), this);
	}
	
	public JPanelUpdateDeleteProduct(Presenter presenter) {
	listenerUpdateDeleteProduct = new ListenerUpdateDeleteProduct(this, presenter);
	this.presenter = presenter;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();

	jLabel = new JLabel();
    jLabel.setBounds (100, height-600 , width-190, (height /2) + 50);
    jLabel.setOpaque(true);
	jLabel.setBackground(new Color(210, 201, 216, 140));
    this.add(jLabel);
    init();
	
	}

	private void init() {
		jTextFieldSearchProduct = new JTextField();
		jTextFieldSearchProduct.setBounds(120, 50, 144, 30);
		jTextFieldSearchProduct.setToolTipText("Ingrese Codido");
		new TextPrompt("Codigo",  jTextFieldSearchProduct);
		jTextFieldSearchProduct.setBackground(new Color(255, 230, 204));
		jLabel.add(jTextFieldSearchProduct);

		jButtonSearch = new JButton();
		BackgroundImageSearch searchIcon = new BackgroundImageSearch();
		jButtonSearch.add(searchIcon);
		jButtonSearch.setBounds(275, 50, 30, 30);
		jButtonSearch.setBackground(Color.white);
		jButtonSearch.addActionListener(listenerUpdateDeleteProduct);
		jButtonSearch.setActionCommand(ActionsInvoice.SEARCH.toString());
		jButtonSearch.setBorder(new RoundedBorder(5));
		jLabel.add(jButtonSearch);

		labelName = new JLabel("Actualizar Producto");
		Font fuente = new Font("Calibri", 3, 18);
		Font fuente2 = new Font("Calibri", 3, 12);
		labelName.setBounds(125, 14, 160, 30);
		labelName.setFont(new Font("Serif", Font.PLAIN, 14));
		labelName.setFont(fuente);
		labelName.setForeground(new Color(110, 81, 40));
		jLabel.add(labelName);

		jLabelCodPerson = new JLabel("Codigo");
		jLabelCodPerson.setBounds(167, 86, 100, 30);
		jLabelCodPerson.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelCodPerson.setFont(fuente2);
		jLabelCodPerson.setForeground(new Color(110, 81, 40));
		jLabel.add(jLabelCodPerson);

		labelNameProduct = new JLabel("Nombre");
		labelNameProduct.setBounds(165, 140, 100, 30);
		labelNameProduct.setFont(new Font("Serif", Font.PLAIN, 14));
		labelNameProduct.setFont(fuente2);
		labelNameProduct.setForeground(new Color(110, 81, 40));
		jLabel.add(labelNameProduct);

		labelDescription = new JLabel("Descripcion");
		labelDescription.setBounds(160, 206, 100, 30);
		labelDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		labelDescription.setFont(fuente2);
		labelDescription.setForeground(new Color(110, 81, 40));
		jLabel.add(labelDescription);

		labelPrice = new JLabel("Valor Unitario");
		labelPrice.setBounds(80, 295, 80, 30);
		labelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPrice.setFont(fuente2);
		labelPrice.setForeground(new Color(110, 81, 40));
		jLabel.add(labelPrice);

		labelPrice = new JLabel("Unidades ");
		labelPrice.setBounds(230, 295, 80, 30);
		labelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPrice.setFont(fuente2);
		labelPrice.setForeground(new Color(110, 81, 40));
		jLabel.add(labelPrice);

		jTextFieldCodProduct = new JTextField();
		jTextFieldCodProduct.setBounds(102, 110, 175, 30);
		jTextFieldCodProduct.setToolTipText("Ingrese codigo de persona");
		jTextFieldCodProduct.setBackground(new Color(255, 230, 204));
		jLabel.add(jTextFieldCodProduct);

		jTextFieldNameProduct = new JTextField();
		jTextFieldNameProduct.setBounds(102, 170, 180, 30);
		jTextFieldNameProduct.setToolTipText("Ingrese Nombre");
		jTextFieldNameProduct.setBackground(new Color(255, 230, 204));
		jLabel.add(jTextFieldNameProduct);

		jTextFieldDescriptionProduct = new JTextField();
		jTextFieldDescriptionProduct.setBounds(61, 232, 260, 60);
		jTextFieldDescriptionProduct.setToolTipText("Ingrese Descripcion");
		jTextFieldDescriptionProduct.setBackground(new Color(255, 230, 204));
		jLabel.add(jTextFieldDescriptionProduct);

		jTextFieldPriceProduct = new JTextField();
		jTextFieldPriceProduct.setBounds(62, 335, 90, 30);
		jTextFieldPriceProduct.setToolTipText("Precio");
		jTextFieldPriceProduct.setBackground(new Color(255, 230, 204));
		TextPrompt price = new TextPrompt("$$$$", jTextFieldPriceProduct);
		jLabel.add(jTextFieldPriceProduct);

		jTextFieldUnitsProduct = new JTextField();
		jTextFieldUnitsProduct.setBounds(230, 335, 90, 30);
		jTextFieldUnitsProduct.setToolTipText("Unidades");
		jTextFieldUnitsProduct.setBackground(new Color(255, 230, 204));
		TextPrompt Units = new TextPrompt("####", (JTextComponent) jTextFieldUnitsProduct);
		jLabel.add(jTextFieldUnitsProduct);

		jButtonUpdate = new JButton("Actualizar");
		jButtonUpdate.setBounds(280, 390, 90, 30);
		jButtonUpdate.setBackground(new Color(242, 152, 27));
		jButtonUpdate.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonUpdate);

		jButtonClose = new JButton("Cerrar");
		jButtonClose.setBounds(160, 390, 90, 30);
		jButtonClose.addActionListener(listenerUpdateDeleteProduct);
		jButtonClose.setBackground(new Color(114, 247, 167));
		jButtonClose.setActionCommand(ActionsInvoice.EXIT.toString());
		jButtonClose.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonClose);

		jButtonDelet = new JButton("Eliminar");
		jButtonDelet.setBounds(52, 390, 90, 30);
		jButtonDelet.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonDelet);
		jButtonDelet.setBackground(Color.RED);

		showProducts();
	}

	public void loadProduct(String pruduct){
		jButtonDelet.addActionListener(listenerUpdateDeleteProduct);
		jButtonDelet.setActionCommand(ActionsInvoice.DELETE.toString());

		jButtonUpdate.addActionListener(listenerUpdateDeleteProduct);
		jButtonUpdate.setActionCommand(ActionsInvoice.UPDATE.toString());

		String[] producComponents = pruduct.split("-");
		jTextFieldCodProduct.setText(producComponents[0]);
		jTextFieldNameProduct.setText(producComponents[1]);
		jTextFieldDescriptionProduct.setText(producComponents[2]);
		jTextFieldUnitsProduct.setText(producComponents[3]);
		jTextFieldPriceProduct.setText(producComponents[4]);


	}

	public void showProducts() {
		jScrollPaneListProducts = new JScrollPane();
		jScrollPaneListProducts.setBounds ( 500 , 90,660, 500 );

		String [] header = {"Codigo", "Nombre", "Descripcion", "Unidades", "Precio Unidad"};
		String []listProduct = new String[0];
		try {
			listProduct = presenter.showProducts().split("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String [][] body = new String[listProduct.length][5];
		for (int i = 0; i < body.length; i++) {
			String [] ShowProduct = listProduct[i].split("-");
			for (int j = 0; j < body[0].length; j++) {
				body[i][0] = ShowProduct[0];
				body[i][1] = ShowProduct[1];
				body[i][2] = ShowProduct[2];
				body[i][3] = ShowProduct[3];
				body[i][4] = ShowProduct[4];
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

		jScrollPaneListProducts.setViewportView(table);
		jScrollPaneListProducts.setBorder(new RoundedBorder(2));
		jScrollPaneListProducts.setOpaque(false);
		jScrollPaneListProducts.setBorder(BorderFactory.createEmptyBorder());
		jScrollPaneListProducts.getViewport().setOpaque(false);
		jLabel.add(jScrollPaneListProducts);
		jScrollPaneListProducts.setVisible(true);
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public JTextField getjTextFieldCodProduct() {
		return jTextFieldCodProduct;
	}

	public JTextField getjTextFieldNameProduct() {
		return jTextFieldNameProduct;
	}

	public JTextField getjTextFieldSearchProduct() {
		return jTextFieldSearchProduct;
	}

	public JTextField getjTextFieldDescriptionProduct() {
		return jTextFieldDescriptionProduct;
	}

	public JTextField getjTextFieldPriceProduct() {
		return jTextFieldPriceProduct;
	}

	public JTextField getjTextFieldUnitsProduct() {
		return jTextFieldUnitsProduct;
	}
}


