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
public class Main {
    public static void main(String[] args)
    {
        //Create a new instance of Board and call it board1
        Board board1 = new Board(); 
        
        //Run newBoard method to populate board1
        board1.newBoard();          
        
        
        
        //Create a new instance of Game and call it game1
        Game game1 = new Game();
        
        //Run startGame method with board1 as paramater
        game1.startGame(board1);    
       
    }    
}
