/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.io.FileNotFoundException;

/**
 *
 * @author Dell
 */
public class Project3 {

    /**
     * @param args the command line arguments
     */
     static GameEngine.GameController g;
    public static void main(String[] args) throws FileNotFoundException {
      g = GameEngine.start("Circus of Plates", new GameWorld(1280, 690));
       
    }
    
}
