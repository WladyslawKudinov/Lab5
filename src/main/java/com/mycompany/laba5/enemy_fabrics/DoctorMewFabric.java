package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.DoctorMew;
import com.mycompany.laba5.player.Player;






public class DoctorMewFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new DoctorMew(1, 70, 20, 1);
        return enemy;
    }
}
