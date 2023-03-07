package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import my_project.Config;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Button extends InteractiveGraphicalObject {
    boolean show;
    String currentPic;
    public Button () {
        this.setNewImage("src/main/resources/graphic/buttonScoreSystem.png");
        currentPic = "src/main/resources/graphic/buttonScoreSystem.png";
        x = 10;
        y = 10;
    }

    public void draw(DrawTool drawTool) {
        if (show) {
            drawTool.drawImage(getMyImage(), x, y);
        }
        //System.out.println(getMyImage());
    }
    @Override
    public void mouseClicked(MouseEvent e) {
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
    }
    public boolean mouseOnPic(BufferedImage bI, GraphicalObject gO, MouseEvent e) {
        double mouseX = e.getLocationOnScreen().getX() - 468;
        double mouseY = e.getLocationOnScreen().getY() - 120;

        if (mouseX >= gO.getX() && mouseX <= (int)(gO.getX() + bI.getWidth())
                && mouseY >= gO.getY() && mouseY < (int)(gO.getY() + bI.getHeight())) {

            int pixel = bI.getAlphaRaster().getSample((int)mouseX, (int)mouseY, 0);
            int alpha = (pixel >> 24) & 0xff;

            if (alpha != 0) {System.out.println(alpha); return true;}
            return false;
        }
        return false;
    }
}
