package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.NiHao;
import com.mycompany.laba5.player.Player;





/**
 * The NiHaoFabric class implements the EnemyFabricInterface to create instances
 * of the NiHao enemy. This class is responsible for instantiating NiHao enemies
 * with predefined attributes.
 */
public class NiHaoFabric implements EnemyFabricInterface {
    /**
     * Creates an instance of the NiHao enemy with predefined attributes.
     *
     * @param i the level of the enemy to create
     * @return a Player object representing the created NiHao enemy
     */
    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new NiHao(1, 80, 16, 1);
        return enemy;
    }

}
