package my_project.model;

import java.awt.*;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
public class StartingLayer extends GraphicalObject{
    int scene;
    double timer;
    public StartingLayer(int scene) {
        this.scene = scene;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (scene == 0) {
            drawTool.setCurrentColor(new Color (0, 0, 0, 148));
            drawTool.drawFilledRectangle(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
            if (timer >= 1) {
                drawTool.drawImage(getMyImage(), 300, 300);
            }
        }
    }

    @Override
    public void update(double dt) {
        timer += dt;
    }
}
