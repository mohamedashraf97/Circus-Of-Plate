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
public class StartState implements State{
 Context level1 = new Context(new Level1());
    Context level2 = new Context(new Level2());
    Context level3 = new Context(new Level3());
    @Override
    public void doAction(List<GameObject> control, Shape p, int time, StateContext context) {
        level1.executeStrategy(control, p, time);
        level2.executeStrategy(control, p, time);
        level3.executeStrategy(control, p, time);
        context.setState(this);
    }
 
}
