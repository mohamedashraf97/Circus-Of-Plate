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
public interface State {
    public void doAction(List<GameObject> control,Shape p,int time,StateContext context);
}
