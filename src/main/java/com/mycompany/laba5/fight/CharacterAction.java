package com.mycompany.laba5.fight;

import com.mycompany.laba5.enemy_fabrics.EnemyFabric;
import com.mycompany.laba5.player.Player;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import com.mycompany.laba5.enemys.*;
import com.mycompany.laba5.player.Human;
import com.mycompany.laba5.player.Items;


/**
 * The `CharacterAction` class contains methods for managing character actions
 * such as adding points, leveling up, updating health, and using items.
 */
public class CharacterAction {

    private  int experience_for_next_level = 40;
    

    private final int kind_fight[][] = {{1, 0}, {1, 1, 0}, {0, 1, 0}, {1, 1, 1, 1}};

    private Player enemyes[] = new Player[6];

    EnemyFabric fabric = new EnemyFabric();

    private Player enemyy = null;
    /**
     * Initializes the array of enemy characters.
     */
    public void setEnemyes() {
        enemyes[0] = fabric.create(0, 0);
        enemyes[1] = fabric.create(1, 0);
        enemyes[2] = fabric.create(2, 0);
        enemyes[3] = fabric.create(3, 0);
        enemyes[4] = fabric.create(4, 0);
        enemyes[5] = fabric.create(4, 0);
    }
    /**
     * Returns the array of enemy characters.
     *
     * @return the array of enemy characters
     */
    public Player[] getEnemyes() {
        return this.enemyes;
    }
    /**
     * Chooses a random enemy and updates the UI components with the enemy's information.
     *
     * @param label the label to display the enemy's picture
     * @param label2 the label to display the enemy's name
     * @param text the label to display the enemy's damage
     * @param label3 the label to display the enemy's health
     * @return the chosen enemy character
     */
    public Player ChooseEnemy(JLabel label, JLabel label2, JLabel text, JLabel label3) {
        int i = (int) (Math.random() * 4);
        ImageIcon icon1 = null;
        switch (i) {
            case 0:
                enemyy = enemyes[0];
                break;
            case 1:
                enemyy = enemyes[1];
                break;
            case 2:
                enemyy = enemyes[2];
                break;
            case 3:
                enemyy = enemyes[3];

                break;
        }
        label.setIcon(enemyy.getPicture());
        label2.setText(enemyy.getName());
        text.setText(String.valueOf(enemyy.getDamage()));
        label3.setText(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }
    /**
     * Chooses a boss enemy and updates the UI components with the boss's information.
     *
     * @param label the label to display the boss's picture
     * @param label2 the label to display the boss's name
     * @param text the label to display the boss's damage
     * @param label3 the label to display the boss's health
     * @param i the index of the boss in the array of enemies
     * @param human the player character
     * @return the chosen boss character
     */
    public Player ChooseBoss(JLabel label, JLabel label2, JLabel text, JLabel label3, int i, Player human) {

        label2.setText("Heil (босс)");
        enemyy = enemyes[4];
        for(int j=0; j<human.getLevel() - enemyy.getLevel() + 2; i++) {
            enemyy.setLevel();
        }
        enemyy.setDamage( enemyy.getLevel());
        enemyy.setMaxHealth(5 * enemyy.getLevel());
        enemyy.setHealth(enemyy.getMaxHealth() - enemyy.getHealth());
        System.out.println("health: " + enemyy.getHealth());
        label.setIcon(enemyy.getPicture());
        text.setText(String.valueOf(enemyy.getDamage()));
        label3.setText(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }
    /**
     * Determines the enemy's behavior based on random chance and probability factors.
     *
     * @param k1 the probability factor for the first behavior
     * @param k2 the probability factor for the second behavior
     * @param k3 the probability factor for the third behavior
     * @param k4 the probability factor for the fourth behavior
     * @param i the random chance value
     * @param isWizard whether the enemy is a wizard
     * @return an array representing the chosen behavior
     */
    public int[] EnemyBehavior(int k1, int k2, int k3, int k4, double i, Boolean isWizard) {
        int arr[] = null;
        if (i < k1 * 0.01) {
            arr = kind_fight[0];
        }
        if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            arr = kind_fight[1];
        }
        if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            arr = kind_fight[2];
        }
        if (i >= (k1 + k2 + k3) * 0.01 & i < 1) {
            arr = kind_fight[3];
        }
        return arr;
    }
    /**
     * Chooses the enemy's behavior based on the type of enemy and random chance.
     *
     * @param enemy the enemy character
     * @param action the CharacterAction instance
     * @return an array representing the chosen behavior
     */
    public int[] ChooseBehavior(Player enemy, CharacterAction action) {
        int arr[] = null;
        double i = Math.random();
        if (enemy instanceof UncleStone) {
            arr = action.EnemyBehavior(15, 15, 60, 10, i, false);
        }
        if (enemy instanceof RedKhmer) {
            arr = action.EnemyBehavior(25, 25, 0, 50, i, true);
        }
        if (enemy instanceof DoctorMew) {
            arr = action.EnemyBehavior(13, 13, 10, 64, i, false);
        }
        if (enemy instanceof NiHao) {
            arr = action.EnemyBehavior(25, 25, 50, 0, i, false);
        }
        if (enemy instanceof BuffedHeil) {
            arr = action.EnemyBehavior(10, 45, 0, 45, i, false);
        }
        return arr;
    }
    /**
     * Updates the health progress bar for the player character.
     *
     * @param player the player character
     * @param progress the progress bar to update
     */
    public void HP(Player player, JProgressBar progress) {

        if (player.getHealth() >= 0) {
            progress.setValue(player.getHealth());
        } else {
            progress.setValue(0);
        }
    }
    /**
     * Uses the player's weakness (currently not implemented).
     */
    public void useWeakness() {
        
    }
    /**
     * Adds points to the human character based on their current health.
     *
     * @param human the human character
     * @param enemyes the array of enemy characters
     * @return true if the human character levels up, false otherwise
     */
    public Boolean AddPoints(Human human, Player[] enemyes) {
        switch (human.getLevel()) {
            case 0:
                human.setExperience(20);
                human.setPoints(25 + human.getHealth() / 4);
                break;
            case 1:
                human.setExperience(25);
                human.setPoints(30 + human.getHealth() / 4);
                break;
            case 2:
                human.setExperience(30);
                human.setPoints(35 + human.getHealth() / 4);
                break;
            case 3:
                human.setExperience(40);
                human.setPoints(45 + human.getHealth() / 4);
                break;
            case 4:
                human.setExperience(50);
                human.setPoints(55 + human.getHealth() / 4);
                break;
        }
        Boolean isLevelUp = false;
            System.out.println(experience_for_next_level + " и " +  human.getExperience());
            
            if (experience_for_next_level <= human.getExperience()) {   
                
                human.setLevel();
                isLevelUp = true;
                experience_for_next_level += human.getExperience();
                human.setNextExperience(experience_for_next_level);
                NewHealthHuman(human);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], human);
                }
                
            }
        
        return isLevelUp;
    }
    /**
     * Adds points to the human character when fighting a boss.
     *
     * @param human the human character
     * @param enemyes the array of enemy characters
     */
    public void AddPointsBoss(Human human, Player[] enemyes) {
        switch (human.getLevel()) {
            case 2:
                human.setExperience(30);
                human.setPoints(45 + human.getHealth() / 2);
                break;
            case 4:
                human.setExperience(50);
                human.setPoints(65 + human.getHealth() / 2);
                break;
        }
            if (experience_for_next_level <= human.getExperience()) {
                human.setLevel();
                
                experience_for_next_level += human.getExperience();
                human.setNextExperience(experience_for_next_level);
                NewHealthHuman(human);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], human);
                }
            }
        
    }
    /**
     * Adds items to the player's inventory based on random chance.
     *
     * @param k1 the probability factor for the first item
     * @param k2 the probability factor for the second item
     * @param k3 the probability factor for the third item
     * @param items the array of items available to the player
     */
    public void AddItems(int k1, int k2, int k3, Items[] items) {
        double i = Math.random();
        if (i < k1 * 0.01) {
            items[0].setCount(1);
        }
        if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            items[1].setCount(1);
        }
        if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            items[2].setCount(1);
        }
    }
    /**
     * Updates the health and damage of the human character based on their level.
     *
     * @param human the human character
     */
    public void NewHealthHuman(Human human) {
        int hp = 0;
        int damage = 0;
        switch (human.getLevel()) {
            case 1:
                hp = 25;
                damage = 3;
                break;
            case 2:
                hp = 30;
                damage = 3;
                break;
            case 3:
                hp = 30;
                damage = 4;
                break;
            case 4:
                hp = 40;
                damage = 6;
                break;
        }
        human.setMaxHealth((int) human.getHealth() * 4 * hp / 100);
        human.setDamage((int) human.getDamage() * damage / 100);
        human.setLevel();
    }
    /**
     * Updates the health and damage of the enemy character based on the human character's level.
     *
     * @param enemy the enemy character
     * @param human the human character
     */
    public void NewHealthEnemy(Player enemy, Human human) {
        int hp = 0;
        int damage = 0;
        switch (human.getLevel()) {
            case 1:
                hp = 32;
                damage = 25;
                break;
            case 2:
                hp = 30;
                damage = 20;
                break;
            case 3:
                hp = 23;
                damage = 24;
                break;
            case 4:
                hp = 25;
                damage = 26;
                break;
        }
        enemy.setMaxHealth((int) enemy.getMaxHealth() * hp / 100);
        enemy.setDamage((int) enemy.getDamage() * damage / 100);
        enemy.setLevel();
    }
    /**
     * Uses an item from the player's inventory.
     *
     * @param human the player character
     * @param items the array of items available to the player
     * @param name the name of the item to use
     * @param dialog the dialog to display if the item is not available
     * @param dialog1 the dialog to close if the item is used successfully
     */
    public void UseItem(Player human, Items[] items, String name, JDialog dialog, JDialog dialog1) {
        switch (name) {
            case "jRadioButton1":
                if (items[0].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.25));
                    items[0].setCount(-1);
                } else {
                    dialog.setVisible(true);
                    dialog.setBounds(300, 200, 400, 300);
                }
                break;
            case "jRadioButton2":
                if (items[1].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.5));
                    items[1].setCount(-1);
                } else {
                    dialog.setVisible(true);
                    dialog.setBounds(300, 200, 400, 300);
                }
                break;
            case "jRadioButton3":
                dialog.setVisible(true);
                dialog.setBounds(300, 200, 400, 300);
                break;
        }
        
        if(dialog.isVisible()==false){
            dialog1.dispose();
        }
    }
}
