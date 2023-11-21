/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

/**
 * Object Ressource. Il contient toutes les ressources du jeu ainsi que les capacité de stockage de celles-ci
 */
public class Ressources {

    //Natural ressources
    int food, capacity_food;
    int wood, capacity_wood;
    int stone, capacity_stone;
    int coal, capacity_coal;
    int iron, capacity_iron;
    int gold;

    //Construct ressources
    int brique, capacity_brique;
    int lumber, capacity_lumber;
    int tools;

    //Habitants
    int habitant, capacity_habitant;
    int jobless;

    //War Ressources
    int weapons, capacity_weapons;
    int soldier, capacity_soldier;

    int defence;

    /**
     * Constructeur of the Object Ressource
     * @param food number
     * @param capacity_food number max
     * @param wood number
     * @param capacity_wood number max
     * @param stone number
     * @param capacity_stone number max
     * @param coal number
     * @param capacity_coal number max
     * @param iron number
     * @param capacity_iron number max
     * @param gold number
     * @param brique number
     * @param capacity_brique number max
     * @param lumber number
     * @param capacity_lumber number max
     * @param tools number
     * @param habitant number
     * @param capacity_habitant number max
     * @param jobless number
     * @param weapons number
     * @param capacity_weapons number max
     * @param soldier number
     * @param capacity_soldier number max
     * @param defence number
     */
    public Ressources (int food, int capacity_food, int wood, int capacity_wood, int stone, int capacity_stone, int coal,
                       int capacity_coal, int iron, int capacity_iron, int gold, int brique, int capacity_brique,
                       int lumber, int capacity_lumber, int tools, int habitant, int capacity_habitant,int jobless,
                       int weapons, int capacity_weapons, int soldier, int capacity_soldier, int defence){
        this.food=food;
        this.capacity_food=capacity_food;
        this.wood=wood;
        this.capacity_wood=capacity_wood;
        this.stone=stone;
        this.capacity_stone=capacity_stone;
        this.coal=coal;
        this.capacity_coal=capacity_coal;
        this.iron=iron;
        this.capacity_iron=capacity_iron;
        this.gold=gold;

        this.brique=brique;
        this.capacity_brique=capacity_brique;
        this.lumber=lumber;
        this.capacity_lumber=capacity_lumber;
        this.tools=tools;

        this.habitant=habitant;
        this.capacity_habitant=capacity_habitant;
        this.jobless=jobless;

        this.weapons=weapons;
        this.capacity_weapons=capacity_weapons;
        this.soldier=soldier;
        this.capacity_soldier=capacity_soldier;

        this.defence=defence;
    }

    /**
     * Get Food
     * @return actual number of food
     */
    public int getFood() {
        return food;
    }

    /**
     * Set Food
     * @param food num of food set
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Get Capacity of Food
     * @return actual capacity_food
     */
    public int getCapacity_food() {
        return capacity_food;
    }

    /**
     * Set capacity_food
     * @param capacity_food num of food max set
     */
    public void setCapacity_food(int capacity_food) {
        this.capacity_food = capacity_food;
    }

    /**
     * Get Wood
     * @return actual number of wood
     */
    public int getWood() {
        return wood;
    }

    /**
     * Set wood
     * @param wood num of wood set
     */
    public void setWood(int wood) {
        this.wood = wood;
    }

    /**
     * Get Capacity of Wood
     * @return actual capacity_wood
     */
    public int getCapacity_wood() {
        return capacity_wood;
    }

    /**
     * Set capacity_wood
     * @param capacity_wood num of wood max set
     */
    public void setCapacity_wood(int capacity_wood) {
        this.capacity_wood = capacity_wood;
    }

    /**
     * Get Stone
     * @return actual number of stone
     */
    public int getStone() {
        return stone;
    }

    /**
     * Set stone
     * @param stone num of stone set
     */
    public void setStone(int stone) {
        this.stone = stone;
    }

    /**
     * Get Capacity of Stone
     * @return actual capacity_stone
     */
    public int getCapacity_stone() {
        return capacity_stone;
    }

    /**
     * Set capacity_stone
     * @param capacity_stone num of stone max set
     */
    public void setCapacity_stone(int capacity_stone) {
        this.capacity_stone = capacity_stone;
    }

    /**
     * Get Coal
     * @return actual number of coal
     */
    public int getCoal() {
        return coal;
    }

    /**
     * Set coal
     * @param coal num of coal set
     */
    public void setCoal(int coal) {
        this.coal = coal;
    }

    /**
     * Get Capacity of Coal
     * @return actual capacity_coal
     */
    public int getCapacity_coal() {
        return capacity_coal;
    }

    /**
     * Set capacity_coal
     * @param capacity_coal num of coal max set
     */
    public void setCapacity_coal(int capacity_coal) {
        this.capacity_coal = capacity_coal;
    }

    /**
     * Get Iron
     * @return actual number of iron
     */
    public int getIron() {
        return iron;
    }

    /**
     * Set iron
     * @param iron num of iron set
     */
    public void setIron(int iron) {
        this.iron = iron;
    }

    /**
     * Get Capacity of Iron
     * @return actual capacity_iron
     */
    public int getCapacity_iron() {
        return capacity_iron;
    }

    /**
     * Set capacity_iron
     * @param capacity_iron num of iron max set
     */
    public void setCapacity_iron(int capacity_iron) {
        this.capacity_iron = capacity_iron;
    }

    /**
     * Get Gold
     * @return actual number of gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * Set gold
     * @param gold num of gold set
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Get Brique
     * @return actual number of brique
     */
    public int getBrique() {
        return brique;
    }

    /**
     * Set brique
     * @param brique num of brique set
     */
    public void setBrique(int brique) {
        this.brique = brique;
    }

    /**
     * Get Capacity of Brique
     * @return actual capacity_brique
     */
    public int getCapacity_brique() {
        return capacity_brique;
    }

    /**
     * Set capacity_brique
     * @param capacity_brique num of brique max set
     */
    public void setCapacity_brique(int capacity_brique) {
        this.capacity_brique = capacity_brique;
    }

    /**
     * Get Lumber
     * @return actual number of lumber
     */
    public int getLumber() {
        return lumber;
    }

    /**
     * Set lumber
     * @param lumber num of lumber set
     */
    public void setLumber(int lumber) {
        this.lumber = lumber;
    }

    /**
     * Get Capacity of Lumber
     * @return actual capacity_lumber
     */
    public int getCapacity_lumber() {
        return capacity_lumber;
    }

    /**
     * Set capacity_lumber
     * @param capacity_lumber num of lumber max set
     */
    public void setCapacity_lumber(int capacity_lumber) {
        this.capacity_lumber = capacity_lumber;
    }

    /**
     * Get Tools
     * @return actual number of tools
     */
    public int getTools() {
        return tools;
    }

    /**
     * Set tools
     * @param tools num of tools set
     */
    public void setTools(int tools) {
        this.tools = tools;
    }

    /**
     * Get Habitant
     * @return actual number of habitant
     */
    public int getHabitant() {
        return habitant;
    }

    /**
     * Set habitant
     * @param habitant num of habitant set
     */
    public void setHabitant(int habitant) {
        this.habitant = habitant;
    }

    /**
     * Get Capacity of Habitant
     * @return actual capacity_habitant
     */
    public int getCapacity_habitant() {
        return capacity_habitant;
    }

    /**
     * Set capacity_habitant
     * @param capacity_habitant num of habitant max set
     */
    public void setCapacity_habitant(int capacity_habitant) {
        this.capacity_habitant = capacity_habitant;
    }

    /**
     * Get Jobless
     * @return actual number of jobless
     */
    public int getJobless() {
        return jobless;
    }

    /**
     * Set jobless
     * @param jobless num of jobless set
     */
    public void setJobless(int jobless) {
        this.jobless = jobless;
    }

    /**
     * Get Weapons
     * @return actual number of weapon
     */
    public int getWeapons() {
        return weapons;
    }

    /**
     * Set weapons
     * @param weapons num of weapons set
     */
    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    /**
     * Get Capacity of Weapons
     * @return actual capacity_weapon
     */
    public int getCapacity_weapons() {
        return capacity_weapons;
    }

    /**
     * Set capacity_weapons
     * @param capacity_weapons num of weapons max set
     */
    public void setCapacity_weapons(int capacity_weapons) {
        this.capacity_weapons = capacity_weapons;
    }

    /**
     * Get Soldier
     * @return actual number of soldier
     */
    public int getSoldier() {
        return soldier;
    }

    /**
     * Set soldier
     * @param soldier num of soldier set
     */
    public void setSoldier(int soldier) {
        this.soldier = soldier;
    }

    /**
     * Get Capacity of Soldier
     * @return actual capacity_soldier
     */
    public int getCapacity_soldier() {
        return capacity_soldier;
    }

    /**
     * Set capacity_soldier
     * @param capacity_soldier num of soldier max set
     */
    public void setCapacity_soldier(int capacity_soldier) {
        this.capacity_soldier = capacity_soldier;
    }

    /**
     * Get Defence
     * @return actual number of defence
     */
    public int getDefence() {
        return defence;
    }

    /**
     * Set defence
     * @param defence num of defence set
     */
    public void setDefence(int defence) {
        this.defence = defence;
    }
}