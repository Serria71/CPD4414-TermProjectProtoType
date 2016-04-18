/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rogueliketest.screens;

import Characters.Player;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

/**
 *
 * @author c0640785
 */
public class StatScreen implements Screen {
        public void displayOutput(AsciiPanel terminal) {
        terminal.write("Here are some fancy numbers.  They don't really do anything.", 1, 1);
        terminal.write("Strength: " + Player.Strength, 1, 4);
        terminal.write("Dexterity: " + Player.Dexterity, 1, 6);
        terminal.write("Constitution: " + Player.Constitution, 1, 8);
        terminal.write("Intelligence: " + Player.Intelligence, 1, 10);
        terminal.write("Wisdom: " + Player.Wisdom, 1, 12);
        terminal.write("Charisma: " + Player.Charisma, 1, 14);
        terminal.writeCenter("-- press the [enter] key to continue to the game", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}