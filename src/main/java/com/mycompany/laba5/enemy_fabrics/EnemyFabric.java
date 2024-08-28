package com.mycompany.laba5.enemy_fabrics;

import com.mycompany.laba5.player.Player;



/**
 * The EnemyFabric class is responsible for creating different types of enemies
 * based on the provided parameters. It uses the Factory Method pattern to
 * instantiate specific enemy types.
 */
public class EnemyFabric {
    /**
     * Creates an enemy based on the provided type and level.
     *
     * @param i the type of enemy to create (0 for UncleStone, 1 for RedKhmer,
     *          2 for DoctorMew, 3 for NiHao, 4 for BuffedHeil)
     * @param j the level of the enemy to create
     * @return a Player object representing the created enemy
     */
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
