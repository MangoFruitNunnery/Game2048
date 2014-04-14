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
    private DataTable dataTable;
    
    @Override
    public void initializeEnvironment() {
        int rows = 4;
        int columns = 4;
        
        dataTable = new DataTable(rows, columns);
        
        dataTable.setData(0, 0, 2);
        dataTable.setData(3, 0, 2048);
        dataTable.setData(2, 2, 64);
        
        grid = new MathGrid();
        grid.setCellHeight(100);
        grid.setCellWidth(100);
        grid.setRows(rows);
        grid.setColumns(columns);
        grid.setPosition(new Point(25, 25));
        grid.setColor(Color.pink);
        grid.setDataTable(dataTable);
        
        
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
