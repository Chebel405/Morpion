package com.example.morpion;

import com.example.game.TicTacToe;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;


public class MorpionApplication {

    public static void main(String[] args) {
        //Entrées utilisateur dans la console
       final var scanner = new Scanner(System.in);
       final var game = new TicTacToe();

       while(true){
           System.out.println(game);
           System.out.println("Saisissez un nombre entre 1 et 9 : ");
           final var inputUser = scanner.nextInt();
       }
    }

}
