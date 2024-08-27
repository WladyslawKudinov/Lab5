package com.mycompany.laba5.enemys;

import com.mycompany.laba5.player.Player;
import javax.swing.ImageIcon;
import java.awt.*;


public class UncleStone extends Player{
    
    
    public UncleStone(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
        ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("/UncleStone.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH); // Assuming 100x100 is the target size
        this.picture = new ImageIcon(scaledImage);    }
    
    @Override
    public String getName(){
        return "Uncle Stone";
    }
    
   
    
}
