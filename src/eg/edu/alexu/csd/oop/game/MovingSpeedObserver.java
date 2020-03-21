/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;
/**
 *
 * @author ECC1
 */

public class MovingSpeedObserver extends Observer{
    public MovingSpeedObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      
      GameWorld.speed -= subject.getState()/5;
       if(GameWorld.speed<0)
           GameWorld.speed = 0;
   }
}
