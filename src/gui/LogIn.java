package gui;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.paint.Color;
import otros.IConstants;

public class LogIn extends JFrame implements IConstants{
	private JTextField textbar;
	private JButton botonLogIn;
	private JPanel panelLogIn;
	
	public LogIn() {
		super("Capturar la bandera");
		
		this.setLayout(null);
		this.setSize(PANTALLA_ANCHURA, PANTALLA_ALTURA);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(Frame.NORMAL);
        
        initComponents();
        
        this.setVisible(true);
	}
	
	private void initComponents() {
		panelLogIn = new JPanel();
		panelLogIn.setBounds(0, 0, PANTALLA_ANCHURA, PANTALLA_ALTURA/2);
		panelLogIn.setLayout(null);
		//panelLogIn.setBackground(Color.AQUAMARINE);
		this.getContentPane().add(panelLogIn);
		
		textbar = new JTextField();
		textbar.setBounds(X_TEXTLABEL, (int)PANTALLA_ALTURA/4, TEXTLABEL_ANCHURA, DEFAULT_BUTTON_ALTURA);
		panelLogIn.add(textbar);
		
		botonLogIn = new JButton("Log In");
		botonLogIn.setBounds(PANTALLA_ANCHURA/3, (PANTALLA_ALTURA/3), DEFAULT_BUTTON_ANCHURA, DEFAULT_BUTTON_ALTURA);
		panelLogIn.add(botonLogIn);
	}
}
