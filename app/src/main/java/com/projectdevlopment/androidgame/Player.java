package com.projectdevlopment.androidgame;

/**
 * Created by Brigitte on 4/8/2015.
 */
public class Player {
    private int token;
    private int wins;
    private int lives;

    public Player(){
        token = 0;
        wins = 0;
        lives = 3;
    }

    //get and set token
    public void setToken(int value){token = value;}
    public int getToken(){return token;}

    //get and increment wins
    public void incrementWin(){wins += 1;}
    public int getWins(){return wins;}

    //get and decrement lives
    public int getLives(){return lives;}
    public void decrementLives(){lives -= 1;}

}

