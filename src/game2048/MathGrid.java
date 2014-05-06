/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import grid.Grid;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Tom Le
 */
public class MathGrid extends Grid {

    private DataTable dataTable;

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        //do our new stuff here
        if (dataTable != null) {
            for (int row = 0; row < dataTable.getRows(); row++) {
                for (int column = 0; column < dataTable.getColumns(); column++) {
                    if (dataTable.getData(row, column) != 0) {
                        //draw block
                        graphics.setColor(Color.GRAY);
                        graphics.fillRect(this.getCellSystemCoordinate(column, row).x + 2, this.getCellSystemCoordinate(column, row).y + 2, this.getCellWidth() - 4, this.getCellHeight() - 4);
                        
                        //draw value
                        graphics.setColor(Color.BLACK);
                        graphics.setFont(new Font("Tahoma",Font.BOLD, 32));
                        graphics.drawString(String.valueOf(dataTable.getData(row, column)), this.getCellSystemCoordinate(column, row).x + (this.getCellWidth() / 4) , this.getCellSystemCoordinate(column, row).y + (this.getCellHeight() * 2 / 3));
                        
                        
                    }
                }
            }
        }
    }

    /**
     * @return the dataTable
     */
    public DataTable getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
}
