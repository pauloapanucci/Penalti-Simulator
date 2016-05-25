/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penalti;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pauloapanucci
 */
public class Cast {
    
    private List<Player> cast = new ArrayList<>();
        
        
    public void insertCast(Player p){
        cast.add(p);
    }
    
    public void removeCastByObject(Player p){
        cast.remove(p);
    }
    
    public void removeCastByIndex(int i){
        cast.remove(i);
    }
    
    public void printCast(){
        if(cast.get(0) instanceof Kicker)    
            System.out.println("BATEDOR \t\t QUALIDADE \t\t CONFIANÇA");
        
        else
            System.out.println("GOLEIRO \t\t QUALIDADE \t\t CONFIANÇA");
        for(int i = 0; i < cast.size(); i++)
            System.out.println(i+1 + ") " + String.format("%-15s \t\t %-10s \t\t %-10s", cast.get(i).getName(), cast.get(i).getProfile().getQuality(), cast.get(i).getProfile().getTrust()));
    }

    public Player getPlayerFromCast(int i){
        return cast.get(i);
    }
    
    public int getCastSize(){
        return cast.size();
    }
    
      
}
