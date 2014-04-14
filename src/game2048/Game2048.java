/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import environment.ApplicationStarter;

/**
 *
 * @author Tom Le
 */
public class Game2048 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
    }
    private static void start(){
        ApplicationStarter.run("2048", new Game2048Environment());
    }
}
