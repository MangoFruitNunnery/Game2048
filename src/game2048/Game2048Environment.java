/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import environment.Environment;
import java.awt.Color;
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
    
    @Override
    public void initializeEnvironment() {
        this.grid = new MathGrid();
        grid.setCellHeight(100);
        grid.setCellWidth(100);
        grid.setColumns(4);
        grid.setRows(4);
        grid.setPosition(new Point(100,100));
        grid.setColor(Color.pink);
        
        this.setBackground(Color.BLACK);
    }

    @Override
    public void timerTaskHandler() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }
    }
    
}
