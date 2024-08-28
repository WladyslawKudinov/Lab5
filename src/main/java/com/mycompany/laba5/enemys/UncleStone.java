package com.mycompany.laba5.enemys;

import com.mycompany.laba5.player.Player;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 * The UncleStone class represents a specific type of enemy in the game.
 * It extends the Player class and initializes the UncleStone enemy with
 * predefined attributes such as level, health, damage, and attack.
 * Additionally, it sets a scaled image icon for the UncleStone enemy.
 */
public class UncleStone extends Player{


    /**
     * Constructs a new UncleStone enemy with the specified attributes.
     *
     * @param level the level of the UncleStone enemy
     * @param health the health points of the UncleStone enemy
     * @param damage the damage points of the UncleStone enemy
     * @param attack the attack points of the UncleStone enemy
     */
    public UncleStone(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
        ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("/UncleStone.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH); // Assuming 100x100 is the target size
        this.picture = new ImageIcon(scaledImage);    }
    /**
     * Returns the name of the UncleStone enemy.
     *
     * @return a string representing the name of the UncleStone enemy
     */
    @Override
    public String getName(){
        return "Uncle Stone";
    }
    
   
    
}
