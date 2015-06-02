package com.projectdevlopment.androidgame;

/**
 * Created by Brigitte on 4/8/2015.
 */
public class Game {

    public static final int NONE = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;
    public static final int ROCK = 3;
    public static final int LIZARD = 4;
    public static final int SPOCK = 5;

    Player playerOne;
    Player playerTwo;
    AI playerAI;
    int score;

    public Game(){
        playerOne = new Player();
        playerAI = new AI();


    }

    public int Match(Player player, AI ai){

        //Play match with Player & AI
        //0 = match error
        //1 = player wins
        //2 = player loss
        //3 = draw

        if(player.getToken() == ai.getToken()){     //if draw
         return 3;
        } else if (player.getToken() == 1 && ai.getToken() == 3 || player.getToken() == 1 && ai.getToken() == 5 ||    //P1 wins with paper
                   player.getToken() == 2 && ai.getToken() == 1 || player.getToken() == 2 && ai.getToken() == 4 ||    //P1 wins with scissors
                   player.getToken() == 3 && ai.getToken() == 2 || player.getToken() == 3 && ai.getToken() == 4 ||    //P1 wins with rock
                   player.getToken() == 4 && ai.getToken() == 1 || player.getToken() == 4 && ai.getToken() == 5 ||    //P1 wins with lizard
                   player.getToken() == 5 && ai.getToken() == 1 || player.getToken() == 5 && ai.getToken() == 2    //P1 wins with spock
                ){
            player.incrementWin();
            return 1;
        } else{
            ai.incrementWin();
            player.decrementLives();
            if(player.getLives() < 1){  //if lives less then 1, game over
                return 4;
            }
            return 2;
        }
    }






}
