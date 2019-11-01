package npc;

public class Character {
	private int ataque;
	private int tiempoEspera;
	private int energia;
	
	public Character(int pAtaque, int pTiempEsp, int pEnergia) {
		ataque = pAtaque;
		tiempoEspera = pTiempEsp;
		energia = pEnergia;
	}
	
	public int getAtaque() {
		return ataque;
	}
	public int getTiempoEspera() {
		return tiempoEspera;
	}
	
	public int getEnergia() {
		return energia;
	}
}
