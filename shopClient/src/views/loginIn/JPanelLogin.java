package views.loginIn;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import presenters.Presenter;
import views.text.TextPrompt;

import views.text.RoundedBorder;

public class JPanelLogin extends JPanel {
	//private JPanel login;
	private ListenerLoginIn listenerLoginIn;
	private BackgroundImage backgroundImage;
	private JLabel labelNameApp;
	private JTextField JNameUser;
	private JPasswordField jNamePassword;
	private JButton jButtonLogin;
	private JLabel labelWelcome;
	private JLabel jLabel;
	private ImageIcon icono;
	private ImageIcon iconod;
	private  Dimension dimension;
	
	private String url = "./resources/imagenes/superma.jpg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Image img = new ImageIcon(url).getImage();
		g.drawImage(img, 0, 0, (int)dimension.getWidth(), (int) dimension.getHeight(), this);
	}
	
	public JPanelLogin(Presenter presenter) {
		this.setLayout(null);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		jLabel = new JLabel();
		jLabel.setBounds(500, 40, dimension.width-950 , dimension.height-300);
		jLabel.setBackground(new Color(86, 110, 140, 90));
		jLabel.setOpaque(true);
		icono = new ImageIcon("./resources/imagenes/fondo.png");
		this.add(jLabel);
		listenerLoginIn = new ListenerLoginIn(this, presenter);
		init();
	}

	public void init() {	
		
		labelNameApp = new JLabel("Distribuidora");
		Font fuente = new Font("Calibri", 3, 36);
		labelNameApp.setBounds(120, 60, 280, 60);
		labelNameApp.setFont(new Font("Serif", Font.PLAIN, 14));
		labelNameApp.setFont(fuente);
		labelNameApp.setForeground(new Color(219, 245, 96));
		jLabel.add(labelNameApp);

		labelWelcome = new JLabel("Bienvenido");
		Font fuenteWelcome = new Font("Calibri", 3, 18);
		labelWelcome.setBounds((int) 165, 160, 150, 60);
		labelWelcome.setFont(new Font("Serif", Font.PLAIN, 14));
		labelWelcome.setFont(fuenteWelcome);
		labelWelcome.setForeground(new Color(219, 243, 95));
		jLabel.add(labelWelcome);

		JNameUser = new JTextField();
		JNameUser.setBounds(115, 240, 180, 30);
		TextPrompt use = new TextPrompt("Usuario",  JNameUser);
		jLabel.add(JNameUser);

		jNamePassword = new JPasswordField();
		jNamePassword.setBounds(115, 300, 180, 30);
		jNamePassword.setEchoChar('*');
		jNamePassword.setToolTipText("Ingrese Contraseña");
        TextPrompt password = new TextPrompt("Contraseña",  jNamePassword);
        jLabel.add(jNamePassword);

		jButtonLogin = new JButton("Ingresar");
		jButtonLogin.setBounds(165, 360, 80, 30);
		jButtonLogin.addActionListener(listenerLoginIn);
		jButtonLogin.setActionCommand ( OptionLoginIn . ENTER . toString ());
		jButtonLogin.setBorder(new RoundedBorder(10));
		jButtonLogin.setBackground(new Color(242, 152, 27));
		
	
		jLabel.add(jButtonLogin);
		
		
	}

	public JTextField getJNameUse() {
		return JNameUser;
	}
	public JPasswordField getJNamePassword() {
		return jNamePassword;
	}
	
	
	
}
