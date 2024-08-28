package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.enemys.DoctorMew;
import com.mycompany.laba5.player.Player;




/**
 * This class implements the EnemyFabricInterface to create DoctorMew enemies.
 */
public class DoctorMewFabric implements EnemyFabricInterface {
    /**
     * Creates a DoctorMew enemy based on the given parameter.
     *
     * @param i the parameter to determine the type of DoctorMew enemy
     * @return the created DoctorMew enemy
     */
    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new DoctorMew(1, 70, 20, 1);
        return enemy;
    }
}
