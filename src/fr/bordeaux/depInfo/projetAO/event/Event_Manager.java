package fr.bordeaux.depInfo.projetAO.event;
import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;

import java.util.Random;
public class Event_Manager {
    private Event_Interface event;

    public Event_Manager(){
        newEvent();
    }

    public void newEvent(){
        Random random = new Random();
        int choice = random.nextInt(10);
        switch (choice){
            case (0):
                this.event = new Deflation();
                System.out.println("The economy has never been better ! You got additionnal gold coins :)");
                break;
            case (1):
                this.event = new Inflation();
                System.out.println("The economy has never been worse ! You got less gold coins :(");
                break;
            case (2):
                this.event = new WitchHunt();
                System.out.println("Witches has been found in your village ! Christ compels you to burn those heathens !");
                break;
            default:
                this.event = new WitchHunt();
        }
    }
    public void startEvent(Turn turn, Board board, PlayerHand player){
        if (this.event != null) this.event.startEvent(turn, board, player);
    }
}
