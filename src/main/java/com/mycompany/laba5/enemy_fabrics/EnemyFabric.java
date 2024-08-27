package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.player.Player;




public class EnemyFabric {

    public Player create(int i, int j) {
        EnemyFabricInterface fabric = null;

        switch (i) {
            case 0:
                fabric = new UncleStoneFabric();
                break;
            case 1:
                fabric = new RedKhmerFabric();
                break;
            case 2:
                fabric = new DoctorMewFabric();
                break;
            case 3:
                fabric = new NiHaoFabric();
                break;
            case 4:
                fabric = new BuffedHeilFabric();
                break;
        }
        Player enemy = fabric.create(j);
        return enemy;
    }
}
