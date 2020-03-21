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
public class ControlSpeedObserver extends Observer{
    public ControlSpeedObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      GameWorld.controlSpeed += (subject.getState()/5)*2;
       if(GameWorld.controlSpeed>50)
           GameWorld.controlSpeed = 50;
    
   }
}
