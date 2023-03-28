package my_project.model;

import java.awt.*;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

/**
 * Die Background-Klasse stellt die Umsetzung eines Objekts für den Hintergrund des Apple-Games dar.
 * Hier werden sogenannte Arrays (zu deutsch: Felder) verwendet, die im Unterricht noch nicht behandelt wurden.
 */

public class Background extends GraphicalObject {

    //Referenzen
    String chosenPhrase;
    String[] phrases = new String[]{"\"An apple a day keeps the doctor away!\" - England",
            "\"Eat an apple on going to bed, and you’ll keep the doctor from earning his bread.\" - Wales",
            "\"Ein Apfel am Tag, Arzt gespart!\" - Deutschland",
            "\"Una mela al giorno toglie il medico di torno.\" - Italien",
            "\"Jedna jabuka na dan, i doktor ti neće ući u stan.\" - Serbien",
            "\"Günde bir elma Doktoru uzak tutar.\" - Türkei",
            "\"Rojek sêvek doktor dûr dike\" - Kurdisch",
            "\"تفاحة على الريق تغنيك عن الطبيب\" - Arabisch"};
    public Background(int scene){
        chosenPhrase = phrases[(int)(Math.random()*phrases.length)];
        this.setNewImage("src/main/resources/graphic/Background.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        /*
        drawTool.setCurrentColor(25,100,0,255);
        drawTool.drawFilledRectangle(0,0,1600,1024);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.formatText("Arial",1,25);
        drawTool.drawText(450,50,chosenPhrase);
         */
        drawTool.drawImage(getMyImage(), 0, 0);
        rescale(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
    }

    @Override
    public void update(double dt) {
    }

}