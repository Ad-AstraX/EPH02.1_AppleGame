package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class Box extends Button {
    private boolean ticked;
    private boolean doSchoolTasks;

    // Referenzen
    Settings sb;
    public Box(double x, double y, Settings sb) {
        super(x, y, 3,
                "src/main/resources/graphic/buttons/boxButton/boxNotTicked.png",
                "src/main/resources/graphic/buttons/boxButton/boxTicked.png");

        this.sb = sb;
    }

    public void draw (DrawTool drawTool) {
        if (sb.isShow()) {
            drawTool.drawImage(getMyImage(), x, y);
        }
    }
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e) && ticked) {
            ticked = false;
        } else if (e.getButton() == 1 && mouseOnPic(e) && !ticked) {
            ticked = true;
        }
        if (ticked) {
            originalPic = "src/main/resources/graphic/buttons/boxButton/boxTicked.png";
            hoveredOnPic = "src/main/resources/graphic/buttons/boxButton/boxNotTicked.png";
        } else {
            originalPic = "src/main/resources/graphic/buttons/boxButton/boxNotTicked.png";
            hoveredOnPic = "src/main/resources/graphic/buttons/boxButton/boxTicked.png";
        }
    }
}
