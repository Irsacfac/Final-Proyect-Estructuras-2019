package juego.Observer;

public interface Subject {
    void detach(Observer observer);
    void attach(Observer observer);
    void notifyObservers(Observer observer);
}
