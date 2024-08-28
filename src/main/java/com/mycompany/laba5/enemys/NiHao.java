package com.mycompany.laba5.enemys;

import com.mycompany.laba5.player.Player;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 * The NiHao class represents a specific type of enemy in the game.
 * It extends the Player class and initializes the NiHao enemy with
 * predefined attributes such as level, health, damage, and attack.
 * Additionally, it sets a scaled image icon for the NiHao enemy.
 */
public class NiHao extends Player{
    /**
     * Constructs a new NiHao enemy with the specified attributes.
     *
     * @param level the level of the NiHao enemy
     * @param health the health points of the NiHao enemy
     * @param damage the damage points of the NiHao enemy
     * @param attack the attack points of the NiHao enemy
     */
    public NiHao(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
        ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("/NiHao.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH); // Assuming 100x100 is the target size
        this.picture = new ImageIcon(scaledImage);
    }
    /**
     * Returns the name of the NiHao enemy.
     *
     * @return a string representing the name of the NiHao enemy
     */
    @Override
    public String getName(){
        return "Ni \"The New Course\" Hao";
    }
}
