package com.projectdevlopment.androidgame;

/**
 * Created by Brigitte on 4/8/2015.
 */
public class Game {

    public static final int NONE = 0;
    public static final int PAPER = 1;
    public static final int SISSORS = 2;
    public static final int ROCK = 3;
    Player playerOne;
    Player playerTwo;
    AI playerAI;

    public Game(){
        playerOne = new Player();
        playerAI = new AI();
    }






}
