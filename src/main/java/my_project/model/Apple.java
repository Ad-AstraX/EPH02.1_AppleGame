package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Apple extends GraphicalObject {

    //Attribute
    private double speed;

    public Apple(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        this.setNewImage("src/main/resources/graphic/apple.png");
        this.height = getMyImage().getHeight();
        this.width = getMyImage().getWidth();
    }

    @Override
    public void draw(DrawTool drawTool) {
        /*
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
         */
        drawTool.drawImage (getMyImage(), x, y);
    }

    @Override
    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
        this.y += this.speed*dt;
        if (this.y >= Config.WINDOW_HEIGHT) {
            jumpBack();
        }
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    public void jumpBack() {
        this.y = -height;
        this.x = Math.random()* Config.WINDOW_WIDTH;
    }

}
