package my_project.model;

import java.awt.event.KeyEvent;

public class Player1 extends Player{
    public Player1(double x, double y, int r, int g, int b) {
        super(x, y, r, g, b);

        this.keyToGoLeft    = KeyEvent.VK_LEFT;
        this.keyToGoRight   = KeyEvent.VK_RIGHT;
    }
}
