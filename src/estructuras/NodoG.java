package estructuras;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Vector;

public class NodoG <T>{
	private T elemento;
	private boolean visitado;
	private int peso;
	private ArrayList<NodoG<T>> arcos;
	private UUID id;
	
	public NodoG(T pElemento){
		elemento = pElemento;
		arcos = new ArrayList<>();
		id = UUID.randomUUID();
	}
	
	public boolean agregarArco(NodoG<T> pNodo) {
		try{
			arcos.add(pNodo);
			return true;
		} catch (Exception ex){
			return false;
		}


	}
	
	public ArrayList<NodoG<T>> getArcos(){
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
	
	public String getId() {
		return id.toString();
	}
}
