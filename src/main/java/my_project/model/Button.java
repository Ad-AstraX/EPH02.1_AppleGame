package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import my_project.Config;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public abstract class Button extends InteractiveGraphicalObject {
    // Attribute
    protected double multiplyBy;

    // Referenzen
    protected String originalPic;
    protected String hoveredOnPic;
    public Button (double x, double y, double multiplyBy, String originalPic, String hoveredOnPic) {
        this.x = x;
        this.y = y;
        this.multiplyBy = multiplyBy;

        this.setNewImage(originalPic);
        this.originalPic = originalPic;
        this.hoveredOnPic = hoveredOnPic;

        this.rescale(
                getMyImage().getWidth()*multiplyBy,
                getMyImage().getHeight()*multiplyBy
        );
        this.height = getMyImage().getHeight();
        this.width = getMyImage().getWidth();
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(), x, y);
    }

    public void update(double dt) {
    }
    @Override
    public void mouseMoved(MouseEvent e){
        if (mouseOnPic(e)) {
            this.setNewImage(hoveredOnPic);
        } else {
            this.setNewImage(originalPic);
        }
        this.rescale(
                getMyImage().getWidth()*multiplyBy,
                getMyImage().getHeight()*multiplyBy
        );
        this.height = getMyImage().getHeight();
        this.width = getMyImage().getWidth();
    }
    public void mouseClicked(MouseEvent e) {
        /*
        if (mouseOnPic(e)) {
            this.setNewImage(hoveredOnPic);
            if (e.getButton() == 1) {

            if (show) {
                if (mouseOnPic(getMyImage(), this, e)){
                    if (currentPic == "src/main/resources/graphic/buttonScoreSystem.png") {
                        currentPic = "src/main/resources/graphic/buttonScoreSystem2.png";
                        this.setNewImage("src/main/resources/graphic/buttonScoreSystem2.png");
                    } else {
                        currentPic = "src/main/resources/graphic/buttonScoreSystem.png";
                        this.setNewImage("src/main/resources/graphic/buttonScoreSystem.png");
                    }
                } else if (!mouseOnPic(getMyImage(), this, e)) {
                    show = false;
                }
            } else {
                show = true;
            }
            }
        } else {
            this.setNewImage(originalPic);
        }*/
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
}
