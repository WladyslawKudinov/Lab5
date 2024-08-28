package com.mycompany.laba5.player;

import javax.swing.ImageIcon;

/**
 * The Player class represents a generic player character in the game.
 * It includes attributes such as level, health, damage, and attack.
 * This class serves as a base class for specific player types like Human.
 */
public class Player {
    
    private int level;
    private int health;
    private int maxhealth;
    private double damage;
    private int attack;
    public ImageIcon picture;
    private boolean weakness = false;
    private int timer = 0;
    /**
     * Constructs a new Player with the specified level, health, damage, and attack.
     *
     * @param level the level of the player
     * @param health the health of the player
     * @param damage the damage the player can inflict
     * @param attack the attack value of the player
     */
    public Player(int level, int health, double damage, int attack){
        this.level=level;
        this.health=health;
        this.damage=damage;
        this.attack=attack;
        this.maxhealth=health;
    }
    /**
     * Increments the level of the player by one.
     */
    public void setLevel(){
        this.level++;
    }
    /**
     * Adjusts the health of the player. If the player has a weakness, the health adjustment is increased by 25%.
     *
     * @param h the amount to adjust the health by
     */
    public void setHealth(double h){
        if (h < 0 && weakness){
            this.health += h * 1.25;
        }
        else {
            this.health+=h;
        }
    }
    /**
     * Sets the health of the player to a new value.
     *
     * @param h the new health value
     */
    public void setNewHealth(int h){
        this.health=h;
    }
    /**
     * Adjusts the damage the player can inflict.
     *
     * @param d the amount to adjust the damage by
     */
    public void setDamage(double d){
        this.damage+=d;
    }
    /**
     * Sets the attack value of the player.
     *
     * @param a the new attack value
     */
    public void setAttack(int a){
        this.attack=a;
    }
    /**
     * Adjusts the maximum health of the player.
     *
     * @param h the amount to adjust the maximum health by
     */
    public void setMaxHealth(int h){
        this.maxhealth+=h;
    }
    /**
     * Returns the level of the player.
     *
     * @return the level of the player
     */
    public int getLevel(){
        return this.level;
    }
    /**
     * Returns the current health of the player.
     *
     * @return the current health of the player
     */
    public int getHealth(){
        return this.health;
    }
    /**
     * Returns the damage the player can inflict. If the player has a weakness, the damage is reduced by 50%.
     *
     * @return the damage the player can inflict
     */
    public double getDamage(){
        if (weakness) {
            return this.damage * 0.5;
        }
        return this.damage;
    }
    /**
     * Returns the attack value of the player.
     *
     * @return the attack value of the player
     */
    public int getAttack(){
        return this.attack;
    }
    /**
     * Returns the maximum health of the player.
     *
     * @return the maximum health of the player
     */
    public int getMaxHealth(){
        return this.maxhealth;
    }
    /**
     * Returns the name of the player. This method is intended to be overridden by subclasses.
     *
     * @return the name of the player
     */
    public String getName(){
        return "";
    }
    /**
     * Returns the picture of the player.
     *
     * @return the picture of the player
     */
     public ImageIcon getPicture() {
        return picture;
    }
    /**
     * Sets the weakness status of the player and initializes the timer for the weakness duration.
     *
     * @param level the duration of the weakness
     */
     public void setWeakness(int level) {
         timer = level;
         weakness = true;
     }
    /**
     * Decrements the weakness timer and removes the weakness status if the timer reaches zero.
     */
     public void removeWeakness() {
         if (timer > 0) timer--;
         else {
             weakness = false;
         }
         
     }
    /**
     * Indicates whether the player is a wizard. This method is intended to be overridden by subclasses of Player class.
     *
     *
     * @return false by default, indicating the player is not a wizard
     */
     public Boolean isWizard() {
         return false;
     }
    
}
