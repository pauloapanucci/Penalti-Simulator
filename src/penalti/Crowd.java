/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penalti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pauloapanucci
 */
public class Crowd {
    private List<Fan> crowd = new ArrayList<>();
    private static Random rand = new Random();
    
    public int randNum(){
        
        return rand.nextInt(3 - 0) + 0;
    }

    public Crowd() {
        for(int i = 0; i < 20; i++){
            Fan f = new Fan();
            crowd.add(i, f);
        }
        
    }
    
    public int getCrowdSize(){
        return  crowd.size();
    }
    
    public int applaud(){
        int sum = 0;
        int size = crowd.size();
        for(int i = 0; i < size; i++){
            sum += crowd.get(i).support();
        }
        return sum/size;
    }
    
    public int boo(){
        int sum = 0;
        int size = crowd.size();
        for(int i = 0; i < size; i++){
            sum += crowd.get(i).callNames();
        }
        return sum/size;
    }
    
    public String supportPhrases(){
        String phrases[] = {"VAI TIME!", "VAMOS GANHAR!", "É TETRAAAAAAAAAA"};
        return phrases[randNum()];
    }
    
    public String booPhrases(){
        String phrases[] = {"E NINGUÉM CALA ESSE CHORORO!", "TIME RUIMMMMMM!", "SUA CAMISA VAI VIRAR PANO DE CHÃO"};
        return phrases[randNum()];
    }
}
