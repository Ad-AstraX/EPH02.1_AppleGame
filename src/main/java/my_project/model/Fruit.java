package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.image.BufferedImage;

public abstract class Fruit extends GraphicalObject {

    //Attribute
    private double speed;
    protected Player player;
    protected double timer;
    protected double rescaledHeight;
    protected double rescalingPercentage;
    protected double rescaledWidth;

    public Fruit(double x, double y, String image, Player player){
        super (image, x, y);
        speed = 150;
        this.height = getMyImage().getHeight();
        this.width =  getMyImage().getWidth();
        this.player = player;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage (getMyImage(), x, y);
    }

    @Override
    public void update(double dt) {
        timer += dt;
        this.y += this.speed*dt;
        if (this.y >= Config.WINDOW_HEIGHT || checkAndHandleCollision()) {

            rescalePercent(0.9+Math.random()*1.9, 50);
            if (this instanceof Pear) {
                rescalePercent(0.9+Math.random()*1.9, 50);
            }
            jumpBack();
            if (this instanceof PowerApple) {
                player.getBuff();
            }
        }
    }

    public void jumpBack() {
        this.y = -height;
        this.x = Math.random()* (Config.WINDOW_WIDTH-width);
    }

    private boolean checkAndHandleCollision() {
        return this.collidesWith(player);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getTimer() {
        return timer;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }

    public double getRescaledHeight() {
        return rescaledHeight;
    }

    public void setRescaledHeight(double rescaledHeight) {
        this.rescaledHeight = rescaledHeight;
    }

    public double getRescaledWidth() {
        return rescaledWidth;
    }

    public void setRescaledWidth(double rescaledWidth) {
        this.rescaledWidth = rescaledWidth;
    }
}