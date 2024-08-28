package com.mycompany.laba5;


/**
 * The Result class represents the result of a player in the game.
 * It contains the player's name and points.
 */
public class Result {
    
    private String name;
    private int points;
    /**
     * Constructs a new Result with the specified name and points.
     *
     * @param n the name of the player
     * @param p the points of the player
     */
    public Result(String n, int p){
        this.name=n;
        this.points=p;
    }
    /**
     * Sets the name of the player.
     *
     * @param s the new name of the player
     */
    public void setName(String s){
        this.name=s;
    }
    /**
     * Sets the points of the player.
     *
     * @param p the new points of the player
     */
    public void setPoints(int p){
        this.points=p;
    }
    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName(){
        return this.name;
    }
    /**
     * Returns the points of the player.
     *
     * @return the points of the player
     */
    public int getPoints(){
        return this.points;
    }
    
}
