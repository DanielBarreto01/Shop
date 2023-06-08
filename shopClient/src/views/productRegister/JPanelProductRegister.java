package views.productRegister;

import presenters.Presenter;
import views.text.RoundedBorder;
import views.text.TextPrompt;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;


public class JPanelProductRegister extends JPanel{
	private JLabel labelName;
	private JLabel labelNameProduct;
	private JLabel jlabelCodPerson;
	private JTextField JName;
	private JTextField JSearch;
	private JTextField jTextFieldCod;
	private JLabel labelDescription;
	private JTextField JDescription;
	private JLabel labelPrice;
	private JTextField JPrice;
	private JTextField JUnits;
	private JButton jButtonUpdate;
	private JLabel jLabel;
	private ListenerProductRegister listenerProductRegister;
	private JButton jButtonExit;

	private String url = "./resources/imagenes/fondoS.jpeg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Image img = new ImageIcon(url).getImage();
		g.drawImage(img, 0, 0, (int)dimension.getWidth(), (int) dimension.getHeight(), this);
	}
	
	public JPanelProductRegister(Presenter presenter) {
	listenerProductRegister = new ListenerProductRegister(this, presenter);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();

	jLabel = new JLabel();
    jLabel.setBounds (  width-860 , height-600 , (width / 2)-290, height /2);
    jLabel.setOpaque(true);
	jLabel.setBackground(new Color(210, 201, 216, 140));
    this.add(jLabel);
    init();
	
	}

	private void init() {
		labelName = new JLabel("Registro Producto");
		Font fuente = new Font("Calibri", 3, 18);
		Font fuente2 = new Font("Calibri", 3, 12);
		labelName.setBounds(125, 9, 160, 30);
		labelName.setFont(new Font("Serif", Font.PLAIN, 14));
		labelName.setFont(fuente);
		labelName.setForeground(new Color(110, 81, 40));
		jLabel.add(labelName);

		jlabelCodPerson = new JLabel("codigo");
		jlabelCodPerson.setBounds(165, 30, 100, 30);
		jLabel.add(jlabelCodPerson);

		jTextFieldCod = new JTextField();
		jTextFieldCod.setBounds(102, 60, 180, 30);
		jTextFieldCod.setToolTipText("Ingrese el codigo");
		jLabel.add(jTextFieldCod);

		labelNameProduct = new JLabel("Nombre");
		labelNameProduct.setBounds(165, 92, 100, 30);
		labelNameProduct.setFont(new Font("Serif", Font.PLAIN, 14));
		labelNameProduct.setFont(fuente2);
		labelNameProduct.setForeground(new Color(110, 81, 40));
		jLabel.add(labelNameProduct);

		labelDescription = new JLabel("Descripcion");
		labelDescription.setBounds(160, 165, 100, 30);
		labelDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		labelDescription.setFont(fuente2);
		labelDescription.setForeground(new Color(110, 81, 40));
		jLabel.add(labelDescription);

		labelPrice = new JLabel("Valor Unitario");
		labelPrice.setBounds(80, 262, 80, 30);
		labelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPrice.setFont(fuente2);
		labelPrice.setForeground(new Color(110, 81, 40));
		jLabel.add(labelPrice);

		labelPrice = new JLabel("Unidades ");
		labelPrice.setBounds(230, 262, 80, 30);
		labelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPrice.setFont(fuente2);
		labelPrice.setForeground(new Color(110, 81, 40));
		jLabel.add(labelPrice);

		JName = new JTextField();
		JName.setBounds(102, 122, 180, 30);
		JName.setToolTipText("Ingrese Nombre");
		JName.setBackground(new Color(255, 230, 204));
		jLabel.add(JName);

		JDescription = new JTextField();
		JDescription.setBounds(61, 192, 260, 60);
		JDescription.setToolTipText("Ingrese Descripcion");
		JDescription.setBackground(new Color(255, 230, 204));
		jLabel.add(JDescription);

		JPrice = new JTextField();
		JPrice.setBounds(62, 295, 90, 30);
		JPrice.setToolTipText("Precio");
		JPrice.setBackground(new Color(255, 230, 204));
		TextPrompt price = new TextPrompt("$$$$", (JTextComponent) JPrice);
		jLabel.add(JPrice);

		JUnits = new JTextField();
		JUnits.setBounds(230, 295, 90, 30);
		JUnits.setToolTipText("Unidades");
		JUnits.setBackground(new Color(255, 230, 204));
		TextPrompt Units = new TextPrompt("####", (JTextComponent) JUnits);
		jLabel.add(JUnits);

		jButtonUpdate = new JButton("Registrar");
		jButtonUpdate.setBounds(80, 342, 90, 30);
		jButtonUpdate.setBackground(new Color(242, 152, 27));
		jButtonUpdate.addActionListener(listenerProductRegister);
		jButtonUpdate.setActionCommand(ActionsInvoice.REGISTER.toString());
		jButtonUpdate.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonUpdate);

		jButtonExit = new JButton("Salir");
		jButtonExit.setBounds(200, 342, 90, 30);
		jButtonExit.setBackground(new Color(242, 152, 27));
		jButtonExit.addActionListener(listenerProductRegister);
		jButtonExit.setActionCommand(ActionsInvoice.EXIT.toString());
		jButtonExit.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonExit);
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public JTextField getJName() {
		return JName;
	}

	public JTextField getJSearch() {
		return JSearch;
	}

	public JTextField getjTextFieldCod() {
		return jTextFieldCod;
	}

	public JTextField getJDescription() {
		return JDescription;
	}

	public JTextField getJPrice() {
		return JPrice;
	}

	public JTextField getJUnits() {
		return JUnits;
	}
}


