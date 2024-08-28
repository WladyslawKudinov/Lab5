package com.mycompany.laba5.enemys;

import com.mycompany.laba5.player.Player;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 * The RedKhmer class represents a specific type of enemy in the game.
 * It extends the Player class and initializes the RedKhmer enemy with
 * predefined attributes such as level, health, damage, and attack.
 * Additionally, it sets a scaled image icon for the RedKhmer enemy.
 */
public class RedKhmer extends Player{
    /**
     * Constructs a new RedKhmer enemy with the specified attributes.
     *
     * @param level the level of the RedKhmer enemy
     * @param health the health points of the RedKhmer enemy
     * @param damage the damage points of the RedKhmer enemy
     * @param attack the attack points of the RedKhmer enemy
     */
    public RedKhmer(int level, int health, int damage , int attack){
        super (level, health, damage, attack);
        ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("/RedKhmer.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH); // Assuming 100x100 is the target size
        this.picture = new ImageIcon(scaledImage);    }
    /**
     * Returns the name of the RedKhmer enemy.
     *
     * @return a string representing the name of the RedKhmer enemy
     */
    @Override
    public String getName(){
        return "Pure Evil";
    }
    /**
     * Indicates whether the RedKhmer enemy is a wizard.
     *
     * @return true if the RedKhmer enemy is a wizard, false otherwise
     */
    @Override
     public Boolean isWizard() {
         return true;
     }
}
