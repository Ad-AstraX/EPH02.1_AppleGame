package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class EquipButton extends Button {
    CostumesButton cb;
    Player[] players;
    Player currentPlayer;
    public EquipButton(double x, double y, CostumesButton cb, Player[] players) {
        super(x, y, 2,
                "src/main/resources/graphic/buttons/costumesButton/equip/equippedButtonGreen.png",
                "src/main/resources/graphic/buttons/costumesButton/equip/equippedButtonRed.png");
        this.cb = cb;
        this.players = players;

        if (players[0].selected) {
            currentPlayer = players[0];
        } else {
            currentPlayer = players[1];
        }
        if (cb.costumes[cb.selectedIndex] != currentPlayer.path) {
            this.originalPic = "src/main/resources/graphic/buttons/costumesButton/equip/equipButtonGray.png";
            this.hoveredOnPic = "src/main/resources/graphic/buttons/costumesButton/equip/equipButtonGreen.png";
        }
        this.setNewImage(originalPic);
        this.rescale (getMyImage().getWidth()*2, getMyImage().getHeight()*2);
    }

    public void draw (DrawTool drawTool) {
        if (cb.show) {
            if (players[0].selected) {
                currentPlayer = players[0];
            } else {
                currentPlayer = players[1];
            }

            if (cb.costumes[cb.selectedIndex] != currentPlayer.path) {
                this.originalPic = "src/main/resources/graphic/buttons/costumesButton/equip/equipButtonGray.png";
                this.hoveredOnPic = "src/main/resources/graphic/buttons/costumesButton/equip/equipButtonGreen.png";
            } else {
                this.originalPic = "src/main/resources/graphic/buttons/costumesButton/equip/equippedButtonGreen.png";
                this.hoveredOnPic = "src/main/resources/graphic/buttons/costumesButton/equip/equippedButtonRed.png";
            }
            drawTool.drawImage(getMyImage(), x, y);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && mouseOnPic(e) && cb.costumes[cb.selectedIndex] != currentPlayer.path && cb.show) {
            currentPlayer.path = cb.costumes[cb.selectedIndex];
        }
    }
}