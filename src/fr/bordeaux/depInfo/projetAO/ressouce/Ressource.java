package fr.bordeaux.depInfo.projetAO.ressouce;

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
    public void addQuantity(int quantity){
        this.callno ++;
        this.quantity += quantity;
    }

    /**
     * @param quantity to less
     */
    public void lessQuantity(int quantity){
        this.callno ++;
        this.quantity -= quantity;
    }
}
