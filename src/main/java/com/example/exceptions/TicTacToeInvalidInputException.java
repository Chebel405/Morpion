package com.example.exceptions;

public class TicTacToeInvalidInputException extends Throwable {


    public TicTacToeInvalidInputException() {
        super();
    }

    public TicTacToeInvalidInputException(String message) {
        super(message);
    }


}
