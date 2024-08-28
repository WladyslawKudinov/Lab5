package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.player.Player;


/**
 * The EnemyFabricInterface interface defines the contract for creating enemies.
 * Classes implementing this interface should provide the implementation for
 * creating a specific type of enemy based on the provided level.
 */
public interface EnemyFabricInterface {
    /**
     * Creates an enemy based on the provided level.
     *
     * @param i the level of the enemy to create
     * @return a Player object representing the created enemy
     */
    public Player create(int i);
}
