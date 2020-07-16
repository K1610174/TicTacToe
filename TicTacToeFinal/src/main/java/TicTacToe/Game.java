/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.util.Scanner;
/**
 *
 * @author k1746425
 */
public class Game {
    
    //Attributes
    private char turn;
    private int num;
    private boolean playing;
    private Scanner input;

    //Constructor
    public Game()
    {
        this.setTurn('X');
        this.setNum(1);
        this.setPlaying(true);
        Scanner userInput = new Scanner(System.in);
        this.setInput(userInput);
    }
    
    //Main Game method
    public void startGame(Board board)
    {
        //Game intro, instructions, and print board
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1 is X, Player 2 is O");
        System.out.println();
        System.out.println("Type a number between 1 and 4 to select a Row or Column");
        System.out.println("Or Type 9 to Restart Game");
        board.printBoard();
        
        //Whilst Playing is set to true, stay in loop
        while(this.isPlaying()) 
        {

            //Use scanner to take user input for row selection
            System.out.println("Please enter a Row Player "+ this.getTurn());
            board.setRow(input.nextInt());
            
            //If player types 9, restart game
            if (board.getRow() == 9)
            {
                this.newGame(board);
            }

            //Use scanner to take user input for col selection
            System.out.println("Please enter a Column Player "+ this.getTurn());
            board.setCol(input.nextInt());    
            
            //If player types 9, restart game
            if (board.getCol() == 9)
            {
                this.newGame(board);
            }
            

            
            
            //Check if row and col entered are available
            if (checkIllegal(board, board.getRow(), board.getCol()))
            {   
                //Create a temporary 2d char array to store the current board
                char[][] tempBoard = new char[4][4]; 
                //Use a nested loop to store all elements from current board in tempBoard
                for(int i=0; i<4; i++)
                {
                    for(int j=0; j<4; j++)
                    {
                        tempBoard[i][j] = board.getBoardArray()[i][j];
                    }
                }
                //Then change the selected element from an underscore to an X or an O
                tempBoard[board.getRow()-1][board.getCol()-1] = turn;
                //Then replace the current board with the updated tempBoard
                board.setBoardArray(tempBoard);     
                //Display the updated Board to the Player
                board.printBoard();
                
                
                //Check for a winner
                if (this.gameOver(board, board.getRow(), board.getCol()))
                {
                    //If soemone has won, change playing to false to end the loop
                    this.setPlaying(false);
                    System.out.println("Game Over Man! Game Over!");
                    System.out.println("Player " + this.getTurn() + " wins!");
                }
                
                // Else if there is no winner, check for a tie
                else if (this.checkTie(board))
                {
                    this.setPlaying(false);
                    System.out.println("It's a Tie");
                }
                
                //Check to see whose turn it is, and update turn
                this.checkTurn();
            }
            
            // else if the move was illegal, start the turn again
            else
            {
                System.out.println();
                System.out.println("Illegal move, try again");
                board.printBoard();
            }
        }
        
        
        
        //While loop has ended, so the game is over
        System.out.println();
        System.out.println("Type 1 to play again!");
        System.out.println();
        
        //If Player types 1, restart game
        String answer = input.next();
        if (answer.equals("1"))
        {
            this.newGame(board);
        }
        //Else, end program
        else
        {
            System.out.println();
            System.out.println("Thanks for Playing!");
            System.out.println();
        }
    }
    
    //Reset Game attributes, reset the board, and run startGame again
    public void newGame(Board board)
    {
        this.setTurn('X');
        this.setNum(1);
        this.setPlaying(true);
        
        board.newBoard();
        
        this.startGame(board);
    }
    
    //Check if board is full
    public boolean checkTie(Board board)
    {
        boolean count = true;
        //Use nested loop to itterate through each element of the board
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++)
            {
                //If any elements still have an underscore, game is still in play
                if (board.getBoardArray()[i][j] == '_')
                {
                    count = false;
                }
            }
        }
        // if true, game is a tie
        return count;
    }
    
    //Check to see whose turn it is
    public void checkTurn()
    {
        //If num = 4, change num to 0
        if (this.getNum() == 4)
        {
            this.setNum(0);
        }
        //If num = 0 or 1, turn = "X" and num increases by 1
        if (this.getNum() == 0 || this.getNum() == 1)
        {
            this.setTurn('X');
            this.setNum(this.getNum() + 1);
        }
        //If num = 2 or 3, turn = "O" and num increases by 1
        else if (this.getNum() == 2 || this.getNum() == 3)
        {
            this.setTurn('O');
            this.setNum(this.getNum() + 1);
        }
    }
    
    //Check to see if someone has won the game
    public boolean gameOver(Board board, int row, int col)
    {
        //Check Row
        if (board.getBoardArray()[0][col-1]==board.getBoardArray()[0][col-1]&&
            board.getBoardArray()[0][col-1]==board.getBoardArray()[1][col-1]&&
            board.getBoardArray()[0][col-1]==board.getBoardArray()[2][col-1]&&
            board.getBoardArray()[0][col-1]==board.getBoardArray()[3][col-1])
        {
            return true;
        }
        //Check Col
        if (board.getBoardArray()[row-1][0]==board.getBoardArray()[row-1][0]&&
            board.getBoardArray()[row-1][0]==board.getBoardArray()[row-1][1]&&
            board.getBoardArray()[row-1][0]==board.getBoardArray()[row-1][2]&&
            board.getBoardArray()[row-1][0]==board.getBoardArray()[row-1][3])
        {
            return true;
        }
        //Check Diagonal
        if (board.getBoardArray()[0][0]==board.getBoardArray()[1][1]&&
            board.getBoardArray()[0][0]==board.getBoardArray()[2][2]&&     
            board.getBoardArray()[0][0]==board.getBoardArray()[3][3]&&
            board.getBoardArray()[0][0]!='_')
        {
            return true;
        }
        //Check Diagional
        if  (board.getBoardArray()[0][3]==board.getBoardArray()[1][2]&&
             board.getBoardArray()[0][3]==board.getBoardArray()[2][1]&&
             board.getBoardArray()[0][3]==board.getBoardArray()[3][0]&&
             board.getBoardArray()[0][3]!= '_')
        {
            return true;
        }
        //Return false if no one has won
        return false;
    }
    
    //Check to see if the player selections are allowed
    public boolean checkIllegal(Board board, int row, int col)
    {
        char[][] currentBoard = board.getBoardArray();
        //If selected Row and Col are between 1 and 4, and the element is equal to an underscore, then return true
        if ((row < 5 && row > 0) && (col < 5 && col > 0) && (currentBoard[row-1][col-1] == '_'))
         {
             return true;
         }
        //Otherwise, the move is illegal, return false
        return false;
    }
    
    
    //Getters and Setters Below
    
    public char getTurn() {
        return turn;
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

   
}
