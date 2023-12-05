package fr.bordeaux.depInfo.projetAO.event;
import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;

import java.util.Random;
public class Event_Manager {
    private Event_Interface event;
    public Event_Interface getEvent(){ return event; }
    public Event_Manager(){
        newEvent();
    }

    public void newEvent(){
        Random random = new Random();
        int choice = random.nextInt(10);
        switch (choice){
            case (0):
                this.event = new Deflation();
                System.out.println("The economy has never been better ! You get additionnal gold coins in the next turn :)");
                break;
            case (1):
                this.event = new Inflation();
                System.out.println("The economy has never been worse ! You get less gold coins in the next turn :(");
                break;
            case (2):
                this.event = new WitchHunt();
                System.out.println("Witches has been found in your village ! Christ compels you to burn those heathens in the next turn!");
                break;
            default:
                System.out.println("The village is peaceful for the next turn...");
                this.event = null;
        }
    }
    public void startEvent(Turn turn, Board board, PlayerHand player){
        System.out.println("Randomly choosing event ");
        if (this.event != null) this.event.startEvent(turn, board, player);
        newEvent();
    }
}
