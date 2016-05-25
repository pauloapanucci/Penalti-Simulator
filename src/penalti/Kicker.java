/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penalti;

/**
 *
 * @author pauloapanucci
 */
public class Kicker extends Player {

    public Kicker(String name, int quality, int trust) {
        super(name, quality, trust);
    }
    
    
    
    public boolean kick(Point.point pt){
        boolean sucess;
        sucess = pt.miss();
        return sucess;
    }
}
