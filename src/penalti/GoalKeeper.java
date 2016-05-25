/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penalti;

import penalti.Point.point;

/**
 *
 * @author pauloapanucci
 */
public class GoalKeeper extends Player{

    public GoalKeeper(String name, int quality, int trust) {
        super(name, quality, trust);
    }
    
    public boolean keep(point pt){
         boolean sucess;
         sucess = pt.miss();
         return sucess;
    }
}
