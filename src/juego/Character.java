package juego;

public class Character {
	private int ataque;
	private int tiempoEspera;
	private int energia;
	
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
}
