package estructuras;

import java.util.UUID;
import java.util.Vector;

public class NodoG <T>{
	private T elemento;
	private boolean visitado;
	private int peso;
	private Vector<NodoG<T>> arcos;
	private UUID id;
	
	public NodoG(T pElemento){
		elemento = pElemento;
		arcos = new Vector<>();
		id = UUID.randomUUID();
	}
	
	public boolean agregarArco(NodoG<T> pNodo) {
		if(!arcos.contains(pNodo)) {
			arcos.add(pNodo);
			if(!pNodo.getArcos().contains(this)) {
				pNodo.getArcos().add(this);
			}
			return true;
		}else {
			return false;
		}
	}
	
	public Vector<NodoG<T>> getArcos(){
		return arcos;
	}
	
	public void setVisitado(boolean pVisitado) {
		visitado = pVisitado;
	}
	
	public boolean isVisitado() {
		return visitado;
	}
	
	public T getElemento() {
		return elemento;
	}
}
