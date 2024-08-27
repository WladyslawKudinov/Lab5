package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.BuffedHeil;
import com.mycompany.laba5.player.Player;





public class BuffedHeilFabric implements EnemyFabricInterface{
    
    @Override
    public Player create(int i) {
        Player enemy;
        if(i==0){
            enemy = new BuffedHeil(3, 100, 30, 1);
        }
        else{
           enemy = new BuffedHeil(3, 145, 44, 1);
        }
        return enemy;
    }
}
