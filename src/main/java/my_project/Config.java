package my_project;

import KAGO_framework.control.ViewController;
/**
 * In dieser Klasse werden globale, statische Einstellungen verwaltet.
 * Die Werte können nach eigenen Wünschen angepasst werden.
 */
public class Config {

    // Titel des Programms (steht oben in der Fenstertitelzeile)
    public final static String WINDOW_TITLE = "Apple-Game";

    // Konfiguration des Standardfensters: Anzeige und Breite des Programmfensters (Width) und Höhe des Programmfensters (Height)
    public final static boolean SHOW_DEFAULT_WINDOW = true;
    public final static int WINDOW_WIDTH = 1000;
    public final static int WINDOW_HEIGHT = 1000+29;   // Effektive Höhe ist etwa 29 Pixel geringer (Titelleiste wird mitgezählt)
    public final static double WINDOW_X = ViewController.window_x;
    public final static double WINDOW_Y = ViewController.window_y;

    // Weitere Optionen für das Projekt
    public final static boolean useSound = true;

}
