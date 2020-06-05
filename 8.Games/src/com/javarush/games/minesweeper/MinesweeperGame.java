package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9; // the field's size
    private GameObject[][] gameField = new GameObject[this.SIDE][this.SIDE];
    private int countMinesOnField = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        System.out.println(this.countMinesOnField);
    }

    private void createGame() {
        for (int x = 0; x < this.SIDE; x++) {
            for (int y = 0; y < this.SIDE; y++) {
                if (getRandomNumber(10) == 1) {
                    this.gameField[x][y] = new GameObject(y, x, true);
                    this.countMinesOnField++;
                }
                else
                    this.gameField[x][y] = new GameObject(y, x, false);
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }
}

