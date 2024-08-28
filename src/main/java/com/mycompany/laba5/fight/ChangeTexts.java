
package com.mycompany.laba5.fight;

import com.mycompany.laba5.player.Human;
import com.mycompany.laba5.player.Items;
import com.mycompany.laba5.player.Player;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

/**
 * The \`ChangeTexts\` class is responsible for updating various UI components
 * during different stages of a game round. It updates labels, progress bars,
 * and radio buttons to reflect the current state of the game.
 */
public class ChangeTexts {


    /**
     * Updates the UI components for a new round.
     *
     * @param human the player character
     * @param enemy the enemy character
     * @param pr1 the progress bar for the player
     * @param pr2 the progress bar for the enemy
     * @param label the label for the player's points
     * @param label2 the label for the player's experience
     * @param label3 the label for the player's level
     * @param label4 the label for the enemy's level
     * @param label5 the label for the player's health
     * @param label6 the label for the enemy's health
     * @param label7 the label for the player's damage
     * @param label8 the label indicating whose turn it is
     * @param label9 an additional label for custom messages
     * @param i the current round number
     * @param items the array of items available to the player
     * @param rb1 the first radio button for item selection
     * @param rb2 the second radio button for item selection
     * @param rb3 the third radio button for item selection
     */
    public void NewRoundTexts(Player human, Player enemy, JProgressBar pr1,
            JProgressBar pr2, JLabel label, JLabel label2, JLabel label3,
            JLabel label4, JLabel label5, JLabel label6, JLabel label7, JLabel label8, JLabel label9,
            int i, Items[] items, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3) {
        label.setText(Integer.toString(((Human) human).getPoints()));
        label2.setText(Integer.toString(((Human) human).getExperience()) + "/" + ((Human) human).getNextExperience());
        label3.setText(Integer.toString(human.getLevel()) + " level");
        label4.setText(Integer.toString(enemy.getLevel()) + " level");
        label5.setText(Integer.toString(human.getMaxHealth()) + "/" + Integer.toString(human.getMaxHealth()));
        label6.setText(Integer.toString(enemy.getMaxHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
        label7.setText(Double.toString(human.getDamage()));
        if (i % 2 == 1) {
            label8.setText("Your turn");
        }
        else{
            label8.setText(enemy.getName()+"'s turn");
        }
        /*rb1.setText(items[0].getName()+", "+items[0].getCount()+" шт");
        rb2.setText(items[1].getName()+", "+items[1].getCount()+" шт");
        rb3.setText(items[2].getName()+", "+items[2].getCount()+" шт");*/
        BagText(items, rb1, rb2, rb3);
        label9.setText("");
    }
    /**
     * Updates the UI components during a round.
     *
     * @param human the player character
     * @param enemy the enemy character
     * @param label the label for the enemy's health
     * @param label2 the label for the player's health
     * @param i the current round number
     * @param label3 the label indicating whose turn it is
     */
    public void RoundTexts(Player human, Player enemy, JLabel label, JLabel label2, int i, JLabel label3) {
        if (enemy.getHealth() >= 0) {
            label.setText(Integer.toString(enemy.getHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
        } else {
            label.setText("0/" + Integer.toString(enemy.getMaxHealth()));
        }
        if (human.getHealth() >= 0) {
            label2.setText(Integer.toString(human.getHealth()) + "/" + Integer.toString(human.getMaxHealth()));
        } else {
            label2.setText("0/" + Integer.toString(human.getMaxHealth()));
        }
        if (i % 2 == 1) {
            label3.setText("Your turn");
        }
        else{
            label3.setText(enemy.getName()+"'s turn");
        }
    }
    /**
     * Updates the UI component to display the end game message.
     *
     * @param human the player character
     * @param label the label for the end game message
     */
    public void EndGameText(Human human, JLabel label){
        if(human.getWin()==12){
            label.setText("Победа на вашей стороне");
        }
        else {
            label.setText("Победа не на вашей стороне");
        }
    }
    /**
     * Updates the radio buttons to display the items available to the player.
     *
     * @param items the array of items available to the player
     * @param rb1 the first radio button for item selection
     * @param rb2 the second radio button for item selection
     * @param rb3 the third radio button for item selection
     */
    public void BagText( Items[] items, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3){
        rb1.setText(items[0].getName()+", "+items[0].getCount()+" шт");
        rb2.setText(items[1].getName()+", "+items[1].getCount()+" шт");
        rb3.setText(items[2].getName()+", "+items[2].getCount()+" шт");
    }

}
