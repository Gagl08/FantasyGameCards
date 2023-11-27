package fr.bordeaux.depInfo.projetAO.capacity;

public class Capacity {
    int quantity;
    String name;
    public Capacity(int quantity){
        this.quantity=quantity;
        this.name="";
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
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
