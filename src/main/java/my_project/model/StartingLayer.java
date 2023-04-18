package my_project.model;

import java.awt.*;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
public class StartingLayer extends GraphicalObject{
    double timer;
    double vel = 1000;
    Player[] players;
    public StartingLayer(Player[] players) {
        this.players = players;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color (0, 0, 0, 139));
        drawTool.drawFilledRectangle(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);

        // text
        this.setNewImage("src/main/resources/graphic/fonts/catchText.png");
        drawTool.drawImage(getMyImage(), 260 - vel, 200);
        this.setNewImage("src/main/resources/graphic/fonts/theFruitsText.png");
        drawTool.drawImage(getMyImage(), 190 + vel, 305);

        //coins
        this.setNewImage("src/main/resources/graphic/coin.png");
        this.rescale(getMyImage().getWidth()*0.15, getMyImage().getHeight()*0.15);
        drawTool.drawImage(getMyImage(), 25, 50);
        drawTool.drawImage(getMyImage(), Config.WINDOW_WIDTH-95, 50);

        // Number of Coins displayed
        drawTool.setCurrentColor (new Color (0, 0, 0));
        drawTool.formatText("Monospaced", 1, 70);
        drawTool.drawText(90+Integer.toString (players[1].coins).length()*4, 95, Integer.toString (players[0].coins));
        drawTool.drawText(Config.WINDOW_WIDTH-140-Integer.toString (players[1].coins).length()*40, 95, Integer.toString (players[1].coins));
    }

    @Override
    public void update(double dt) {
        timer += dt;
        vel *= 0.9;
    }
}
