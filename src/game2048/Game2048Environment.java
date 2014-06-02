/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import environment.Direction;
import environment.Environment;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Tom Le
 */
public class Game2048Environment extends Environment {

    private MathGrid grid;
    private DataTable dataTable;
    private int score = 0;
    private Number number;
    private int moveCounter;

    @Override
    public void initializeEnvironment() {
        int rows = 4;
        int columns = 4;

        dataTable = new DataTable(rows, columns);
        dataTable.setData(0, 2, 2);
        dataTable.setData(3, 3, 2);

        grid = new MathGrid();
        grid.setCellHeight(100);
        grid.setCellWidth(100);
        grid.setRows(rows);
        grid.setColumns(columns);
        grid.setPosition(new Point(60, 175));
        grid.setColor(Color.PINK);
        grid.setDataTable(dataTable);

        this.setBackground(Color.WHITE);
    }

    @Override
    public void timerTaskHandler() {
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            addToScore(30);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (shiftCells(Direction.UP)) {
                fillRandomEmptyCell();
            } else {
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (shiftCells(Direction.LEFT)) {
                fillRandomEmptyCell();
            } else {
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            fillRandomEmptyCell();
        }
    }

    public static int EMPTY_CELL = 0;
    
    private boolean shiftCells(Direction direction) {
        boolean shiftSuccess = false;


        if (direction == Direction.LEFT) {
            for (int col = 1; col < this.dataTable.getColumns(); col++) {
                for (int row = 0; row < this.dataTable.getRows(); row++) {
                    //check if there a non-zero value that could be shifted!
                    if (dataTable.getData(row, col) != 0) {
                        //look for the first (leftmost) empty space that I can move to
                        for (int targetColumn = 0; targetColumn < col; targetColumn++) {
                            if (dataTable.getData(row, targetColumn) == 0) {
                                // found empty space -> move the data value,and empty the old space
                                dataTable.getData()[row][targetColumn] = dataTable.getData()[row][col];
                                dataTable.getData()[row][col] = 0;

                                shiftSuccess = true;
                            }

                            // check for merge: can the new space be merge with a cell immediately left of it?
                            if (targetColumn >= 1) {
                                if (dataTable.getData()[row][targetColumn] == dataTable.getData()[row][targetColumn - 1]) {
                                    //merge the two values, then empty the last space
                                    dataTable.getData()[row][targetColumn - 1] *= 2;
                                    //increment the score
                                    this.addToScore(dataTable.getData()[row][targetColumn - 1]);
                                    //empty the old value
                                    dataTable.getData()[row][targetColumn] = 0;
                                }
                            }

                        }
                    }
                }

            }
        }

        //to be completed by the one, the only: tu le
        if (direction == Direction.UP) {
            System.out.println("UP");
            for (int col = 0; col < this.dataTable.getColumns(); col++) {
                for (int row = 1; row < this.dataTable.getRows(); row++) {
                    //check if there a non-zero value that could be shifted!
                    if (dataTable.getData(row, col) != EMPTY_CELL) {
                        //look for the first (leftmost) empty space that I can move to
                        for (int targetRow = 0; targetRow < row - 1; targetRow++) {
                            if (dataTable.getData(targetRow, col) == EMPTY_CELL) {
                                // found empty space -> move the data value,and empty the old space
                                dataTable.getData()[targetRow][col] = dataTable.getData()[row][col];
                                dataTable.getData()[row][col] = EMPTY_CELL;

                                shiftSuccess = true;
                            }

                            // check for merge: can the new space be merge with a cell immediately left of it?
                            if (targetRow >= 1) {
                                if (dataTable.getData()[targetRow][col] == dataTable.getData()[targetRow - 1][col]) {
                                    //merge the two values, then empty the last space
                                    dataTable.getData()[targetRow - 1][col] *= 2;
                                    //increment the score
                                    this.addToScore(dataTable.getData()[targetRow - 1][col]);
                                    //empty the old value
                                    dataTable.getData()[targetRow][col] = 0;
                                }
                            }

                        }
                    }
                }

            }
        }

        return shiftSuccess;
    }

    private void fillRandomEmptyCell() {
        if (Math.random() >= 0.75) {
            grid.fillRandomEmptyCell(4);
        } else {
            grid.fillRandomEmptyCell(2);
        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.setColor(Color.PINK);
        graphics.setFont(new Font("ComicSansMS", Font.CENTER_BASELINE, 100));
        graphics.drawString("2048", 150, 150);

        graphics.setColor(Color.PINK);
        graphics.setFont(new Font("ComicSansMS", Font.CENTER_BASELINE, 50));
        graphics.drawString("Score: " + this.score, 100, 50);

        this.grid.paintComponent(graphics);
    }

    private void checkGame2048Intersection() {
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @param score the score to add to current score
     */
    public void addToScore(int score) {
        this.score += score;
    }
}