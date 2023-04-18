package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.image.BufferedImage;

public abstract class Fruit extends GraphicalObject {

    //Attribute
    private double speed;
    protected Player[] players;
    protected double timer;
    protected String imagePath;

    public Fruit(double x, double y, String image, Player[] players){
        super (image, x, y);
        speed = 150;
        this.height = getMyImage().getHeight();
        this.width =  getMyImage().getWidth();
        this.players = players;
        this.imagePath = image;
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
            this.setNewImage(imagePath);
            rescalePercent(0.9+Math.random()*1.9, 50);
            rescalePercent(0.9+Math.random()*1.9, 50);
            this.height = getMyImage().getHeight();
            this.width =  getMyImage().getWidth();
            jumpBack();
        }
    }

    public void jumpBack() {
        this.y = -height;
        this.x = Math.random()* (Config.WINDOW_WIDTH-width);
    }

    private boolean checkAndHandleCollision() {
        for (Player player : players) {
            if (this.collidesWith(player)) {
                if (this instanceof PowerApple) {
                    player.getBuff();
                }
                return true;
            }
        }
        return false;
    }
}