package fr.bordeaux.depInfo.projetAO;

import java.util.Random;

public class Event {


    // EVENT METHODS
    public void startEvent(PlayerHand player){
        Random rand = new Random();
        int event = rand.nextInt(5);
        switch (event){
            case 0:
                witchHunt();
                break;
            case 1:
                inflation();
                break;
            case 2:
                economicProsperity();
                break;
            case 3:
                storm();
                break;
            case 4:
                revolution();
                break;
        }
    }
    void witchHunt(){}
    void inflation(){}
    void economicProsperity(){}
    void storm(){}
    void revolution(){}
    // EVENT METHODS
}
