package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.UncleStone;
import com.mycompany.laba5.player.Player;



/**
 * The UncleStoneFabric class implements the EnemyFabricInterface to create instances
 * of the UncleStone enemy. This class is responsible for instantiating UncleStone enemies
 * with predefined attributes.
 */

public class UncleStoneFabric implements EnemyFabricInterface {
    /**
     * Creates an instance of the UncleStone enemy with predefined attributes.
     *
     * @param i the level of the enemy to create
     * @return a Player object representing the created UncleStone enemy
     */
    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new UncleStone(1, 100, 12, 1);
        return enemy;
    }
}
