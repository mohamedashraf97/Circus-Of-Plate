/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class PlateFactory {
     public  String paths[]={"/plate1.png","/plate2.png", "/plate3.png"};
        public  Color color[]={Color.BLUE,Color.GREEN,Color.RED};
        flyweight ran=new flyweight();
        Random r=new Random();
     public void addPlate(int width, List moving) {
       int rand;
             rand=ran.getrandomcolor();
            moving.add(new PlateObject(10, 10,r.nextInt(width), paths[rand],color[rand], 0));
            rand=ran.getrandomcolor();
            moving.add(new PlateObject(width-20, 10,r.nextInt(width), paths[rand],color[rand], 1));
            rand=ran.getrandomcolor();
            moving.add(new PlateObject(10, 70,r.nextInt(width), paths[rand],color[rand], 4));
            rand=ran.getrandomcolor();
            moving.add(new PlateObject(width-20, 70,r.nextInt(width), paths[rand],color[rand], 5));        
}
}