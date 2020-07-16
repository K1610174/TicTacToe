/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

/**
 *
 * @author k1746425
 */
public class Board {
    
    //Board Attributes
    private int row;
    private int col;
    private char[][] boardArray;
    
    //Create a new board and populate with underscores using a nested for loop
    public void newBoard()
    {
        //Create a 2d char array that is [4][4] called tempBoard
        char[][] tempBoard = new char[4][4];
        //Populate tempBoard with underscores
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++)
            {
                tempBoard[i][j] = '_';
            }
        }
        //Set tempBoard as boardArray attribute for the board
        this.setBoardArray(tempBoard);
    }
    
    //Print the board to the Player
    public void printBoard()
    {
        //Print title
        System.out.println();
        System.out.println("   Tic Tac Toe");
        
        //Print out each row and column of the board with each element seperated by a verticle bar
        for(int i=0; i<4; i++)
        {
            if(i>0)
            {
                System.out.println();
            }
            for(int j=0; j<4;j++)
            {
                if(j==0)
                {
                    System.out.print("| ");
                }
                System.out.print(this.getBoardArray()[i][j]+ " | ");
            }
        }
        System.out.println();
        System.out.println();
    }
    


    //Getters and Setters Below

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(char[][] boardArray) {
        this.boardArray = boardArray;
    }

}
