/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penalti;

import java.util.Random;

/**
 *
 * @author pauloapanucci
 */
public class Fan {
    
    private static Random rand = new Random();
    
    public int randNum(){
        
        return rand.nextInt(11 - 0) + 0;
    }
    
    public int support(){
        return randNum();
    }
    
    public int callNames(){
        return randNum();
    } 
}
