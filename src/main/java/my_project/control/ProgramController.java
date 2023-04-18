package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute
    private double timer;

    // Referenzen
    PlayButton pb;
    CostumesButton cb;
    SoundsButton sb;

    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Player[] players;
    private Apple[] apples;
    private Pear[] pears;

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
        Background background = new Background();
        viewController.draw(background);
        fruits();

        StartingLayer sl = new StartingLayer(players);
        viewController.draw(sl);
        pb = new PlayButton(
                "src/main/resources/graphic/buttons/playButton/playButtonGreen.png",
                "src/main/resources/graphic/buttons/playButton/playButtonRed.png"
        );
        viewController.draw(pb);
        viewController.register(pb);

        SoundsButton sb = new SoundsButton(
                "src/main/resources/graphic/buttons/soundButton/soundsButtonGreen.png",
                "src/main/resources/graphic/buttons/soundButton/soundsButtonRed.png"
        );
        viewController.draw(sb);
        viewController.register(sb);

        Settings settingsButton = new Settings(
                Config.WINDOW_WIDTH/2-185,
                600
        );
        viewController.draw(settingsButton);
        viewController.register(settingsButton);

        Box box = new Box(350, 680, settingsButton);
        viewController.draw(box);
        viewController.register(box);

        cb = new CostumesButton(
                "src/main/resources/graphic/buttons/costumesButton/buttonCostumesGreen.png",
                "src/main/resources/graphic/buttons/costumesButton/buttonCostumesRed.png"
        );
        viewController.draw(cb);
        viewController.register(cb);

        players = new Player[] {
                new Player(
                        50,
                        Config.WINDOW_HEIGHT-200,
                        KeyEvent.VK_A,
                        KeyEvent.VK_D,
                        "src/main/resources/graphic/players/playerBlue.png",
                        cb
                ),
                new Player(
                        Config.WINDOW_WIDTH-175,
                        Config.WINDOW_HEIGHT-200,
                        KeyEvent.VK_LEFT,
                        KeyEvent.VK_RIGHT,
                        "src/main/resources/graphic/players/playerRed.png",
                        cb
                )
        };
        players[0].selected = true;
        players[0].selectOtherPlayer(players[1]);
        players[1].selectOtherPlayer(players[0]);
        for (int i = 0; i < players.length; i++) {
            viewController.draw(players[i]);
            viewController.register(players[i]);
        }

        ArrowsButton abRight = new ArrowsButton(
                Config.WINDOW_WIDTH/2+150,
                475,
                2,
                true,
                "src/main/resources/graphic/buttons/costumesButton/arrows/arrowRightGreen.png",
                "src/main/resources/graphic/buttons/costumesButton/arrows/arrowRightRed.png",
                cb
        );
        viewController.draw(abRight);
        viewController.register(abRight);
        ArrowsButton abLeft = new ArrowsButton(
                Config.WINDOW_WIDTH/2-200,
                475,
                2,
                false,
                "src/main/resources/graphic/buttons/costumesButton/arrows/arrowLeftGreen.png",
                "src/main/resources/graphic/buttons/costumesButton/arrows/arrowLeftRed.png",
                cb
        );
        viewController.draw(abLeft);
        viewController.register(abLeft);

        CancelButton cancelb = new CancelButton(925, 425, cb);
        viewController.draw(cancelb);
        viewController.register(cancelb);

        EquipButton eb = new EquipButton(Config.WINDOW_WIDTH/2-50, 650, cb, players);
        viewController.draw(eb);
        viewController.register(eb);

        // new Scene
        viewController.createScene();
        viewController.showScene(1);

        viewController.draw(background);

        fruits();
        for (int i = 0; i < players.length; i++) {
            viewController.draw(players[i]);
            viewController.register(players[i]);
        }
    }

    private void fruits() {
        if (viewController.getCurrentScene() == 0) {
            players = new Player[]{
                    new Player(
                            50,
                            Config.WINDOW_HEIGHT - 200,
                            KeyEvent.VK_A,
                            KeyEvent.VK_D,
                            "src/main/resources/graphic/players/playerBlue.png",
                            new CostumesButton(
                                    "src/main/resources/graphic/buttons/costumesButton/buttonCostumesGreen.png",
                                    "src/main/resources/graphic/buttons/costumesButton/buttonCostumesGreen.png"
                            )
                    ),
                    new Player(
                            Config.WINDOW_WIDTH - 150,
                            Config.WINDOW_HEIGHT - 200,
                            KeyEvent.VK_LEFT,
                            KeyEvent.VK_RIGHT,
                            "src/main/resources/graphic/players/playerRed.png",
                            new CostumesButton("src/main/resources/graphic/buttons/costumesButton/buttonCostumesGreen.png",
                                    "src/main/resources/graphic/buttons/costumesButton/buttonCostumesGreen.png"
                            )
                    )
            };
        }

        apples = new Apple[5];
        pears = new Pear[5];

        for (int i = 0; i < 5; i++) {
            double xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
            double yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
            if (i == 3) {
                apples[i] = new PowerApple(xPos, yPos, players);
            } else {
                apples[i] = new Apple(xPos, yPos, players);
            }
            viewController.draw(apples[i]);

            xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
            yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
            if (i == 3) {
                pears[i] = new PowerPear(xPos, yPos, players);
            } else {
                pears[i] = new Pear(xPos, yPos, players, 20+Math.random()*30);
            }
            viewController.draw(pears[i]);
        }

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        timer += dt;

        if (!pb.isStart()) {
            viewController.showScene(0);
        }
        if (pb.isStart()) {
            viewController.showScene(1);
        }
    }
}
