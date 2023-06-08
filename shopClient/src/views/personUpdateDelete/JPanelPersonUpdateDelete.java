package views.personUpdateDelete;

import presenters.Presenter;
import views.text.RoundedBorder;
import views.text.TextPrompt;

import javax.swing.*;
import java.awt.*;


public class JPanelPersonUpdateDelete extends JPanel{
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
	private ListenerPersonUpdateDelete listenerPersonUpdateDelete;
	private JButton jButtonDelete;
	private JButton jButtonExit;
	private JButton jButtonSearch;
	private JButton jButtonUpdate;



	private String url = "./resources/imagenes/fondoS.jpeg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Image img = new ImageIcon(url).getImage();
		g.drawImage(img, 0, 0, (int)dimension.getWidth(), (int) dimension.getHeight(), this);
	}

	public JPanelPersonUpdateDelete(Presenter presenter) {
		listenerPersonUpdateDelete = new ListenerPersonUpdateDelete(this, presenter);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		jLabel = new JLabel();
		jLabel.setLayout(null);
		jLabel.setBounds(width - 1000, height - 600, width / 2, height / 2);
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(210, 201, 216, 140));
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
		jButtonSearch.addActionListener(listenerPersonUpdateDelete);
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

		jLabeCod = new JLabel("Ingrese el codigo");
		jLabeCod.setBounds(50, 100, 110, 30);
		jLabel.add(jLabeCod);

		jTextFieldCod = new JTextField();
		jTextFieldCod.setBounds(190, 100, 180, 30);
		new TextPrompt("Codigo",  jTextFieldCod);
		jLabel.add(jTextFieldCod);

		jLabelName = new JLabel("Ingrese el nombre");
		jLabelName.setBounds(50, 140, 110, 30);
		jLabel.add(jLabelName);

		jTextFieldName = new JTextField();
		jTextFieldName.setBounds(190, 140, 180, 30);
		new TextPrompt("Nombre",  jTextFieldName);
		jLabel.add(jTextFieldName);

		jLabelUserName = new JLabel("Ingrese el usuario");
		jLabelUserName.setBounds(50, 180, 110, 30);
		jLabel.add(jLabelUserName);

		jTextFieldUserName = new JTextField();
		jTextFieldUserName.setBounds(190, 180, 180, 30);
		new TextPrompt("Usuario",  jTextFieldUserName);
		jLabel.add(jTextFieldUserName);

		jLabelPassword = new JLabel("Ingrese contraseña");
		jLabelPassword.setBounds(50, 220, 120, 30);
		jLabel.add(jLabelPassword);

		jTextFieldPassword = new JTextField();
		jTextFieldPassword.setBounds(190, 220, 180, 30);
		new TextPrompt("Contraseña",  jTextFieldPassword);
		jLabel.add(jTextFieldPassword);



		jButtonExit = new JButton("Salir");
		jButtonExit.setBounds(400, 310, 130, 40);
		jButtonExit.addActionListener(listenerPersonUpdateDelete);
		jButtonExit.setActionCommand (ActionsInvoice.EXIT.toString());
		jLabel.add(jButtonExit);

		jComboBoxTypePerson = new JComboBox();
		jComboBoxTypePerson.addItem("Administrador");
		jComboBoxTypePerson.addItem("Usuario");
		jComboBoxTypePerson.setBounds(190,260,180,30);
		jLabel.add(jComboBoxTypePerson);

		jLabelTypePerson = new JLabel("persona");
		jLabelTypePerson.setBounds(50, 200, 180, 150);

		jButtonDelete = new JButton("Eliminar");
		jButtonDelete.setBounds(219, 310, 130, 40);
		jButtonDelete.setBackground(new Color(242, 152, 27));
		jLabel.add(jButtonDelete);

		jButtonUpdate = new JButton("Actualizar");
		jButtonUpdate.setBounds(50, 310,  130, 40);
		jButtonUpdate.setBackground(new Color(242, 152, 27));
		jLabel.add(jButtonUpdate);


		jLabel.repaint();

	}

	public void loadData(String person){
		jButtonDelete.addActionListener(listenerPersonUpdateDelete);
		jButtonDelete.setActionCommand(ActionsInvoice.DELETE.toString());

		jButtonUpdate.addActionListener(listenerPersonUpdateDelete);
		jButtonUpdate.setActionCommand(ActionsInvoice.UPDATE.toString());

		String[] loadPer = person.split("-");
		jTextFieldCod.setText(loadPer[0]);
		jTextFieldName.setText(loadPer[1]);
		jTextFieldUserName.setText(loadPer[2]);
		jTextFieldPassword.setText(loadPer[3]);
		jComboBoxTypePerson.setSelectedItem(loadPer[4]);
		System.out.println(person);
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
