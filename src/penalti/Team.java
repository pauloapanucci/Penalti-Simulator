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
public class Team {
    private String name;
    private List<Player> team = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getTeamSize(){
        return team.size();
    }
    
    public Player getPlayer(int p){
        return team.get(p);
    }
    
    public void insertPlayer(Player player){
        team.add(player);
    }
    
    public void printTeam(){
        System.out.println(name);
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getName() + " (" + team.get(i).getProfile().getQuality() + "|" + team.get(i).getProfile().getTrust() + ")");
        }
    }
}
