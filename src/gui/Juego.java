package gui;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import MapHandling.Casilla;
import MapHandling.Mapa;
import MapHandling.Obstaculo;
import estructuras.NodoG;
import juego.Jugador;
import juego.Peloton;
import juego.Observer.Observer;
import otros.IConstants;

public class Juego extends JFrame implements IConstants, Observer {

    private JPanel panelJuego;
    private Mapa map;
    private ArrayList<JPanel> obstacles;
    private ArrayList<JPanel> grid;
    private Jugador actualPlayer;
    private Jugador previousPlayer;
    //private Image imageBuffer;


    public Juego(Mapa map) {
        super("Capturar la bandera");
        this.map = map;
        this.setLayout(null);
        this.setSize(PANTALLA_JUEGO_ANCHURA, PANTALLA_JUEGO_ALTURA);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setObstacles();
        this.setCasillas();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponents();

        this.setVisible(true);
        actualPlayer = null;
    }

    private void setObstacles(){
        obstacles = new ArrayList<>();
        ArrayList<Obstaculo> obstacleObjects = map.getObstaculos();
        for (Obstaculo obstaculo : obstacleObjects){
            int width = obstaculo.getWidth();
            int height = obstaculo.getHeight();
            JPanel obstaclePanel = new JPanel();
            obstaclePanel.setBackground(Color.BLACK);
            obstaclePanel.setBounds(obstaculo.getX1(), obstaculo.getY1(), width, height);
            obstacles.add(obstaclePanel);
        }
    }

    private void setCasillas(){
        grid = new ArrayList<>();
        ArrayList<NodoG<Casilla>> nodes = map.getMapa().getNodos();
        for (NodoG<Casilla> nodoG : nodes){
            Casilla gridObject = nodoG.getElemento();
            JPanel gridPanel = new JPanel();
            gridPanel.setBounds(gridObject.getX1(), gridObject.getY1(), ANCHO_CASILLA, ALTURA_CASILLA);
            gridPanel.setBorder(new LineBorder(Color.BLACK));
            grid.add(gridPanel);
        }
    }

    private void initComponents() {
        panelJuego = new JPanel();
        panelJuego.setBounds(0, 0, PANTALLA_JUEGO_ANCHURA, PANTALLA_JUEGO_ALTURA);
        panelJuego.setLayout(null);
        this.getContentPane().add(panelJuego);
        for (JPanel obstaculo : obstacles){
            panelJuego.add(obstaculo);
        }
        for (JPanel grid : grid){
            panelJuego.add(grid);
        }
    }

    /*public void paint(Graphics g) {
    	Peloton peloton;
    	Casilla casillaPeloton;
    	if (imageBuffer == null) {
    		imageBuffer = this.createImage(PANTALLA_JUEGO_ANCHURA, PANTALLA_JUEGO_ALTURA);
    	}
    	if(playerX != null) {
    		g.drawImage(imageBuffer, 0, 0, null);
	    	for(int pelotonActual = 0; pelotonActual < playerX.getPelotones().length; pelotonActual++) {
	    		peloton = playerX.getPelotones()[pelotonActual];
	    		casillaPeloton = peloton.getActualPosition().getElemento();
	    		g.fillRect(casillaPeloton.getX1(), casillaPeloton.getY1(), casillaPeloton.getX2(), casillaPeloton.getY2());
	    	}
    	}
    }*/

    @Override
    public void update(Object object) {
    	previousPlayer = actualPlayer;
    	if(object instanceof Jugador) {
    		actualPlayer = (Jugador) object;
    	}
    	else {
    		return;
    	}
    	for(int pos = 0; pos < actualPlayer.getPelotones().length; pos++) {
    		grid.get(actualPlayer.getPelotones()[pos].getActualPosition().getElemento().getFila()*actualPlayer.getPelotones()[pos].getActualPosition().getElemento().getColumna()).setBackground(Color.BLUE);
    		if(previousPlayer != null) {
    			grid.get(previousPlayer.getPelotones()[pos].getActualPosition().getElemento().getFila()*previousPlayer.getPelotones()[pos].getActualPosition().getElemento().getColumna()).setBackground(Color.WHITE);
    		}
    	}
    	//repaint();
    }
  
}
