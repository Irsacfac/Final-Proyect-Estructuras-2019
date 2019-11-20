package juego;

import MapHandling.Casilla;
import estructuras.GrafoND;
import estructuras.NodoG;
import otros.IConstants;

public class Jugador implements IConstants {

	private String nombre;
	private Jugador enemy;
	private Peloton grupo1;
	private Peloton grupo2;
	private Peloton grupo3;
	private GrafoND<Casilla> map; 
	public NodoG<Casilla> flag;
	public enum PlayerIdentifier{
		A, B
	}

	
	public Jugador(String pNombre, GrafoND<Casilla> map, PosiblePoints pFlagLocation,PlayerIdentifier pAorB) {

		nombre = pNombre;
		grupo1 = new Peloton(PosiblePoints.CENTER, Peloton.posibleAlgorithms.DIJKSTRA, map);
		grupo2 = new Peloton(PosiblePoints.TOPCORNER, Peloton.posibleAlgorithms.WARSHALL, map);
		grupo3 = new Peloton(PosiblePoints.LOWCORNER, Peloton.posibleAlgorithms.MST, map);
		this.map = map;
		setFlag(pAorB, pFlagLocation);

	}

	private void setFlag(PlayerIdentifier pAorB, PosiblePoints pFlagLocation) {
		int flagColumn = Integer.MAX_VALUE;
		int flagRow = Integer.MAX_VALUE;
		switch (pAorB){
			case A:
				flagColumn = 0;
				break;
			case B:
				flagColumn = 1;
				break;
		}
		switch (pFlagLocation){
			case TOPCORNER:
				flagRow = 0;
			case LOWCORNER:
				flagRow = ULTIMA_FILA;
			case CENTER:
				flagRow = FILA_CENTRAL;
		}
		setFlagNode(flagRow, flagColumn);
	}

	public void setGoals(PosiblePoints pGroup1Goal, PosiblePoints pGroup2Goal, PosiblePoints pGroup3Goal){

		grupo1.setGoalPoint(pGroup1Goal);
		grupo2.setGoalPoint(pGroup2Goal);
		grupo3.setGoalPoint(pGroup3Goal);

	}

	public boolean won(){
		return grupo1.getActualPosition().getElemento().isFlagLocation() ||
				grupo2.getActualPosition().getElemento().isFlagLocation() ||
				grupo3.getActualPosition().getElemento().isFlagLocation();
	}

	private void setFlagNode(int pRow, int pColumn){
		for (NodoG<Casilla> node : map.getNodos()){
			if (node.getElemento().getFila() == pRow)
				if (node.getElemento().getColumna() == pColumn) node.getElemento().setFlagLocation(true);
		}
	}

	public Jugador getEnemy() {
		return enemy;
	}

	public void setEnemy(Jugador enemy) {
		this.enemy = enemy;
	}

	public Peloton getGrupo1() {
		return grupo1;
	}

	public Peloton getGrupo2() {
		return grupo2;
	}

	public Peloton getGrupo3() {
		return grupo3;
	}
}
