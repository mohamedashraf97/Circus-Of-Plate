/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ShapeFactory {
    PlateFactory plateFactory = new PlateFactory();
    BallFactory ballFactory = BallFactory.getInstance();
    DynamicFactory dynamicFactory = new DynamicFactory();
    public void addShape(String shape,int width,List moving) throws FileNotFoundException
    {
        if(shape.equalsIgnoreCase("plate"))
        {
            plateFactory.addPlate(width,moving);
                }
        else if(shape.equalsIgnoreCase("ball"))
            ballFactory.addBall(width, moving);
        else if(shape.equalsIgnoreCase("object"))
            dynamicFactory.addObject(width, moving);
    }
}
