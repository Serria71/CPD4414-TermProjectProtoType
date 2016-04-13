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
public class CreatureAi {
    protected Creature creature;
    
    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setCreatureAI(this);
    }
    
    public void onEnter(int x, int y, Tile tile){}
}
