/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rogueliketest.screens;

/**
 *
 * @author c0640785
 */
import Tiles.World;
import Tiles.WorldBuilder;
import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class PlayScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();
   
        displayTiles(terminal, left, top);
        terminal.write('X', centerX - left, centerY - top);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
        case KeyEvent.VK_ESCAPE: return new LoseScreen();
        case KeyEvent.VK_K: return new StatScreen();
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A: scrollBy(-1, 0); break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D: scrollBy( 1, 0); break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S: scrollBy( 0, 1); break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_W: scrollBy(0,-1); break;
        }
    
        return this;
    }
    
    private World world;
    private int centerX;
    private int centerY;
    private int screenWidth;
    private int screenHeight;

    public PlayScreen(){
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
    }
    
    private void createWorld(){
        world = new WorldBuilder(90, 31)
              .makeCaves()
              .build();
    }
    public int getScrollX() {
        return Math.max(0, Math.min(centerX - screenWidth / 2, world.width() - screenWidth));
    }
    public int getScrollY() {
        return Math.max(0, Math.min(centerY - screenHeight / 2, world.height() - screenHeight));
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
    for (int x = 0; x < screenWidth; x++){
        for (int y = 0; y < screenHeight; y++){
            int wx = x + left;
            int wy = y + top;

            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
            }
        }
    }
    private void scrollBy(int mx, int my){
        centerX = Math.max(0, Math.min(centerX + mx, world.width() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.height() - 1));
    }
    
}