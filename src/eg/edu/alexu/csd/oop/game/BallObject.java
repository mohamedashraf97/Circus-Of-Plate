/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;

/**
 *
 * @author Dell
 */
public class BallObject  extends Shape{
    public BallObject(int posX, int posY,int end, String path,Color color,int type)
    {
        super(posX,posY,end, path,color,type);
    }
}
