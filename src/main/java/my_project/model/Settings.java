package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Settings extends Button {
    private boolean show;
    public Settings(double x, double y) {
        super(x, y, 4,
                "src/main/resources/graphic/buttons/settingsButton/gameSettingsGreen.png",
                "src/main/resources/graphic/buttons/settingsButton/gameSystemRed.png"
        );
    }

    public void draw (DrawTool drawTool) {
        if (show) {
            drawTool.setCurrentColor(new Color(0, 0, 0, 102));
            drawTool.drawFilledRectangle(x, y, width, 300);
        }
        drawTool.drawImage(getMyImage(), x, y);
    }

    public void mouseClicked (MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e) && !show) {
            show = true;
        } else if (e.getButton() == 1 && mouseOnPic(e) && show) {
            show = false;
        }
    }

    public boolean isShow() {
        return show;
    }
}