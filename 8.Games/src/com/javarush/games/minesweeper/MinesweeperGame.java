package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9; // размер квадратного игрового поля
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private GameObject[][] gameField = new GameObject[SIDE][SIDE]; // массив ячеек поля
    private int countMinesOnField; // количество мин на поле
    private int countFlags; // количество неиспользованных флагов


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        this.countFlags = this.countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (GameObject[] g : this.gameField) {
            for (GameObject go : g) {
                // получить соседей кождой ячейки и передать их в лист соседей
                List<GameObject> gameObjectList = getNeighbors(go);
                for (GameObject isMine : gameObjectList) {
                    // Метод countMineNeighbors() должен для каждой ячейки "не мины"
                    // из матрицы gameField подсчитать количество соседних ячеек "мин"
                    // и установить это значение в поле countMineNeighbors.
                    if (!go.isMine && isMine.isMine) {
                        go.countMineNeighbors++;
                    }
                }
            }

        }
    }

    private void openTile(int x, int y) {
        GameObject go = gameField[y][x];
        // В методе openTile(int, int) элементу матрицы gameField
        // должно устанавливаться значение поля isOpen, равное true,
        go.isOpen = true;
        // и отрисовываться фон ячейки с помощью метода setCellColor(int, int, Color).
        // Например, в Color.GREEN.
        setCellColor(x, y, Color.GREEN);
        // Метод openTile(int, int) должен отрисовывать MINE,
        // если gameObject по текущим координатам является миной.
        // Используй метод setCellValue(int, int, String).
        if (go.isMine) {
            setCellValue(x, y, this.MINE);
            setCellColor(x, y, Color.RED);
        } else {
            // В методе openTile(int, int), если элемент не является миной и
            // количество соседей-мин равно нулю,для каждого не открытого соседа
            // должен рекурсивно вызываться метод openTile(int, int).
            if (go.countMineNeighbors == 0) {
                // При открытии ячейки с нулевым количеством "заминированных" соседей
                // нам нужно сделать полный перебор всех закрытых соседних ячеек,
                // вызвать у них метод openTile(int, int) и повторить процесс.
                // Метод openTile(int, int) должен вызывать метод getNeighbors(GameObject),
                // если элемент не является миной и количество соседей-мин равно нулю.
                List<GameObject> gameObjectList = getNeighbors(go);
                for (GameObject g : gameObjectList) {
                    if (!g.isOpen) {
                        //  В методе openTile(int, int), если элемент не является миной
                        //  и количество соседей-мин равно нулю,
                        //  для каждого не открытого соседа должен рекурсивно
                        //  вызываться метод openTile(int, int).
                        openTile(g.x, g.y);
                    }
                }
                // Метод openTile(int, int) не должен ничего выводить,
                // если элемент не является миной и количество соседей мин равно нулю.
                // Используй пустую строку.
                setCellValue(x, y, "");
            } else {
                //В методе openTile(int, int), если элемент не является миной
                // и количество соседей мин не равняется нулю, на игровое
                // поле должно выводиться количество заминированных соседей.
                // Используй метод setCellNumber(int, int, int).
                // Метод openTile(int, int) должен отрисовывать количество соседей-мин,
                // если gameObject по текущим координатам не является миной.
                // Используй метод setCellNumber(int, int, int).
                setCellNumber(x, y, go.countMineNeighbors);
            }
        }
    }

    private void markTile(int x, int y) {
        GameObject gameObject = this.gameField[y][x];
        // Метод markTile(int x, int y) не должен ничего делать,
        // если элемент уже открыт (isOpen == true).
        // Метод markTile(int, int) не должен ничего делать,
        // если количество неиспользованных флагов countFlags равно нулю,
        // и текущий элемент — не флаг (isFlag = false).
        if (!gameObject.isOpen && this.countFlags != 0 && !gameObject.isFlag) {
            // Метод markTile(int, int) должен устанавливать значение поля isFlag в true,
            gameObject.isFlag = true;
            // уменьшать количество неиспользованных флагов на единицу,
            this.countFlags--;
            // отрисовывать на поле знак FLAG, если текущий элемент — не флаг
            // (используй метод setCellValue(int, int, String))
            setCellValue(x, y, this.FLAG);
            // и менять фон ячейки на поле, используя метод setCellColor(int, int, Color).
            // Например, в Color.YELLOW.
            setCellColor(x, y, Color.YELLOW);
        } else if (gameObject.isFlag) {
            // Метод markTile(int, int) должен устанавливать значение поля isFlag в false,
            gameObject.isFlag = false;
            // увеличивать количество неиспользованных флагов на единицу,
            this.countFlags++;
            // отрисовывать на поле пустую ячейку, если текущий элемент — флаг
            // (используй метод setCellValue(int, int, String))
            setCellValue(x, y, "");
            // и возвращать исходный цвет ячейки (используй метод setCellColor(int, int, Color)).
            setCellColor(x, y, Color.ORANGE);
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        //super.onMouseLeftClick(x, y);
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}