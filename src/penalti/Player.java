/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penalti;

import java.util.Scanner;

/**
 *
 * @author pauloapanucci
 */
public abstract class Player {
    private String name;
    private Profile profile = new Profile();
    
    

    public Player(String name, int quality, int trust) {
        this.name = name;
        this.profile.setQuality(quality);
        this.profile.setTrust(trust);
    }  
    
    public Point.point direct(){
        int x = 0;
        Scanner input = new Scanner(System.in);
        if(this instanceof Kicker)
            System.out.println("Direção a chutar: ");
        else
            System.out.println("Direção a defender: ");
        System.out.println("\t1) Esquerda Cima ");
        System.out.println("\t2) Esquerda Baixo ");
        System.out.println("\t3) Direita Cima ");
        System.out.println("\t4) Direita Baixo ");
        System.out.println("\t5) Meio Cima ");
        System.out.println("\t6) Meio Baixo ");
        boolean flag = true;
        while(flag){
            x = input.nextInt();
            if(x < 1 || x > 6)
                System.out.println("Direção inválida, digite novamente (1 a 6)");
            else
                flag = false;
        }
        return Point.point.values()[x - 1];
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }
    
    public void updateProfile(int applaud, int boo){
        int qualidade = this.getProfile().getQuality();
        int confianca = this.getProfile().getTrust();
        confianca = confianca + (confianca * ((applaud - boo)/10));
        this.getProfile().setQuality(qualidade + confianca);
    }
      
}
