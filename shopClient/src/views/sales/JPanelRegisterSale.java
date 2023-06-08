package views.sales;

import presenters.Presenter;
import views.personRegister.ActionsInvoice;
import views.text.TextPrompt;

import javax.swing.*;
import java.awt.*;


public class JPanelRegisterSale extends JPanel{
	private JLabel jLabel;
	private JLabel jLabeCod;
	private JLabel jLabelName;
	private JTextField jTextFieldCod;
	private JTextField jTextFieldName;
	private ListenerRegisterSale listenerHome;
	private JButton jButtonSave;
	private JButton jButtonExit;

	private String url = "./resources/imagenes/fondoS.jpeg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Image img = new ImageIcon(url).getImage();
		g.drawImage(img, 0, 0, (int)dimension.getWidth(), (int) dimension.getHeight(), this);
	}
	
	public JPanelRegisterSale(Presenter presenter) {
	listenerHome = new ListenerRegisterSale(this, presenter);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();

	jLabel = new JLabel();
    jLabel.setBounds (  width-1000 , height-600 , width / 2, height /2);
    jLabel.setOpaque(true);
	jLabel.setBackground(new Color(210, 201, 216, 140));
    this.add(jLabel);
    init();
	
	}

	private void init() {
		int heightC = jLabel.getSize().height;
		int widthC = jLabel.getSize().width;

		jLabeCod = new JLabel("Ingrese la cedula del cliente");
		jLabeCod.setBounds(30, 50, 170, 30);
		jLabel.add(jLabeCod);

		jTextFieldCod = new JTextField();
		jTextFieldCod.setBounds(210, 50, 180, 30);
		new TextPrompt("Cedula",  jTextFieldCod);
		jLabel.add(jTextFieldCod);

		jLabelName = new JLabel("Ingrese el nombre del cliente");
		jLabelName.setBounds(30, 90, 190, 30);
		jLabel.add(jLabelName);

		jTextFieldName = new JTextField();
		jTextFieldName.setBounds(210, 90, 180, 30);
		new TextPrompt("Nombre",  jTextFieldName);
		jLabel.add(jTextFieldName);


		jButtonSave = new JButton("Siguiente");
		jButtonSave.setBounds(130, 260, 180, 50);
		jButtonSave.addActionListener(listenerHome);
		jButtonSave.setBackground(new Color(242, 152, 27));
		jButtonSave.setActionCommand (ActionsInvoice.SAVE.toString());
		jLabel.add(jButtonSave);

		jButtonExit = new JButton("Salir");
		jButtonExit.setBounds(340, 260, 180, 50);
		jButtonExit.addActionListener(listenerHome);
		jButtonExit.setActionCommand (ActionsInvoice.EXIT.toString());
		jLabel.add(jButtonExit);
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

}
