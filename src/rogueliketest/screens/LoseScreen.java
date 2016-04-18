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
import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import static rogueliketest.screens.CharacterGenScreen.stats;

public class LoseScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You presumably starved to death in a cave all alone.", 1, 1);
        terminal.writeCenter("-- press the [enter] key to create another character --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER: 
                stats();
                return new CharacterGenScreen();
        }
        return this;
    }
}