/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

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
        dataTable.setData(0, 0, 2);
        dataTable.setData(3, 0, 2);

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
            if (Math.random() >= 0.75) {
                grid.fillRandomEmptyCell(4);
            } else {
                grid.fillRandomEmptyCell(2);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (Math.random() >= 0.75) {
                grid.fillRandomEmptyCell(4);
            } else {
                grid.fillRandomEmptyCell(2);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (Math.random() >= 0.75) {
                grid.fillRandomEmptyCell(4);
            } else {
                grid.fillRandomEmptyCell(2);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (Math.random() >= 0.75) {
                grid.fillRandomEmptyCell(4);
            } else {
                grid.fillRandomEmptyCell(2);
            }
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