/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

/**
 * Building Class
 */
public class Building {
    // The name of the building.
    final String name;
    int nbHabAllowed;
    int nbWorkerNeeded;
    Ressources resConso;
    Ressources resProd;
    boolean active;
    int timerBuild;

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
     * Retrieves the resources consumed by the building.
     *
     * @return The resources consumed.
     */
    public Ressources getResConso() {
        return resConso;
    }

    /**
     * Sets the resources consumed by the building.
     *
     * @param resConso The new resources consumed.
     */
    public void setResConso(Ressources resConso) {
        this.resConso = resConso;
    }

    /**
     * Retrieves the resources produced by the building.
     *
     * @return The resources produced.
     */
    public Ressources getResProd() {
        return resProd;
    }

    /**
     * Sets the resources produced by the building.
     *
     * @param resProd The new resources produced.
     */
    public void setResProd(Ressources resProd) {
        this.resProd = resProd;
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

////////////////////////////////////////////////////////
/////////////////////CONSTRUCTORS///////////////////////
    public Building(String name, int nbWorkerNeeded, int timerBuild) {
        this.name = name;
        this.nbHabAllowed = 0;
        this.nbWorkerNeeded = nbWorkerNeeded;
        this.active = false;
        this.timerBuild = timerBuild;
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

    /**
     * Produces resources for the given player hand (placeholder method, needs implementation).
     *
     * @param player The player hand for which resources are produced.
     */
    public void produceRessource(PlayerHand player) {
        // Implementation for producing resources
    }

    /**
     * Consumes resources from the given player hand (placeholder method, needs implementation).
     *
     * @param player The player hand from which resources are consumed.
     */
    public void consumeRessource(PlayerHand player) {
        // Implementation for consuming resources
    }
////////////////////////////////////////////////////////
}
