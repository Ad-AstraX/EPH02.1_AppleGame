package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CostumesButton extends Button {
    public boolean show;
    String[] costumes = {
            "src/main/resources/graphic/players/playerBlue.png",
            "src/main/resources/graphic/players/playerRed.png",
            "src/main/resources/graphic/players/pumpkinSkin.png",
            "src/main/resources/graphic/players/vampireByRehaf.png",
            "src/main/resources/graphic/players/playerPink.png"
    };
    public int selectedIndex;

    public CostumesButton(String originalPic, String hoveredOnPic) {
        super(625, 475, 2, originalPic, hoveredOnPic);

        selectedIndex = 2;
    }

    public void draw (DrawTool drawTool) {
        if (show) {
            drawTool.setCurrentColor(new Color(0, 0, 0, 173));
            drawTool.drawFilledRectangle(0, 400, Config.WINDOW_WIDTH, 325);

            for (int i = 0; i < costumes.length; i++) {
                if (i == selectedIndex) {
                    this.setNewImage(costumes[i]);
                    this.rescale(getMyImage().getWidth()*3.5, getMyImage().getHeight()*3.5);
                    drawTool.drawImage(getMyImage(), Config.WINDOW_WIDTH/2-width/2, 450);

                    if (i >= 1) {
                        this.setNewImage(costumes[i-1]);
                        this.rescale(getMyImage().getWidth()*2, getMyImage().getHeight()*2);
                        drawTool.drawImage(getMyImage(), Config.WINDOW_WIDTH/2-width*3, 520);
                        if (i >= 2) {
                            this.setNewImage(costumes[i-2]);
                            drawTool.drawImage(getMyImage(), Config.WINDOW_WIDTH/2-width*7.5, 580);

                        }
                    }

                    if (i < costumes.length-1) {
                        this.setNewImage(costumes[i+1]);
                        this.rescale(getMyImage().getWidth()*2, getMyImage().getHeight()*2);
                        drawTool.drawImage(getMyImage(), Config.WINDOW_WIDTH/2+width*2, 520);
                        if (i < costumes.length-2) {
                            this.setNewImage(costumes[i+2]);
                            drawTool.drawImage(getMyImage(), Config.WINDOW_WIDTH/2+width*6.5, 580);

                        }
                    }
                }
            }
        } else {
            super.draw(drawTool);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e)) {
            show = true;
        }
    }
}