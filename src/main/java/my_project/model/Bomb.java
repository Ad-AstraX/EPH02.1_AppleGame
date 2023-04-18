package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;

public class Bomb extends Fruit {
    private double pulse;
    private double explosionTimer;
    public Bomb (double x, double y, Player[] players) {
        super (x, y, "src/main/resources/graphic/bomb.png", players);

        explosionTimer = 2+Math.random ()*5;
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(), x, y);

        drawTool.setCurrentColor (new Color(0, 0, 0, 74));

        drawTool.drawFilledCircle (x+width/2, y+height/2, (Math.max(height, width))-15);
        super.draw(drawTool);
        drawTool.drawFilledCircle (x+width/2, y+height/2, Math.max(height, width)+pulse);
    }

    public void update(double dt){
        super.update(dt);
        if ((int)timer % 2 == 0) {
            pulse -= 1;
        } else {
            pulse += 1;
        }
    }
}
