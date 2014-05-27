/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game2048;

import java.awt.Color;

/**
 *
 * @author kevin.lawrence
 */
public class DataTable {
    private int[][] data;
    
    public DataTable(int rows, int columns){
        data = new int[rows][columns];
        
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                data[row][column] = 0;
            }
        }
    }

    
    public int getRows(){
        return data.length;
    }
    
    public int getColumns(){
        return data[0].length;
    }
    
    
    /**
     * @return the data
     */
    public int getData(int row, int column) {
        return data[row][column];
    }

    /**
     * @param data the data to set
     */
    public void setData(int row, int column, int value) {
        data[row][column] = value;
    }
    
    /**
     * @return the data
     */
    public int[][] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int[][] data) {
        this.data = data;
    }

    void setColor(Color BLACK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
