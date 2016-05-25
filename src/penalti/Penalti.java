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
public class Penalti {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean jogar = true;
        
        while(jogar){
        
            Scanner input = new Scanner(System.in);
            int n = 0;

            Cast kickerCast = new Cast(); // Elenco de batedores disponíveis
            Cast keeperCast = new Cast(); // Elenco de goleiros disponíveis

            Kicker kicker1 = new Kicker("Didico", 10, 7);
            Kicker kicker2 = new Kicker("Fofomeno", 10, 8); 
            Kicker kicker3 = new Kicker("Chulapa", 10, 7);
            Kicker kicker4 = new Kicker("Wendel Lira", 7, 5);
            Kicker kicker5 = new Kicker("Marcinho", 4, 3);
            Kicker kicker6 = new Kicker("Ronaldinho Gaucho", 10, 10);
            Kicker kicker7 = new Kicker("Romário", 8, 6);
            Kicker kicker8 = new Kicker("Vampeta", 5, 5);
            Kicker kicker9 = new Kicker("Deus Baier", 9, 7);
            Kicker kicker10 = new Kicker("Allejo", 10, 10);
            Kicker kicker11 = new Kicker("Beranco", 9, 9);
            Kicker kicker12 = new Kicker("Renight", 8, 9);
            Kicker kicker13 = new Kicker("Batistuta", 9, 7);
            Kicker kicker14 = new Kicker("Baggio", 9, 7);
            Kicker kicker15 = new Kicker("Marajo", 2, 10);
            Kicker kicker16 = new Kicker("Val Negao", 5, 7);
            Kicker kicker17 = new Kicker("Amaral", 6, 8);
            Kicker kicker18 = new Kicker("Berola", 7, 7);
            Kicker kicker19 = new Kicker("Carlinhos Bala", 7, 6);
            Kicker kicker20 = new Kicker("Fabigol", 10, 2);
            
            GoalKeeper keeper1 = new GoalKeeper("São Marcos", 10, 10);
            GoalKeeper keeper2 = new GoalKeeper("Alfácio", 5, 3);
            GoalKeeper keeper3 = new GoalKeeper("Gomez", 7, 8);
            GoalKeeper keeper4 = new GoalKeeper("Felix", 7, 10);
            GoalKeeper keeper5 = new GoalKeeper("Kahn", 9, 9);
            GoalKeeper keeper6 = new GoalKeeper("Cech", 8, 8);
            

            Team casa = new Team("Casa");
            Team visitante = new Team("Visitante");

            Crowd torcidaCasa = new Crowd();
            Crowd torcidaVisitante = new Crowd();

            kickerCast.insertCast(kicker1);
            kickerCast.insertCast(kicker2);
            kickerCast.insertCast(kicker3);
            kickerCast.insertCast(kicker4);
            kickerCast.insertCast(kicker5);
            kickerCast.insertCast(kicker6);
            kickerCast.insertCast(kicker7);
            kickerCast.insertCast(kicker8);
            kickerCast.insertCast(kicker9);
            kickerCast.insertCast(kicker10);
            kickerCast.insertCast(kicker11);
            kickerCast.insertCast(kicker12);
            kickerCast.insertCast(kicker13);
            kickerCast.insertCast(kicker14);
            kickerCast.insertCast(kicker15);
            kickerCast.insertCast(kicker16);
            kickerCast.insertCast(kicker17);
            kickerCast.insertCast(kicker18);
            kickerCast.insertCast(kicker19);
            kickerCast.insertCast(kicker20);
            
            keeperCast.insertCast(keeper1);
            keeperCast.insertCast(keeper2);
            keeperCast.insertCast(keeper3);
            keeperCast.insertCast(keeper4);
            keeperCast.insertCast(keeper5);
            keeperCast.insertCast(keeper6);

            keeperCast.printCast();
            System.out.println();
            kickerCast.printCast();
            System.out.println();
           
            Game jogo = new Game();
            
            jogo.teamStuff(casa, visitante, kickerCast, keeperCast);
            jogo.play(casa, visitante, torcidaCasa, torcidaVisitante);
            
            System.out.println("Deseja jogar novamente?");
            System.out.println("1) Sim"); 
            System.out.println("2) Não");
            boolean flag = true;
            while(flag){
                n = input.nextInt();
                if(n < 1 || n > 2)
                    System.out.println("Opção indisponível, digite novamente (1 a 2)");
                else flag = false;
            } 
            if(n == 2) jogar = false;
        }        
    }
    
}
