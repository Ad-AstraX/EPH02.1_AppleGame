package my_project.model;

import java.awt.event.MouseEvent;

public class PlayButton extends Button {
    private boolean start;
    public PlayButton(String originalPic, String hoveredOnPic) {
        super(400, 450, 3, originalPic, hoveredOnPic);
    }
    public void mouseClicked (MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e)) {
            this.start = true;
        }
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}
