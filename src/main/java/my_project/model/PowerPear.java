package my_project.model;

import KAGO_framework.view.DrawTool;
import java.awt.*;
public class PowerPear extends Pear{
    private double pulse;
    private double speedBuff;

    public PowerPear(double x, double y, Player[] players){
        super (x, y, players, 0);
    }

    public void draw (DrawTool drawTool) {
        drawTool.setCurrentColor (new Color(100, 231, 59, 115));

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
