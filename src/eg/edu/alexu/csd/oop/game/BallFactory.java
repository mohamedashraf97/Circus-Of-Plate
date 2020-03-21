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
public class BallFactory {
      public  String paths[]={"/ball1.png","/ball2.png", "/ball3.png"};
        public  Color color[]={Color.BLUE,Color.GREEN,Color.RED};
        Random r = new Random();
        flyweight ran=new flyweight();
        private static BallFactory BF = null;

 
        private BallFactory() {
     
        }
 
    public static BallFactory getInstance(){
        if (BF==null){
            BF = new BallFactory();
        return BF;}
        else
         return BF;
    }
     public void addBall(int width, List moving) {
     int rand;
            
            rand=ran.getrandomcolor();
            moving.add(new BallObject(10, 10,r.nextInt(width), paths[rand],color[rand], 0));
            rand=ran.getrandomcolor();
            moving.add(new BallObject(width-20, 10,r.nextInt(width), paths[rand],color[rand], 1));
             rand=ran.getrandomcolor();
            moving.add(new BallObject(10, 70,r.nextInt(width), paths[rand],color[rand], 4));
          rand=ran.getrandomcolor();
            moving.add(new BallObject(width-20, 70,r.nextInt(width), paths[rand],color[rand], 5));        
}
}
