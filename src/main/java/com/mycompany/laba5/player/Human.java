package com.mycompany.laba5.player;

import javax.swing.ImageIcon;

/**
 * The Human class represents a human player character in the game.
 * It extends the Player class and includes additional attributes such as points,
 * experience, wins, and next experience threshold.
 */
public class Human extends Player{
    

    private int points;
    private int experience;
    private int win;
    private int nextexperience;


    /**
     * Constructs a new Human character with the specified level, health, damage, and attack.
     *
     * @param level the level of the human character
     * @param health the health of the human character
     * @param damage the damage the human character can inflict
     * @param attack the attack value of the human character
     */
    public Human(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
        this.points=0;
        this.experience=0;
        this.nextexperience=40;
        this.win=0;
        picture = new ImageIcon(this.getClass().getResource("/Player.jpg"));
        
    }

    /**
     * Returns the points of the human character.
     *
     * @return the points of the human character
     */
    public int getPoints(){
        return this.points;
    }
    /**
     * Returns the experience of the human character.
     *
     * @return the experience of the human character
     */
    public int getExperience(){
        return this.experience;
    }
    /**
     * Returns the next experience threshold of the human character.
     *
     * @return the next experience threshold of the human character
     */
    public int getNextExperience(){
        return this.nextexperience;
    }
    /**
     * Returns the number of wins of the human character.
     *
     * @return the number of wins of the human character
     */
    public int getWin(){
        return this.win;
    }
    /**
     * Adds the specified points to the human character's points.
     *
     * @param p the points to add
     */
    public void setPoints(int p){
        this.points+=p;
    }
    /**
     * Adds the specified experience to the human character's experience.
     *
     * @param e the experience to add
     */
    public void setExperience(int e){
        this.experience+=e;
    }
    /**
     * Sets the next experience threshold for the human character.
     *
     * @param e the next experience threshold
     */
    public void setNextExperience(int e){
        this.nextexperience=e;
    }
    /**
     * Increments the win count of the human character by one.
     */
    public void setWin(){
        this.win++;
    }
    /**
     * Returns the name of the human character.
     *
     * @return the name of the human character
     */
    @Override
    public String getName(){
        return "You";
    }

    
}
