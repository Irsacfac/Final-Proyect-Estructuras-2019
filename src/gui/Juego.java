package gui;

import java.awt.Frame;

import javax.swing.JFrame;

import otros.IConstants;

public class Juego extends JFrame implements IConstants{
	public Juego() {
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
		
	}
}
