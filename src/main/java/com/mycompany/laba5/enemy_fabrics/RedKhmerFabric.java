package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.RedKhmer;
import com.mycompany.laba5.player.Player;

/**
 * The RedKhmerFabric class implements the EnemyFabricInterface to create instances
 * of the RedKhmer enemy. This class is responsible for instantiating RedKhmer enemies
 * with predefined attributes.
 */
public class RedKhmerFabric implements EnemyFabricInterface {
    /**
     * Creates an instance of the RedKhmer enemy with predefined attributes.
     *
     * @param i the level of the enemy to create
     * @return a Player object representing the created RedKhmer enemy
     */
    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new RedKhmer(1, 60, 16, 1);
        return enemy;
    }

}
