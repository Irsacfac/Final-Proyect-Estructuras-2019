package gui;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import otros.IConstants;

public class Menu extends JFrame implements IConstants{
	private JPanel buttonPanel;
	private JButton botonNuevoJuego;
	private JButton botonPuntages;
	
	public Menu() {
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
		// TODO Auto-generated method stub
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 0, PANTALLA_ANCHURA, PANTALLA_ALTURA);
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(Color.CYAN);
		this.getContentPane().add(buttonPanel);
		
		botonNuevoJuego = new JButton("Nuevo Juego");
		botonNuevoJuego.setBounds(PANTALLA_ANCHURA/3, (PANTALLA_ALTURA/3), DEFAULT_BUTTON_ANCHURA, DEFAULT_BUTTON_ALTURA);
		buttonPanel.add(botonNuevoJuego);
		
		botonPuntages = new JButton("Puntajes");
		botonPuntages.setBounds(PANTALLA_ANCHURA/3, PANTALLA_ALTURA/3+DEFAULT_BUTTON_ALTURA+5, DEFAULT_BUTTON_ANCHURA, DEFAULT_BUTTON_ALTURA);
		buttonPanel.add(botonPuntages);
	}
}
