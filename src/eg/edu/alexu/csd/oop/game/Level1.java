/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.util.List;

/**
 *
 * @author ECC1
 */
public class Level1 implements Strategy {

    @Override
    public void checkLevel(List<GameObject> control,Shape p,int time) {
        
    
    if(time<=30)
         switch (p.getType()) {
              case 0:
              case 4:
                  if (p.getX() >= p.getEnd()) {
                      p.setY(p.getY() + 2);
                  } else {
                      p.setX(p.getX() + 2);
                  } break;
              case 1: 
              case 5:
                  if (p.getX() <= p.getEnd()) {
                      p.setY(p.getY() + 2);
                  } else {
                      p.setX(p.getX() - 2);
                  } break;
              case 3:  
              case 2:
                  p.setX(control.get(1).getX());
                  break;
              default:
                  break;
    }
       
    }
}
