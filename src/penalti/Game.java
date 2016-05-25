/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penalti;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pauloapanucci
 */
public class Game {
    
    private static Random rand = new Random();
    //private int n = 0;
    //private String str = " ";
    private Scanner input = new Scanner(System.in);
    
    public void teamStuff(Team casa, Team visitante, Cast kickerCast, Cast keeperCast){
        String str = " ";
        int n = 0;
        System.out.println("Nome dos times");
        System.out.println("1) Escolher o nome do seu time");
        System.out.println("2) Manter nome padrão (Casa)");
        boolean flag = true;
        while(flag){
            n = input.nextInt();
            if(n < 1 || n > 2)
                System.out.println("Opção indisponível, digite novamente (1 a 2)");
            else
                flag = false;
        }

        if(n == 1){
            System.out.println("Digite o nome do seu time");
            str = input.next();
            casa.setName(str);
        }

        System.out.println("1) Escolher o nome do time adversário");
        System.out.println("2) Manter nome padrão (Visitante)");
        flag = true;
        while(flag){
            n = input.nextInt();
            if(n < 1 || n > 2)
                System.out.println("Opção indisponível, digite novamente (1 a 2)");
            else
                flag = false;
        }

        if(n == 1){
            System.out.println("Digite o nome do time adversário");
            str = input.next();
            visitante.setName(str);
        }

        System.out.println("Modo de montagem de times");
        System.out.println("1) Escolha seu time");
        System.out.println("2) Random");

        flag = true;
        while(flag){
            n = input.nextInt();
            if(n < 1 || n > 2)
                System.out.println("Opção indisponível, digite novamente (1 a 2)");
            else
                flag = false;
        }

        if(n == 1){
            System.out.println("Digite o goleiro a ser adicionados ao seu time");
            flag = true;
            while(flag){
                n = input.nextInt();
                if(n < 1 || n >= keeperCast.getCastSize())
                    System.out.println("Goleiro indisponível, digite novamente");
                else{
                    casa.insertPlayer(keeperCast.getPlayerFromCast(n - 1));
                    keeperCast.removeCastByIndex(n - 1);
                    flag = false;
                }
            }


            System.out.println("Digite os batedores a serem adicionados ao seu time");
            //int removerjogadores[] = new int[5];
            for(int i = 0; i < 5; i++){
                flag = true;
                while(flag){
                    n = input.nextInt();
                    if(n < 1 || n >= kickerCast.getCastSize())
                        System.out.println("Jogador indisponível, digite novamente");
                    else{
                        casa.insertPlayer(kickerCast.getPlayerFromCast(n - 1));
                        flag = false;
                    }
                }
            }

            for(int i = 1; i <= 5; i++){ // remove os jogadores já escolhidos do elenco para não se repetirem no time adversário
                kickerCast.removeCastByObject(casa.getPlayer(i));
            }

            visitante.insertPlayer(keeperCast.getPlayerFromCast(rand.nextInt(keeperCast.getCastSize()))); // Escolha do time visitante aleatória
            for (int i = 0; i < 5; i++){
                int r = rand.nextInt(kickerCast.getCastSize());
                visitante.insertPlayer(kickerCast.getPlayerFromCast(r));
                kickerCast.removeCastByIndex(r);
            }

        }

        else{ // Escolha aleatória dos dois times
            Integer[] goalkeepers = new Integer[keeperCast.getCastSize()];
            for(int i = 0; i < keeperCast.getCastSize(); i++){
                goalkeepers[i] = i;
            }

            Integer[] kickers = new Integer[kickerCast.getCastSize()];
            for(int i = 0; i < kickerCast.getCastSize(); i++){
                kickers[i] = i;
            }

            Collections.shuffle(Arrays.asList(kickers));
            Collections.shuffle(Arrays.asList(goalkeepers));

            casa.insertPlayer(keeperCast.getPlayerFromCast(goalkeepers[0]));
            for (int i = 0; i < 5; i++){
                casa.insertPlayer(kickerCast.getPlayerFromCast(kickers[i]));
            }

            visitante.insertPlayer(keeperCast.getPlayerFromCast(goalkeepers[1]));
            for (int i = 5; i < 10; i++){
                visitante.insertPlayer(kickerCast.getPlayerFromCast(kickers[i]));
            }
        }

        System.out.println();
        casa.printTeam();
        System.out.println();
        visitante.printTeam();
        System.out.println();
    }
    
    public void play(Team casa, Team visitante, Crowd torcidaCasa, Crowd torcidaVisitante){
        int n = 0;
        int scoreCasa = 0; // inicialização dos placares
        int scoreVisitante = 0;

        System.out.println("Começaaaa o jogo!");
        System.out.println();

        boolean missCasa, missVisitante, vezCasa = true, vezVisitante = true;
        Point.point pt1, pt2; // receberá os pontos dos jogadores durante o jogo
        int i = 1, contadorRodadas = 1, vez1, vez2; // vez1 e vez2 controla quem baterá primeiro conforme o modo selecionado
        boolean partida = true;

        System.out.println("Modo:");
        System.out.println("1) Você começar batendo");
        System.out.println("2) Adversário começar batendo");
        System.out.println("3) Random");
        boolean flag = true;
        while(flag){
            n = input.nextInt();
            if(n < 1 || n > 3)
                System.out.println("Opção indisponível, digite novamente (1 a 3)");
            else
                flag = false;
        }
        if(n == 3)
        n = rand.nextInt(2 - 1 + 1) + 1;

        while(partida){
   
            vez1 = 0; vez2 = 0;
            if(n == 1){ // neste caso segue a sequencia normal dos batedores
                vezCasa = true; 
                vezVisitante = true;
            }
            if(n == 2){ // o time visitante começa batendo
                vezCasa = false; vezVisitante = true;
            }

            while(vez1 != 1 || vez2 != 1){
                // Vez da casa bater

                if(vezCasa == true){

                    System.out.println("\n" + casa.getName() + " " + scoreCasa + " " +  " X " + scoreVisitante + " " + visitante.getName());
                    System.out.println("Rodada " + contadorRodadas);
 
                    casa.getPlayer(i).updateProfile(torcidaCasa.applaud(), torcidaVisitante.boo());
                    visitante.getPlayer(0).updateProfile(torcidaVisitante.applaud(), torcidaCasa.boo());

                    System.out.println("Batedor da vez: " + casa.getPlayer(i).getName() + "(" + casa.getName() + ")" + " Qualidade: " + casa.getPlayer(i).getProfile().getQuality() + " Confiança: " + casa.getPlayer(i).getProfile().getTrust());
                    System.out.println("Goleiro da vez: " + visitante.getPlayer(0).getName() + "(" + visitante.getName() + ")" + " Qualidade: " + visitante.getPlayer(0).getProfile().getQuality() + " Confiança: " + visitante.getPlayer(0).getProfile().getTrust());

                    pt1 = casa.getPlayer(i).direct();
                    missCasa = ((Kicker)casa.getPlayer(i)).kick(pt1);

                    pt2 = Point.point.values()[rand.nextInt(6)]; 
                    missVisitante = ((GoalKeeper)visitante.getPlayer(0)).keep(pt2);

                    System.out.println("O batedor escolheu o canto " + pt1 + " e o goleiro escolheu o canto " + pt2);

                    if(pt1 != pt2){
                        if(missCasa == false){
                            System.out.println("GOOOOOOOOL DO " + casa.getPlayer(i).getName());
                            scoreCasa++;
                        }
                        else{
                            System.out.println("O " + casa.getPlayer(i).getName() + " CHUTA PRA FORAAAA");
                        }
                    }
                    else if(missVisitante == false && missCasa == false){
                        if(casa.getPlayer(i).getProfile().getQuality() > visitante.getPlayer(0).getProfile().getQuality()){
                            System.out.println("GOOOOOOOOL DO " + casa.getPlayer(i).getName());
                            scoreCasa++;
                        }
                        else{
                            System.out.println("BELA DEFESA DO " + visitante.getPlayer(0).getName());
                        }
                    }
                    else if(missVisitante == false && missCasa == true)
                        System.out.println("BELA DEFESA DO " + visitante.getPlayer(0).getName());
                    else if(missVisitante == true && missCasa == false){
                        System.out.println("GOOOOOOOOL DO " + casa.getPlayer(i).getName());
                        scoreCasa++;
                    }
                    else
                        System.out.println("O " + casa.getPlayer(i).getName() + " CHUTA PRA FORAAAA");
                    
                    System.out.println("Torcida " + casa.getName() + ": " + torcidaCasa.supportPhrases());
                    System.out.println("Torcida " + visitante.getName() + ": " + torcidaVisitante.booPhrases());
                    
                    vez1 = 1;
                }

                //Vez do visitante bater

                if(vezVisitante == true){

                    System.out.println("\n" + casa.getName() + " " + scoreCasa + " " +  " X " + scoreVisitante + " " + visitante.getName());
                    System.out.println("Rodada " + contadorRodadas);

                    casa.getPlayer(0).updateProfile(torcidaCasa.applaud(), torcidaVisitante.boo());
                    visitante.getPlayer(i).updateProfile(torcidaVisitante.applaud(), torcidaCasa.boo());

                    System.out.println("Batedor da vez: " + visitante.getPlayer(i).getName() + "(" + visitante.getName() + ")" + " Qualidade: " + visitante.getPlayer(i).getProfile().getQuality() + " Confiança: " + visitante.getPlayer(i).getProfile().getTrust());
                    System.out.println("Goleiro da vez: " + casa.getPlayer(0).getName() + "(" + casa.getName() + ")" + " Qualidade: " + casa.getPlayer(0).getProfile().getQuality() + " Confiança: " + casa.getPlayer(0).getProfile().getTrust());

                    pt1 = casa.getPlayer(0).direct();
                    missCasa = ((GoalKeeper)casa.getPlayer(0)).keep(pt1);

                    pt2 = Point.point.values()[rand.nextInt(6)];
                    missVisitante = ((Kicker)visitante.getPlayer(i)).kick(pt2);

                    System.out.println("O batedor escolheu o canto " + pt2 + " e o goleiro escolheu o canto " + pt1);

                    if(pt1 != pt2){
                        if(missCasa == false){
                            System.out.println("GOOOOOOOOL DO " + visitante.getPlayer(i).getName());
                            scoreVisitante++;
                        }
                        else{
                            System.out.println("O " + visitante.getPlayer(i).getName() + " CHUTA PRA FORAAAA");
                        }
                    }
                    else if(missVisitante == false && missCasa == false){
                        if(visitante.getPlayer(i).getProfile().getQuality() > casa.getPlayer(0).getProfile().getQuality()){
                            System.out.println("GOOOOOOOOL DO " + visitante.getPlayer(i).getName());
                            scoreVisitante++;
                        }
                        else{
                            System.out.println("BELA DEFESA DO " + casa.getPlayer(0).getName());
                        }
                    }
                    else if(missVisitante == false && missCasa == true)
                        System.out.println("GOOOOOOOOL DO " + visitante.getPlayer(0).getName());
                    else if(missVisitante == true && missCasa == false){
                        System.out.println("GOOOOOOOOL DO " + visitante.getPlayer(i).getName());
                        scoreVisitante++;
                    }
                    else
                        System.out.println("O " + visitante.getPlayer(i).getName() + " CHUTA PRA FORAAAA");
                    
                    System.out.println("Torcida " + casa.getName() + ": " + torcidaCasa.booPhrases());
                    System.out.println("Torcida " + visitante.getName() + ": " + torcidaVisitante.supportPhrases());
                    
                    vez2 = 1;
                }
                if(vez1 == 0 && vez2 == 1){
                    vezCasa = true;
                    vezVisitante = false;
                } 
            }

            contadorRodadas++;
            i++;
            if(contadorRodadas > 5 && scoreCasa == scoreVisitante){
                i = 1;
            }
            else if(contadorRodadas > 5 && scoreCasa != scoreVisitante){
                partida = false;
            }
        }

        System.out.println();
        System.out.println("PLACAR FINAL");
        System.out.println(casa.getName() + " " + scoreCasa + " " +  " X " + scoreVisitante + " " + visitante.getName() + "\n");
    }
    
}
