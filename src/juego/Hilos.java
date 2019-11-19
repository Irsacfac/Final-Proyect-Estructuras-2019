package juego;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Hilos {
	private ExecutorService executor;
	
	public Hilos(int cantHilos) {
		executor = Executors.newFixedThreadPool(cantHilos);
	}
	
	public void ejecutar(Runnable comando) {
		executor.execute(comando);	}
}
