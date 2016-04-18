/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rogueliketest.screens;

import Characters.Player;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 *
 * @author c0640785
 */
public class CharacterGenScreen implements Screen {
    public static double Str;
    public static double Dex;
    public static double Con;
    public static double Int;
    public static double Wis;
    public static double Cha;
    Player character = new Player(Str, Dex, Con, Int, Wis, Cha);
    
        public void displayOutput(AsciiPanel terminal) {
        
        terminal.write("Here are some fancy numbers.  They don't really do anything.", 1, 1);
        terminal.write("Strength: " + character.Strength, 1, 4);
        terminal.write("Dexterity : " + character.Dexterity, 1, 6);
        terminal.write("Constitution: " + character.Constitution, 1, 8);
        terminal.write("Intelligence: " + character.Intelligence, 1, 10);
        terminal.write("Wisdom: " + character.Wisdom, 1, 12);
        terminal.write("Charisma: " + character.Charisma, 1, 14);
        terminal.writeCenter("-- press the [enter] key to continue or [escape] to reroll.", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE: 
                stats();
                return new CharacterGenScreen();
            case KeyEvent.VK_ENTER: return new PlayScreen();
        }
        return this;
    }
    
    public static void stats() {
    for (int x = 1; x <= 6; x++) {
        Random rand2 = new Random();
        int randomNum2 = 1 + rand2.nextInt((6 - 1) + 1);
        Random rand3 = new Random();
        int randomNum3 = 1 + rand3.nextInt((6 - 1) + 1);
        
        switch (x) {
            case 1: Str = randomNum2 + randomNum3 + 6;
            case 2: Dex = randomNum2 + randomNum3 + 6;
            case 3: Con = randomNum2 + randomNum3 + 6;
            case 4: Int = randomNum2 + randomNum3 + 6;
            case 5: Wis = randomNum2 + randomNum3 + 6;
            case 6: Cha = randomNum2 + randomNum3 + 6;
        }
    }
    }
}
