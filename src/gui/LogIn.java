package gui;

import java.awt.*;

import javax.swing.*;

import otros.IConstants;

public class LogIn extends JFrame implements IConstants {

    private JTextField mail;
    private JTextField password;
	private JButton botonLogIn;
    private JButton botonRegister;
	private JPanel panelLogIn;
	private JLabel passwordLabel;
	private JLabel mailLabel;

	public LogIn() {
		super("Capturar la bandera");
		
		this.setLayout(null);
		this.setSize(PANTALLA_ANCHURA, PANTALLA_ALTURA);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        initComponents();
        
        this.setVisible(true);
	}
	
	private void initComponents() {
		panelLogIn = new JPanel();
		panelLogIn.setBounds(0, 0, PANTALLA_ANCHURA, PANTALLA_ALTURA);
		panelLogIn.setLayout(null);
		this.getContentPane().add(panelLogIn);

		mailLabel = new JLabel();
		mailLabel.setText("email");
		mailLabel.setBounds(USER_LABEL_X, USER_LABEL_Y, DEFAUL_LABEL_WIDTH, DEFAUL_LABEL_HEIGHT);
		panelLogIn.add(mailLabel);
		
		mail = new JTextField();
		mail.setAlignmentX(Component.CENTER_ALIGNMENT);
		mail.setBounds(USER_INPUT_X, USER_INPUT_Y, TEXTLABEL_ANCHURA, DEFAULT_BUTTON_ALTURA);
		panelLogIn.add(mail);

		passwordLabel = new JLabel();
		passwordLabel.setText("password");
		passwordLabel.setBounds(PASSWORD_LABEL_X, PASSWORD_LABEL_Y, DEFAUL_LABEL_WIDTH, DEFAUL_LABEL_HEIGHT);
		panelLogIn.add(passwordLabel);

		password = new JTextField();
		password.setBounds(PASSWORD_INPUT_X, PASSWORD_INPUT_Y, TEXTLABEL_ANCHURA, DEFAULT_BUTTON_ALTURA);
		panelLogIn.add(password);
		
		botonLogIn = new JButton("LogIn");
		botonLogIn.setBounds(LOGIN_BOTTON_X, LOGIN_BOTTON_Y, DEFAULT_BUTTON_ANCHURA, DEFAULT_BUTTON_ALTURA);
		panelLogIn.add(botonLogIn);

		botonRegister = new JButton("Registrar");
		botonRegister.setBounds(REGISTER_BOTTON_X, REGISTER_BOTTON_Y, DEFAULT_BUTTON_ANCHURA, DEFAULT_BUTTON_ALTURA);
		panelLogIn.add(botonRegister);


	}
}
