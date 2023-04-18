package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    public boolean selected;
    private int points;
    int coins;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;
    private int vel;

    // Referenzen
    String path;
    private CostumesButton cb;
    private Player p;

    public Player(double x, double y, int keyToGoLeft, int keyToGoRight, String path, CostumesButton cb){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;
        this.coins = 0;

        this.setNewImage (path);
        rescale(getMyImage().getWidth()*2, getMyImage().getHeight()*2);
        this.path = path;
        this.keyToGoLeft    = keyToGoLeft;
        this.keyToGoRight   = keyToGoRight;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links

        this.cb = cb;
        //this.p = new Player(7, 7, 7, 7, path, cb);
    }

    @Override
    public void draw(DrawTool drawTool) {
        this.setNewImage(path);
        this.rescale(getMyImage().getWidth()*2, getMyImage().getHeight()*2);
        drawTool.drawImage(getMyImage(), x, y);

        if (cb.show && selected) {
            drawTool.setCurrentColor(new Color (0, 0, 0));
            drawTool.formatText ("Monospaced", 1, 50);
            drawTool.drawText(x + width / 2-10, y - height*0.5, "V");
        }
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
            if (x <= 0) {
                x = 0;
            }
        }
        if (x < Config.WINDOW_WIDTH-width-14.5 && x > 0) {
            vel *= 0.9;
            x += vel;
        }
    }

    public void getBuff(){
        speed += 20;
    }
    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
            vel = 0;
        }
        if(key == keyToGoRight){
            direction = 0;
            vel = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
            vel = (int)-(speed/20);
        }
        if(key == keyToGoRight){
            direction = -1;
            vel = (int)(speed/20);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e) && !selected) {
            selected = true;
            if (p != null) {
                p.selected = false;
            }
        } else if (p != null) {
            if (p.selected == true) {
                selected = false;
            }
        }
    }

    public boolean mouseOnPic(MouseEvent e) {
        double mouseX = e.getLocationOnScreen().getX() - Config.WINDOW_X;
        double mouseY = e.getLocationOnScreen().getY() - Config.WINDOW_Y - 30;

        if (mouseX >= this.getX() && mouseX <= (int)(this.getX() + getMyImage().getWidth())
                && mouseY >= this.getY() && mouseY <= (int)(this.getY() + getMyImage().getHeight())) {
            try {
                /*
                System.out.println (getMyImage().getRGB((int)mouseX, (int)mouseY));
                int pixel = getMyImage().getRGB((int)mouseX, (int)mouseY);
                int alpha = (pixel >> 24) & 0xff;
                if (alpha == 0) {System.out.println(alpha); return false; }*/
                return true;
            }
            catch (ArrayIndexOutOfBoundsException exception) {return false;}
        }
        return false;
    }

    public void selectOtherPlayer(Player p) {
        this.p = p;
    }

}