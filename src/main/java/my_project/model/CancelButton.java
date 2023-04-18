package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class CancelButton extends Button{
    CostumesButton cb;
    public CancelButton(double x, double y, CostumesButton cb) {
        super(x, y, 1,
                "src/main/resources/graphic/buttons/costumesButton/cancel/cancelButtonGreen.png",
                "src/main/resources/graphic/buttons/costumesButton/cancel/cancelButtonRed.png"
        );

        this.cb = cb;
    }
    public void draw (DrawTool drawTool) {
        if (cb.show) {
            drawTool.drawImage(getMyImage(), x, y);
        }
    }
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e)) {
            cb.show = false;
        }
    }
}
