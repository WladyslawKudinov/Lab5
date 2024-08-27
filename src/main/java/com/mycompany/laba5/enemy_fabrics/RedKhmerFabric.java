package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.RedKhmer;
import com.mycompany.laba5.player.Player;



public class RedKhmerFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new RedKhmer(1, 60, 16, 1);
        return enemy;
    }

}
