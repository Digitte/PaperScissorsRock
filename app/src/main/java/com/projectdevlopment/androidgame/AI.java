package com.projectdevlopment.androidgame;

import java.util.Random;

/**
 * Created by Brigitte on 4/8/2015.
 */
public class AI extends Player {

    public AI(){
        super();
    }

    Random random = new Random();

    public void generateRandomToken(){
        super.setToken(1 + random.nextInt(3));
    }

    @Override
    public int getToken(){
        return super.getToken();
    }

}
