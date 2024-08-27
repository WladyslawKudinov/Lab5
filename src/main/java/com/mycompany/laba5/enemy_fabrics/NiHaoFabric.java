package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.NiHao;
import com.mycompany.laba5.player.Player;






public class NiHaoFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new NiHao(1, 80, 16, 1);
        return enemy;
    }

}
