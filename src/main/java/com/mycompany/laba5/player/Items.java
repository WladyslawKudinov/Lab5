package com.mycompany.laba5.player;

/**
 * The Items class represents an item with a name and a count.
 * It provides methods to set and get the name and count of the item.
 */
public class Items {

    private String name;
    private int count;
    /**
     * Constructs a new Items object with the specified name and count.
     *
     * @param n the name of the item
     * @param c amount of the item
     */
    public Items(String n, int c){
        this.name=n;
        this.count=c;
    }
    /**
     * Sets the name of the item.
     *
     * @param s the new name of the item
     */
    public void setName(String s){
        this.name=s;
    }
    /**
     * Adds the specified count to the current count of the item.
     *
     * @param c amount to add
     */
    public void setCount(int c){
        this.count+=c;
    }
    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName(){
        return this.name;
    }
    /**
     * Returns the count of the item.
     *
     * @return amount of the item
     */
    public int getCount(){
        return this.count;
    }
}
