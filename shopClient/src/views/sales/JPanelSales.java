package views.sales;

import presenters.Presenter;
import views.personUpdateDelete.BackgroundImageSearch;
import views.text.RoundedBorder;
import views.text.TextPrompt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.IOException;


public class JPanelSales extends JPanel{
	private JLabel labelName;
	private JLabel labelNameProduct;
	private JTextField jTextFieldNameProduct;
	private JTextField jTextFieldSearchProduct;
	private JLabel labelDescription;
	private JTextField jTextFieldDescriptionProduct;
	private JLabel labelPrice;
	private JLabel jLabelUnitsAdviable;
	private JTextField jTextFieldPriceProduct;
	private JTextField jTextFieldUnitsProduct;
	private JTextField jTextFieldUnitsAdviable;
	private JButton jButtonClose;
	private JButton jButtonUpdate;
	private JButton jButtonSearch;
	private JLabel jLabel;
	private ListenerSales listenerUpdateDeleteProduct;
	private JScrollPane jScrollPaneListProducts;
	private Presenter presenter;
	private JScrollPane jScrollPaneListSoldProducts;

	private String url = "./resources/imagenes/fondoS.jpeg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Image img = new ImageIcon(url).getImage();
		g.drawImage(img, 0, 0, (int)dimension.getWidth(), (int) dimension.getHeight(), this);
	}
	
	public JPanelSales(Presenter presenter) {
	listenerUpdateDeleteProduct = new ListenerSales(this, presenter);
	this.presenter = presenter;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();

	jLabel = new JLabel();
    jLabel.setBounds (100, 0 , width-190, height);
    jLabel.setOpaque(true);
	jLabel.setBackground(new Color(210, 201, 216));
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
		jButtonSearch.setActionCommand(ActionsSale.SEARCH.toString());
		jButtonSearch.setBorder(new RoundedBorder(5));
		jLabel.add(jButtonSearch);

		labelName = new JLabel("Venta");
		Font fuente = new Font("Calibri", 3, 18);
		Font fuente2 = new Font("Calibri", 3, 12);
		labelName.setBounds(145, 14, 160, 30);
		labelName.setFont(new Font("Serif", Font.PLAIN, 14));
		labelName.setFont(fuente);
		labelName.setForeground(new Color(110, 81, 40));
		jLabel.add(labelName);

		jLabelUnitsAdviable = new JLabel("Unidades disponibles");
		jLabelUnitsAdviable.setBounds(150, 86, 120, 30);
		jLabelUnitsAdviable.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelUnitsAdviable.setFont(fuente2);
		jLabelUnitsAdviable.setForeground(new Color(110, 81, 40));
		jLabel.add(jLabelUnitsAdviable);

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

		jTextFieldUnitsAdviable = new JTextField();
		jTextFieldUnitsAdviable.setBounds(102, 110, 175, 30);
		jTextFieldUnitsAdviable.setEditable(false);
		jTextFieldUnitsAdviable.setBackground(new Color(255, 230, 204));
		jLabel.add(jTextFieldUnitsAdviable);

		jTextFieldNameProduct = new JTextField();
		jTextFieldNameProduct.setBounds(102, 170, 180, 30);
		jTextFieldNameProduct.setEditable(false);
		jTextFieldNameProduct.setBackground(new Color(255, 230, 204));
		jLabel.add(jTextFieldNameProduct);

		jTextFieldDescriptionProduct = new JTextField();
		jTextFieldDescriptionProduct.setBounds(61, 232, 260, 60);
		jTextFieldDescriptionProduct.setEditable(false);
		jTextFieldDescriptionProduct.setBackground(new Color(255, 230, 204));
		jLabel.add(jTextFieldDescriptionProduct);

		jTextFieldPriceProduct = new JTextField();
		jTextFieldPriceProduct.setBounds(62, 335, 90, 30);
		jTextFieldPriceProduct.setBackground(new Color(255, 230, 204));
		jTextFieldPriceProduct.setEditable(false);
		TextPrompt price = new TextPrompt("$$$$", jTextFieldPriceProduct);
		jLabel.add(jTextFieldPriceProduct);

		jTextFieldUnitsProduct = new JTextField();
		jTextFieldUnitsProduct.setBounds(230, 335, 90, 30);
		jTextFieldUnitsProduct.setToolTipText("Unidades a comprar");
		jTextFieldUnitsProduct.setBackground(new Color(245, 230, 204));
		TextPrompt Units = new TextPrompt("####", (JTextComponent) jTextFieldUnitsProduct);
		jLabel.add(jTextFieldUnitsProduct);

		jButtonUpdate = new JButton("Vender");
		jButtonUpdate.setBounds(280, 390, 90, 30);
		jButtonUpdate.setBackground(new Color(242, 152, 27));
		jButtonUpdate.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonUpdate);

		jButtonClose = new JButton("Cerrar");
		jButtonClose.setBounds(160, 390, 90, 30);
		jButtonClose.addActionListener(listenerUpdateDeleteProduct);
		jButtonClose.setBackground(new Color(114, 247, 167));
		jButtonClose.setActionCommand(ActionsSale.EXIT.toString());
		jButtonClose.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonClose);

		jScrollPaneListSoldProducts = new JScrollPane();
		jScrollPaneListSoldProducts.setBounds ( 500 , 330,660, 300 );

		jScrollPaneListProducts = new JScrollPane();
		jScrollPaneListProducts.setBounds ( 500 , 90,660, 200 );

		showProducts();
	}

	public void loadProduct(String pruduct){
		jButtonUpdate.addActionListener(listenerUpdateDeleteProduct);
		jButtonUpdate.setActionCommand(ActionsSale.CREATE.toString());

		String[] producComponents = pruduct.split("-");
		jTextFieldUnitsAdviable.setText(producComponents[3]);
		jTextFieldNameProduct.setText(producComponents[1]);
		jTextFieldDescriptionProduct.setText(producComponents[2]);
		jTextFieldPriceProduct.setText(producComponents[4]);


	}

	public void showProducts() {

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
		table.setBackground(new Color(127, 180, 211));
		table.setBorder(new RoundedBorder(2));
		//table.setEnabled(false);
		table.setOpaque(true);
		//table.setShowGrid(true);

		jScrollPaneListProducts.setViewportView(table);
		jScrollPaneListProducts.setBorder(new RoundedBorder(2));
		jScrollPaneListProducts.setOpaque(false);
		jScrollPaneListProducts.setBorder(BorderFactory.createEmptyBorder());
		jScrollPaneListProducts.getViewport().setOpaque(false);
		jLabel.add(jScrollPaneListProducts);
		jScrollPaneListProducts.setVisible(true);
		jScrollPaneListProducts.repaint();
		jLabel.repaint();

	}

	public void showSoldProducts(String soldProducts) {
		double total = 0;
		String [] header = {"Codigo produ", "Nombre y descrip", "unidades vendidas", "precio total"};
		String []listProduct = new String[0];
		listProduct = soldProducts.split("\n");
		String [][] body = new String[listProduct.length + 2][5];
		for (int i = 0; i < body.length -2; i++) {
			String [] showProduct = listProduct[i].split("-");
			System.out.println(listProduct[i]);
			for (int j = 1; j < body[0].length; j++) {
				//body[i][0] = showProduct[0];
				body[i][0] = showProduct[1];
				body[i][1] = showProduct[2];
				body[i][2] = showProduct[3];
				body[i][3] = showProduct[4];
			}
			total += Double.parseDouble(showProduct[4]);
		}
		body [body.length - 1][0]  = "total de la venta";
		body [body.length - 1][3] = total +"";
		DefaultTableModel model = new DefaultTableModel(body, header);
		JTable table = new JTable(model);
		table.setVisible(true);
		table.getTableHeader().setBackground(new Color(127, 180, 211, 170));
		table.getTableHeader().setBorder(new RoundedBorder(2));
		table.setBackground(new Color(127, 180, 211));
		table.setBorder(new RoundedBorder(2));
		table.setEnabled(false);
		table.setOpaque(true);
		table.setShowGrid(true);

		jScrollPaneListSoldProducts.setViewportView(table);
		jScrollPaneListSoldProducts.setBorder(new RoundedBorder(2));
		jScrollPaneListSoldProducts.setOpaque(false);
		jScrollPaneListSoldProducts.setBorder(BorderFactory.createEmptyBorder());
		jScrollPaneListSoldProducts.getViewport().setOpaque(false);
		jLabel.add(jScrollPaneListSoldProducts);
		jScrollPaneListSoldProducts.setVisible(true);
		jScrollPaneListSoldProducts. repaint();
		jLabel.revalidate();

	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public JTextField getjTextFieldUnitsAdviable() {
		return jTextFieldUnitsAdviable;
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


