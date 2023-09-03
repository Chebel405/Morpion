package com.example.morpion;

import com.example.exceptions.TicTacToeInvalidInputException;
import com.example.game.Player;
import com.example.game.TicTacToe;
import org.springframework.boot.SpringApplication;
import org.springframework.util.SystemPropertyUtils;

import java.util.Scanner;


public class MorpionApplication {

    public static void main(String[] args) {

       final var game = new TicTacToe();

       var player = Player.FIRST;

       while(true){
           try{
               System.out.println(game);
               System.out.println(player + " / Saisissez un nombre entre 1 et 9 : ");
               final var inputUser = getInputUser();

               game.processInput(player, inputUser);
               //Verifier si les conditions sont remplies
               if(game.checkWin()){
                   System.out.println("Le joueur " + player + " a gagné. ");
                   // Appel à l'affichage du jeu terminé
                   System.out.println(game);
                   break;
               }
               if(game.checkDraw()){
                   System.out.println("Personne n'a gagné la partie !");
                   System.out.println(game);
                   break;
               }
               player = nextPlayer(player);

           }catch(TicTacToeInvalidInputException e){
               System.out.println(e.getMessage());
           }catch(NumberFormatException e){
               System.out.println("Vous devez saisir un chiffre entre 1 et 9");
           }

       }
    }

    private static int getInputUser() throws TicTacToeInvalidInputException {
        //Entrées utilisateur dans la console
        final var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        if(input.equals("exit") || input.equals("quit")){
            // System.exit permet de quitter le programme
            System.exit(0);
        }
        var inputEntier = Integer.parseInt(input);
        if(inputEntier < 1 || inputEntier > 9){
            throw new TicTacToeInvalidInputException("Le chiffre doit être entre 1 et 9");
        }
        return inputEntier;
    }

    private static Player nextPlayer(Player player) {
        if(player == player.FIRST) {
            return Player.SECOND;
        }else {
            return Player.FIRST;
        }

    }

}
