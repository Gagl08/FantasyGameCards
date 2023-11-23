package fr.bordeaux.depInfo.projetAO.ressouce;

public class Ressource {
    int quantity;

    public Ressource(int quantity){
        this.quantity=quantity;
    }

    /**
     * @return actual number of food
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity num of food set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @param quantity to add
     */
    public void addQuantity(int quantity){this.quantity=this.quantity+quantity;}

    /**
     * @param quantity to less
     */
    public void lessQuantity(int quantity){this.quantity=this.quantity-quantity;}
}