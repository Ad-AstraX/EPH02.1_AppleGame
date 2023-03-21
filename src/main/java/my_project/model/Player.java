package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private int points;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;

    public Player(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;

        this.keyToGoLeft    = KeyEvent.VK_A;
        this.keyToGoRight   = KeyEvent.VK_D;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
        if(direction == 0){
            x = x + speed*dt;
            if (x > Config.WINDOW_WIDTH-width-14.5) {
                x = Config.WINDOW_WIDTH-width-14.5;
            }
        }
        if(direction == 2){
            x = x - speed*dt;
            if (x < 0) {
                x = 0;
            }
        }
    }

    public void setKeyToGoLeft(int keyToGoLeft) {
        this.keyToGoLeft = keyToGoLeft;
    }

    public void setKeyToGoRight(int keyToGoRight) {
        this.keyToGoRight = keyToGoRight;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }
}
