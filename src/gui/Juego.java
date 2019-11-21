package gui;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import otros.IConstants;

public class Juego extends JFrame implements IConstants {

	private JPanel panelJuego;
	
	public Juego() {
		super("Capturar la bandera");
		
		this.setLayout(null);
		this.setSize(PANTALLA_JUEGO_ANCHURA, PANTALLA_JUEGO_ALTURA);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(Frame.NORMAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        initComponents();
        
        this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		panelJuego = new JPanel();
		panelJuego.setBounds(0, 0, PANTALLA_JUEGO_ANCHURA, PANTALLA_JUEGO_ALTURA);
		panelJuego.setLayout(null);
		panelJuego.setBackground(Color.BLACK);
		this.getContentPane().add(panelJuego);
		
	}
}
