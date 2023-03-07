package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Fruit extends GraphicalObject {

    //Attribute
    private double speed;
    private Player player;

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
        this.y += this.speed*dt;
        if (this.y >= Config.WINDOW_HEIGHT || checkAndHandleCollision()) {
            jumpBack();
        }
    }

    public void jumpBack() {
        this.y = -height;
        this.x = Math.random()* (Config.WINDOW_WIDTH-width);
    }
    private boolean checkAndHandleCollision() {
        return this.collidesWith(player);
    }
}