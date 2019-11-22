package juego;

import juego.Observer.Observer;
import juego.Observer.Subject;

import java.util.ArrayList;

public class Character implements Subject {
	private int ataque;
	private int tiempoEspera;
	private int energia;
	private ArrayList<Observer> observers;
	
	public Character() {
		energia = 100;
	}
	
	public int getAtaque() {
		return ataque;
	}
	protected void setAtaque(int pAtaque) {
		ataque = pAtaque;
	}
	protected void setTiempoEstera(int pTiemEsp) {
		tiempoEspera = pTiemEsp;
	}
	public int getTiempoEspera() {
		return tiempoEspera;
	}
	public void setEnergia(int pEnergia) {
		energia -= pEnergia;
	}
	public int getEnergia() {
		return energia;
	}

	public void attack(Character target){
		target.setEnergia(ataque);
	}


	@Override
	public void detach(Observer observer) {

	}

	@Override
	public void attach(Observer observer) {

	}

	@Override
	public void notifyObservers(Observer observer) {

	}
}
