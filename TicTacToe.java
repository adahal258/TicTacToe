// Name: Aashutosh Dahal
// Class: 2251: A01
// Assignment: TicTacToe Class.
// Purpose: To create a TicTacToe class that has enum CellState X, O and Empty. Used 2d array to create the board for
// the game and fill it with EMPTY initially. Ask user the input and print the result where printBoard prints the boards.
// Filename: "TicTacToe.java"

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    enum CellState{
        X,
        O,
        EMPTY;
    }

    enum GameState{
        WIN,
        DRAW,
        CONTINUE;
    }
    private final CellState[][] board = new CellState[3][3];
    private Scanner userInput = new Scanner(System.in);
    private int row;
    private int column;
    private GameState trackGameState =GameState.CONTINUE;

    private CellState result;

    private int turn=0; //turn= 0 indicates player X turn ; turn = 1 indicates player O turn.
    private CellState playerTurn = CellState.EMPTY;


    // default constructor that initialize value of TicTacToe board with empty.
    public TicTacToe () {
        //initialization of board with empty value
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = CellState.EMPTY;
            }
        }
    }
    //initialize the user input in the board.
    void initializeBoard(){
        if(turn == 1 )
            board[row][column] = CellState.X;
        else if( turn == 0)
            board[row][column] = CellState.O;
    }

    //read row input from the user and check the input mismatch exception
    void readRow(){
        try {
            this.row = userInput.nextInt()-1; // since indexing start with 0.
        }
        catch (InputMismatchException e){
            System.out.println("Please enter valid input. ");
            System.out.print("Player "+playerTurn+": Enter row (0,1 or 2):\t");
            userInput.nextLine();
            readRow();


        }
    }

    // read the column from the user.
    void readColumn(){
        try {
            this.column = userInput.nextInt()-1;
        }
        catch (InputMismatchException e){
            System.out.println("Please enter valid input.");
            System.out.print("Player "+playerTurn+": Enter column (0,1 or 2):\t");
            userInput.nextLine();
            readColumn();
        }
    }

    // check whether the input move is valid  or not.
    public boolean validMove(){
        if((row)<0 || (column)<0){
            return false;
        }
        else if((row)>2||(column)>2){
            return false;
        }
        else if(board[row][column]!=CellState.EMPTY){
            return false;
        }
        else if (board[row][column] == CellState.EMPTY){
            return true;
        }
        return false;
    }

//return the status of the game
    public GameState gameStatus() {
        result = Winner();
        int counter = 0;
        if (result == CellState.X) {
            return GameState.WIN; //player 1 wins
        } else if (result == CellState.O) {
            return GameState.WIN; //player 2 wins
        } else if (result == CellState.EMPTY) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    if (board[row][col] == CellState.EMPTY) {
                        return GameState.CONTINUE;
                    } else if (board[row][col] == CellState.X || board[row][col] == CellState.O) {
                        counter ++;
                        if(counter == 9) //Since board is 3*3;
                            return GameState.DRAW;
                    }
                }
            }
        }
        return GameState.CONTINUE;
    }

    private CellState Winner(){
        //winning rule checking row and columns
        if(board[0][0]==CellState.X && board[0][1]==CellState.X && board[0][2]==CellState.X){
            return CellState.X;
        }
        else if(board[0][0]==CellState.O && board[0][1]==CellState.O && board[0][2]==CellState.O) {
            return CellState.O;
        }
        else if(board[1][0]==CellState.X && board[1][1]==CellState.X && board[1][2]==CellState.X){
            return CellState.X;
        }
        else if(board[1][0]==CellState.O && board[1][1]==CellState.O && board[1][2]==CellState.O){
            return CellState.O;
        }
        else if(board[2][0]==CellState.X && board[2][1]==CellState.X && board[2][2]==CellState.X) {
            return CellState.X;
        }
        else if(board[2][0]==CellState.O && board[2][1]==CellState.O && board[2][2]==CellState.O) {
            return CellState.O;
        }
        else if(board[0][0]==CellState.X && board[1][0]==CellState.X && board[2][0]==CellState.X){
            return CellState.X;
        }
        else if(board[0][0]==CellState.O && board[1][0]==CellState.O && board[2][0]==CellState.O){
            return CellState.O;
        }
        else if(board[0][1]==CellState.X && board[1][1]==CellState.X && board[2][1]==CellState.X){
            return CellState.X;
        }
        else if(board[0][1]==CellState.O && board[1][1]==CellState.O && board[2][1]==CellState.O){
            return CellState.O;
        }
        else if(board[0][2]==CellState.X && board[1][2]==CellState.X && board[2][2]==CellState.X){
            return CellState.X;
        }
        else if(board[0][2]==CellState.O && board[1][2]==CellState.O && board[2][2]==CellState.O){
            return CellState.O;
        }

        //winning rule for diagonals.
        else if(board[0][0]==CellState.X && board[1][1]==CellState.X && board[2][2]==CellState.X){
            return CellState.X;
        }
        else if(board[0][0]==CellState.O && board[1][1]==CellState.O && board[2][2]==CellState.O){
            return CellState.O;
        }
        else if(board[0][2]==CellState.X && board[1][1]==CellState.X && board[2][0]==CellState.X){
            return CellState.X;
        }
        else if(board[0][2]==CellState.O && board[1][1]==CellState.O && board[2][0]==CellState.O){
            return CellState.O;
        }

        return CellState.EMPTY; //here this indicates no one win the game. might be some empty space or game is draw.
    }
    void play(){
        System.out.println("\n\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\t\t\tWelcome! You are playing TicTacToe....");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\n");
        while(trackGameState==GameState.CONTINUE){ // initial condition for running the game
            if(turn==0){
                playerTurn = CellState.X;
                turn = 1;
            }
            else if(turn ==1){
                playerTurn = CellState.O;
                turn = 0;

            }
            printBoard();
            System.out.println("Player "+ playerTurn+"'s turn.");
            System.out.print("Player "+playerTurn+": Enter row (1,2 or 3):\t");
            readRow();
            System.out.print("Player "+playerTurn+": Enter column (1,2 or 3):\t");
            readColumn();
            boolean validation = validMove();
            while(!validation){ // checking validation
                System.out.println("Player "+ playerTurn+" move is invalid");
                System.out.print("Player "+playerTurn+": Enter row (1,2 or 3):\t");
                readRow();
                System.out.print("Player "+playerTurn+": Enter column (1,2 or 3):\t");
                readColumn();
                validation = validMove();
            }
            initializeBoard();
            GameState status = gameStatus();
            if(result!=CellState.EMPTY){
                printBoard();
                trackGameState= status; //this can terminate the loop.
                if(status == GameState.WIN) {
                    System.out.println("Player " + playerTurn + " " + status);
                }
            }
            else{
                System.out.println("Game "+status);
                trackGameState= status; //this can terminate the loop.
            }
        }

    }

//Printing the board
    void printBoard(){
        for(int row = 0 ; row < board.length; row++){
            System.out.println("----------------------");
            for(int col = 0 ; col < board.length ; col++){
                System.out.printf("%8s" , board[row][col] + " | ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}
