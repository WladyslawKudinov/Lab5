package com.mycompany.laba5.enemys;

import com.mycompany.laba5.player.Player;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 * The DoctorMew class represents a specific type of enemy in the game.
 * It extends the Player class and initializes the DoctorMew enemy with
 * predefined attributes such as level, health, damage, and attack.
 * Additionally, it sets a scaled image icon for the DoctorMew enemy.
 */
public class DoctorMew extends Player{

    /**
     * Constructs a new DoctorMew enemy with the specified attributes.
     *
     * @param level the level of the DoctorMew enemy
     * @param health the health points of the DoctorMew enemy
     * @param damage the damage points of the DoctorMew enemy
     * @param attack the attack points of the DoctorMew enemy
     */
    public DoctorMew(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
        ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("/DoctorMew.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH); // Assuming 100x100 is the target size
        this.picture = new ImageIcon(scaledImage);
    }
    /**
     * Returns the name of the DoctorMew enemy.
     *
     * @return a string representing the name of the DoctorMew enemy
     */
    @Override
    public String getName(){
        return "Dr Sharp";
    }
}
