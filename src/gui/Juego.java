package gui;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
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
    private Jugador playerX;
    //private Jugador player2;


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
        playerX = null;
    }

    private void setObstacles() {
        obstacles = new ArrayList<>();
        ArrayList<Obstaculo> obstacleObjects = map.getObstaculos();
        for (Obstaculo obstaculo : obstacleObjects) {
            int width = obstaculo.getWidth();
            int height = obstaculo.getHeight();
            JPanel obstaclePanel = new JPanel();
            obstaclePanel.setBackground(Color.BLACK);
            obstaclePanel.setBounds(obstaculo.getX1(), obstaculo.getY1(), width, height);
            obstacles.add(obstaclePanel);
        }
    }

    private void setCasillas() {
        grid = new ArrayList<>();
        ArrayList<NodoG<Casilla>> nodes = map.getMapa().getNodos();
        for (NodoG<Casilla> nodoG : nodes) {
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
        for (JPanel obstaculo : obstacles) {
            panelJuego.add(obstaculo);
        }
        for (JPanel grid : grid) {
            panelJuego.add(grid);
        }
    }

//    public void paint(Graphics g) {
//    	Peloton peloton;
//    	Casilla casillaPeloton;
//    	print(g);
//    	if(playerX != null) {
//	    	for(int pelotonActual = 0; pelotonActual < playerX.getPelotones().length; pelotonActual++) {
//	    		peloton = playerX.getPelotones()[pelotonActual];
//	    		casillaPeloton = peloton.getActualPosition().getElemento();
//	    		g.fillRect(casillaPeloton.getX1(), casillaPeloton.getY1(), casillaPeloton.getX2(), casillaPeloton.getY2());
//	    	}
//    	}
//    }

    @Override
    public void update(Object object) {
        if (object instanceof Jugador) {
            playerX = (Jugador) object;
            Peloton peloton;
            Casilla casillaPeloton;
            for (int pelotonActual = 0; pelotonActual < playerX.getPelotones().length; pelotonActual++) {
                peloton = playerX.getPelotones()[pelotonActual];
                casillaPeloton = peloton.getActualPosition().getElemento();
                JPanel aActualizar = getCasilla(casillaPeloton.getX1(), casillaPeloton.getY1());
                aActualizar.setBackground(Color.red);

            }
        }
    }

    private JPanel getCasilla(int x1, int y1){
        for (JPanel panel : grid){
            panel.setBackground(Color.WHITE);
            if (panel.getAlignmentX() == x1 && panel.getAlignmentY() == y1) return panel;
        }
        return null;
    }
}
