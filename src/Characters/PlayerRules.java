/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import Tiles.Tile;

/**
 *
 * @author c0640785
 */
public class PlayerRules extends CreatureAi {

    public PlayerRules(Creature creature) {
        super(creature);
    }
    
    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
        } else if (tile.isDiggable()) {
            creature.dig(x, y);
        }
    }

}
