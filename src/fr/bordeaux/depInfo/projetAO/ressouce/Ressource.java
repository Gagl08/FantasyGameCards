package fr.bordeaux.depInfo.projetAO.ressouce;

import fr.bordeaux.depInfo.projetAO.StockageCapacity;

public class Ressource {
    int quantity;
    String name;
    int callno; //DEBUG : permet de savoir combien de fois on a appelé la classe Ressource

    public Ressource(int quantity){
        this.callno = 0;
        this.quantity = quantity;
        this.name="";
    }

    /**
     * @return actual number of food
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param quantity num of food set
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
        System.out.println("quantity of ressource " + this.getName() + " as called in setQuantity : " +this.quantity);
    }

    /**
     * @param quantity to add
     */
    public void addQuantity(StockageCapacity capacity, String name, int quantity){
        int new_quantity = this.quantity + quantity;
        if (new_quantity <= capacity.getList_capacity().get(name).getQuantity()) {
            this.quantity += quantity;
        }
        else {
            this.quantity = capacity.getList_capacity().get(name).getQuantity();
            System.out.println("Too much " + name + " in stock, you cannot get more !");
        }
    }

    /**
     * @param quantity to less
     */
    public void lessQuantity(int quantity){
        this.callno ++;
        this.quantity -= quantity;
    }
}
