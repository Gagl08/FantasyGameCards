/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO.exception;

public class RessourceException extends Throwable {
    private final String cause;
    public RessourceException(String plus_assez_de_ressources) {
    this.cause = plus_assez_de_ressources;
    }

    public String getName() {
        return cause;
    }
}
