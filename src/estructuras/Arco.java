package estructuras;

public class Arco<T> {
	private int peso;
	private NodoG<T> puntoA;
	private NodoG<T> puntoB;
	
	public Arco (int pPeso, NodoG<T> pPuntoA, NodoG<T> pPuntoB) {
		peso = pPeso;
		puntoA = pPuntoA;
		puntoB = pPuntoB;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public NodoG<T> getPuntoA() {
		return puntoA;
	}
	
	public NodoG<T> getPuntoB() {
		return puntoB;
	}
}
