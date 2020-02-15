package dev.idion.monsterrace.gui;

import java.awt.*;

import static dev.idion.monsterrace.MainMenu.GAME_START;
import static dev.idion.monsterrace.MainMenu.MONSTER_INFO;
import static dev.idion.monsterrace.MainMenu.TERMINATE_GAME;
import static dev.idion.monsterrace.StringConstants.GAME_NAME;

public class MainFrame {
    private final Dimension frameSize = new Dimension(1280, 720);
    private Frame frame = new Frame(GAME_NAME.toString());
    private Button monsterManageButton = new Button(MONSTER_INFO.toString());
    private Button gameStartButton = new Button(GAME_START.toString());
    private Button exitGameButton = new Button(TERMINATE_GAME.toString());

    public void init() {
        frame.setSize(frameSize);
    }

    public void display() {
        frame.setVisible(true);
    }
}
