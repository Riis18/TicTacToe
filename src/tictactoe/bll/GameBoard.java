/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    private int startPlayer = 0;
    private int currentPlayer;
    int rows = 3, cols = 3;
    int[][] gameBoard = new int[rows][cols];
    private int fieldsPlayed = 0;
    
    
    public GameBoard()
    {
        newGame();
    
    }
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
       return currentPlayer;
       
    }
    

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        gameBoard[row][col] = currentPlayer;
        
        if(currentPlayer == 0)
        {
            currentPlayer = 1;
        }
        else if(currentPlayer == 1)
        {
            currentPlayer = 0;
        }
        fieldsPlayed++;
        //TODO Implement this method
        return true;
    }

    public boolean isGameOver()
    {
        if(getWinnerVertically() || getWinnerHorizontally()||getWinnerDiagonally()||fieldsPlayed == 9)
        {
            return true;
        }
            
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {       
     if(getWinnerDiagonally()||getWinnerVertically()||getWinnerHorizontally())
     {
         return currentPlayer;
     }
     
     return -1;
    }
    public boolean getWinnerVertically()
    {
                for (int col=0; col < gameBoard.length; col++)
        {
            if (gameBoard[0][col] == currentPlayer && gameBoard[1][col] == currentPlayer && gameBoard[2][col] == currentPlayer)
                return true;
        }
                return false;
    }
    
    public boolean getWinnerHorizontally()
    {
             for (int row=0; row < gameBoard.length; row++)
        {
            if (gameBoard[row][0] == currentPlayer && gameBoard[row][1] == currentPlayer && gameBoard[row][2] == currentPlayer)
                return true;
        }
                return false;
    }
    
    public boolean getWinnerDiagonally()
            
    {
             for (int row=0; row < gameBoard.length; row++)
        {
            if (gameBoard[0][0] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][2] == currentPlayer)
                return true;
        }
             if (gameBoard[2][0] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[0][2] == currentPlayer)
                return true;
             
             else return false;
    }
   
    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        currentPlayer = startPlayer;
        fieldsPlayed = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++)
            {
                gameBoard[row][col] = 3;
            }
            
        }
        //TODO Implement this method
    }

}
