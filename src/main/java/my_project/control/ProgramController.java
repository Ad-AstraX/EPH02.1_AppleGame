package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;
/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Player player01;
    private Player player02;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        Background background = new Background(0);
        viewController.draw(background);

        player01 = new Player1(50, Config.WINDOW_HEIGHT-100, 255, 0, 0);
        viewController.draw(player01);
        viewController.register(player01);

        player02 = new Player2(Config.WINDOW_WIDTH-150, Config.WINDOW_HEIGHT-100, 100, 255, 0);
        viewController.draw(player02);
        viewController.register(player02);

        Apple[] apples = new Apple[4];
        Pear[] pears = new Pear[4];

        for (int i = 0; i < 4; i++) {
            double xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
            double yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
            if (i == 3) {
                apples[i] = new PowerApple(xPos, yPos, player01);
            } else {
                apples[i] = new Apple(xPos, yPos, player01);
            }
            viewController.draw(apples[i]);

            xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
            yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
            if (i == 3) {
                pears[i] = new PowerPear(xPos, yPos, player01);
            } else {
                pears[i] = new Pear(xPos, yPos, player01, 20+Math.random()*30);
            }
            viewController.draw(pears[i]);
        }

        Button button = new Button();
        viewController.register (button);
        viewController.draw(button);
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
    }
}
