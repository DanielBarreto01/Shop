package views.personRegister;

import javax.swing.*;

import presenters.Presenter;
import views.text.*;

import java.awt.*;


public class JPanelPersonRegister extends JPanel{
	private JLabel jLabel;
	private JLabel jLabeCod;
	private JLabel jLabelName;
	private JLabel jLabelUserName;
	private JLabel jLabelPassword;
	private JTextField jTextFieldCod;
	private JTextField jTextFieldName;
	private JTextField jTextFieldUserName;
	private JTextField jTextFieldPassword;
	private JComboBox jComboBoxTypePerson;
	private JLabel jLabelTypePerson;
	private ListenerPersonRegister listenerHome;
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
	
	public JPanelPersonRegister(Presenter presenter) {
	listenerHome = new ListenerPersonRegister(this, presenter);
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

		jLabeCod = new JLabel("Ingrese el codigo");
		jLabeCod.setBounds(50, 50, 110, 30);
		jLabel.add(jLabeCod);

		jTextFieldCod = new JTextField();
		jTextFieldCod.setBounds(190, 50, 180, 30);
		new TextPrompt("Codigo",  jTextFieldCod);
		jLabel.add(jTextFieldCod);

		jLabelName = new JLabel("Ingrese el nombre");
		jLabelName.setBounds(50, 90, 110, 30);
		jLabel.add(jLabelName);

		jTextFieldName = new JTextField();
		jTextFieldName.setBounds(190, 90, 180, 30);
		new TextPrompt("Nombre",  jTextFieldName);
		jLabel.add(jTextFieldName);

		jLabelUserName = new JLabel("Ingrese el usuario");
		jLabelUserName.setBounds(50, 130, 110, 30);
		jLabel.add(jLabelUserName);

		jTextFieldUserName = new JTextField();
		jTextFieldUserName.setBounds(190, 130, 180, 30);
		new TextPrompt("Usuario",  jTextFieldUserName);
		jLabel.add(jTextFieldUserName);

		jLabelPassword = new JLabel("Ingrese contraseña");
		jLabelPassword.setBounds(50, 170, 120, 30);
		jLabel.add(jLabelPassword);

		jTextFieldPassword = new JTextField();
		jTextFieldPassword.setBounds(190, 170, 180, 30);
		new TextPrompt("Contraseña",  jTextFieldPassword);
		jLabel.add(jTextFieldPassword);

		jButtonSave = new JButton("Guardar");
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

		jComboBoxTypePerson = new JComboBox();
		jComboBoxTypePerson.addItem("Administrador");
		jComboBoxTypePerson.addItem("Usuario");
		jComboBoxTypePerson.setBounds(190,210,180,30);
		jLabel.add(jComboBoxTypePerson);

		jLabelTypePerson = new JLabel("persona");
		jLabelTypePerson.setBounds(50, 150, 180, 150);
		jLabel.add(jLabelTypePerson);
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
}
