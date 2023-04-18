package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class ArrowsButton extends Button{

    private boolean right;
    private CostumesButton cb;
    public ArrowsButton(
            double x,
            double y,
            double multiplyBy,
            boolean right,
            String originalPic,
            String hoveredOnPic,
            CostumesButton cb)
    {
        super(x, y, multiplyBy, originalPic, hoveredOnPic);

        this.right = right;
        this.cb = cb;
    }

    public void draw(DrawTool drawTool) {
        if (cb.show) {
            drawTool.drawImage(getMyImage(), x, y);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e)) {
            if (right && cb.costumes.length-1 > cb.selectedIndex) {
                cb.selectedIndex += 1;
            } else if (!right && 0 < cb.selectedIndex){
                cb.selectedIndex -= 1;
            }
        }
    }
}
