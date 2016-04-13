/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import Tiles.World;
import java.awt.Color;

/**
 *
 * @author c0640785
 */
public class Creature {
    private World world;
    
    public int x;
    public int y;
    
    private char glyph;
    public char glyph() {return glyph;}
    
    private Color color;
    public Color color() {return color;}
    
    public Creature(World world, char glyph, Color color) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }
    
    private CreatureAi ai;
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
    
    public void moveBy(int mx, int my){
    ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
    }
    
    public void dig(int wx, int wy) {
    world.dig(wx, wy);
    }
}
