/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ECC1
 */
public class DynamicFactory {
    public  String paths[];
        public  Color color[];
        flyweight ran=new flyweight();
        Random r=new Random();
        DynamicLinkageInt dl=new DynamicLinkage();
    public void addObject(int width, List moving) throws FileNotFoundException {
         paths=dl.getPaths();
         color=dl.getColor();
       int rand;
             rand=ran.getrandomcolor();
            moving.add(new DynamicObject(10, 10,r.nextInt(width), paths[rand],color[rand], 0));
            rand=ran.getrandomcolor();
            moving.add(new DynamicObject(width-20, 10,r.nextInt(width), paths[rand],color[rand], 1));
            rand=ran.getrandomcolor();
            moving.add(new DynamicObject(10, 70,r.nextInt(width), paths[rand],color[rand], 4));
            rand=ran.getrandomcolor();
            moving.add(new DynamicObject(width-20, 70,r.nextInt(width), paths[rand],color[rand], 5));        
}
}

