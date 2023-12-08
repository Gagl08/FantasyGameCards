/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import java.util.ArrayList;

/**
 * Building Class
 * Building compose a Card
 */
public class Building implements Building_Interface {
    // The name of the building.
    private String name;
    private int nbHabAllowed;
    private int nbWorkerNeeded;
    private int nbWorkerActual;
    private StockageRessource resConstruct;
    private StockageRessource resConso;
    private StockageRessource resProd;
    private StockageCapacity capacity;
    private boolean active;
    private int timerBuild;

    private ArrayList<Habitant_Inteface> observers = new ArrayList<>();

////////////////////////////////////////////////////////
/////////////////////CONSTRUCTORS///////////////////////
    public Building(String name) {
        this.name = name;
        this.nbHabAllowed = 0;
        this.nbWorkerNeeded = 0;
        this.nbWorkerActual = 0;
        this.active = false;
        this.timerBuild = 0;
        this.resConstruct = new StockageRessource();
        this.resConso = new StockageRessource();
        this.resProd = new StockageRessource();
        this.capacity = new StockageCapacity();

        this.observers = new ArrayList<>();
    }

////////////////////////////////////////////////////////
/////////////////////METHODS////////////////////////////
    /**
     * Checks if the building is functional, i.e if the player activated the card
     * and if the building has enough workers to run it.
     * @return True if the building is functional, false otherwise.
     */
    public boolean isFunctional() {
        return this.active && this.nbWorkerNeeded == 0;
    }

//////////////////GETTERS and SETTERS///////////////////
    /**
     * Retrieves the name of the building.
     *
     * @return The name of the building.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the number of inhabitants needed for the building.
     *
     * @return The number of inhabitants needed.
     */
    public int getNbHabAllowed() {
        return nbHabAllowed;
    }

    /**
     * Sets the number of inhabitants needed for the building.
     *
     * @param nbHabAllowed The new number of inhabitants needed.
     */
    public void setNbHabAllowed(int nbHabAllowed) {
        this.nbHabAllowed = nbHabAllowed;
    }

    /**
     * Retrieves the number of workers needed for the building.
     *
     * @return The number of workers needed.
     */
    public int getNbWorkerNeeded() {
        return nbWorkerNeeded;
    }

    /**
     * Sets the number of workers needed for the building.
     *
     * @param nbWorkerNeeded The new number of workers needed.
     */
    public void setNbWorkerNeeded(int nbWorkerNeeded) {
        this.nbWorkerNeeded = nbWorkerNeeded;
    }

    /**
     * Retrieves the number of workers needed for the building.
     *
     * @return The number of workers needed.
     */
    public int getNbWorkerActual() {
        return nbWorkerActual;
    }

    /**
     * Sets the number of workers Actual for the building.
     *
     * @param nbWorkerActual The new number of workers Actual.
     */
    public void setNbWorkerActual(int nbWorkerActual) {
        this.nbWorkerActual = nbWorkerActual;
    }
    /**
     * Retrieves the capacity of the construction
     *
     * @return the capacity of the construction
     */
    public StockageCapacity getCapacity() {
        return capacity;
    }

    /**
     * Retrieves the ressource consume at the construction
     *
     * @return The ressource use for the construction
     */
    public StockageRessource getResConstruct() {
        return resConstruct;
    }

    /**
     * Retrieves the resources consumed by the building.
     *
     * @return The resources consumed.
     */
    public StockageRessource getResConso() {
        return resConso;
    }

    /**
     * Retrieves the resources produced by the building.
     *
     * @return The resources produced.
     */
    public StockageRessource getResProd() {
        return resProd;
    }

    /**
     * Checks if the building is currently active and has no workers needed.
     *
     * @return True if the building is functional, false otherwise.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the activation status of the building.
     *
     * @param active The new activation status.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Retrieves the time required to build the building.
     *
     * @return The time required for building.
     */
    public int getTimerBuild() {
        return timerBuild;
    }

    /**
     * Sets the time required to build the building.
     *
     * @param timerBuild The new time required for building.
     */
    public void setTimerBuild(int timerBuild) {
        this.timerBuild = timerBuild;
    }

    @Override
    public void addObserver(Habitant_Inteface observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Habitant_Inteface observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Habitant_Inteface observer : observers) {
            observer.update(this);
        }
    }

    public ArrayList<Habitant_Inteface> getObservers() {
        return observers;
    }
}
