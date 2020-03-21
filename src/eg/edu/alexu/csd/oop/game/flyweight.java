/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class flyweight {
    Random r=new Random();
    public int getrandomcolor(){
        return r.nextInt(3);
    }
            
}
