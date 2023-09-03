package com.example.game;

import java.util.Arrays;

import static com.example.game.StringConstants.LINE_SEPARATOR;
import static com.example.game.StringConstants.SPACE;


public class TicTacToe {


    private char[][] grid = new char[][]{
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
    };

    // Affichage par ligne ou colonne des croix ou rond
    public void processInput(Player player, int inputUser) {
        var row = (inputUser - 1) / 3;
        var column = (inputUser - 1) % 3;
        if(grid[row][column] == '.'){
            if(player.equals(player.FIRST)){
                grid[row][column] = 'X';
            }else {
                grid[row][column] = 'O';
            }
        }
    }

    @Override
    public String toString() {
        //builder optimise la consommation de mémoire
        final var builder = new StringBuilder();
        builder.append("Grille du Morpion : ").append(LINE_SEPARATOR);
        for (char[] lines : grid){
            for (char cell: lines){
                builder.append(SPACE).append(cell).append(SPACE);
            }
            builder.append(LINE_SEPARATOR);
        }
        return builder.toString();

    }


}
