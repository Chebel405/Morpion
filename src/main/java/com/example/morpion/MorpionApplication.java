package com.example.morpion;

import com.example.game.Player;
import com.example.game.TicTacToe;
import org.springframework.boot.SpringApplication;
import org.springframework.util.SystemPropertyUtils;

import java.util.Scanner;


public class MorpionApplication {

    public static void main(String[] args) {
        //Entrées utilisateur dans la console
       final var scanner = new Scanner(System.in);
       final var game = new TicTacToe();

       var player = Player.FIRST;

       while(true){
           System.out.println(game);
           System.out.println(player + " / Saisissez un nombre entre 1 et 9 : ");
           final var inputUser = scanner.nextInt();

           game.processInput(player, inputUser);
           //Verifier si les conditions sont remplies
           if(game.checkWin()){
               System.out.println("Le joueur " + player + " a gagné. ");
               // Appel à l'affichage du jeu terminé
               System.out.println(game);
               break;
           }
           player = nextPlayer(player);
       }
    }

    private static Player nextPlayer(Player player) {
        if(player == player.FIRST) {
            return Player.SECOND;
        }else {
            return Player.FIRST;
        }

    }

}
