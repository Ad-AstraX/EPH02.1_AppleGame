package my_project.model;

import java.awt.*;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    protected double speed;
    protected int points;

    //Tastennummern zur Steuerung
    protected int keyToGoLeft;
    protected int keyToGoRight;
    protected int direction;
    protected int r;
    protected int g;
    protected int b;

    public Player(double x, double y, int r, int g, int b){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;
        this.r = r;
        this.g = g;
        this.b = b;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color (r,g,b,255));
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
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
    public void getBuff() {
        this.setSpeed(this.getSpeed()+Math.random()*50+50);
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
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public double getSpeed() {
        return speed;
    }
    public int getPoints() {
        return points;
    }
    public int getKeyToGoLeft() {
        return keyToGoLeft;
    }
    public int getKeyToGoRight() {
        return keyToGoRight;
    }
    public int getDirection() {
        return direction;
    }
}
