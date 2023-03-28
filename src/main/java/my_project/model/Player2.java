package my_project.model;

import java.awt.event.KeyEvent;

public class Player2 extends Player {
    public Player2(double x, double y, int r, int g, int b) {
        super(x, y, r, g, b);

        this.keyToGoLeft    = KeyEvent.VK_A;
        this.keyToGoRight   = KeyEvent.VK_D;
    }
}
