package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.UncleStone;
import com.mycompany.laba5.player.Player;





public class UncleStoneFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new UncleStone(1, 100, 12, 1);
        return enemy;
    }
}
