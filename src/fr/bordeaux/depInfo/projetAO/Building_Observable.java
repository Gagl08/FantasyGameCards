package fr.bordeaux.depInfo.projetAO;

public interface Building_Observable {
    void addObserver(Habitant_Inteface_Building_Observer observer);
    void removeObserver(Habitant_Inteface_Building_Observer observer);
    void notifyObservers();
}