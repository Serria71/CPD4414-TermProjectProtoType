/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rogueliketest;
import javax.swing.JFrame;
import asciiPanel.AsciiPanel;

/**
 *
 * @author c0640785
 * http://trystans.blogspot.ca/2016/01/roguelike-tutorial-00-table-of-contents.html
 * This is a link to the Roguelike tutorial I'm using as a base so we can hopefully have something functional in the future.
 */

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import rogueliketest.screens.Screen;
import rogueliketest.screens.StartScreen;

public class RoguelikeTest extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private Screen screen;

    public RoguelikeTest(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        RoguelikeTest app = new RoguelikeTest();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
