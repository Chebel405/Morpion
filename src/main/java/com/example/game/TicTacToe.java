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

    // Affichage par ligne ou colonne des croix ou cercles
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
    //Méthode checkWin valide si les lignes, colonnes ou diagonales sont correctement remplie par l'utilisateur
    public boolean checkWin() {
        for(int i=0; i<3; i++){
            var checkLine = grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] != '.';
            var checkColumn = grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[2][i] != '.';
            if(checkLine || checkColumn){
                return true;
            }
        }
        var checkDiagonal1 = grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] != '.';
        var checkDiagonal2 = grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] != '.';
        if(checkDiagonal1 || checkDiagonal2){
            return true;
        }
        return false;
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
