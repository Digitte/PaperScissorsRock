package com.projectdevlopment.androidgame;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    Game game = new Game();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //radio button manager
    public void handlerRadioButton(View view){
        ImageView imageViewP1 = (ImageView) findViewById(R.id.imageViewP1);

        switch(view.getId()){
            case R.id.rdbPaper:
                game.playerOne.setToken(game.PAPER);
                imageViewP1.setImageResource(R.drawable.paper);
                break;
            case R.id.rdbSissors:
                game.playerOne.setToken(game.SCISSORS);
                imageViewP1.setImageResource(R.drawable.sissors);
                break;
            case R.id.rdbRock:
                game.playerOne.setToken(game.ROCK);
                imageViewP1.setImageResource(R.drawable.rock);
                break;
            case R.id.rdbLizard:
                game.playerOne.setToken(game.LIZARD);
                imageViewP1.setImageResource(R.drawable.lizard);
                break;
            case R.id.rdbSpock:
                game.playerOne.setToken(game.SPOCK);
                imageViewP1.setImageResource(R.drawable.spock);
                break;
        }
    }

    public void handleSubmit(View view){
        TextView txtAI = (TextView) findViewById(R.id.txtAI);
        TextView txtP1 = (TextView) findViewById(R.id.txtP1);
        ImageView imageViewAI = (ImageView) findViewById(R.id.imageViewAI);

        game.playerAI.generateRandomToken();

        switch(game.playerAI.getToken()){
            case 1:
                imageViewAI.setImageResource(R.drawable.paper);
                break;
            case 2:
                imageViewAI.setImageResource(R.drawable.sissors);
                break;
            case 3:
                imageViewAI.setImageResource(R.drawable.rock);
                break;
            case 4:
                imageViewAI.setImageResource(R.drawable.lizard);
                break;
            case 5:
                imageViewAI.setImageResource(R.drawable.spock);
                break;
        }
        //calculate winner

        //display tokens + message
        txtAI.setText(String.valueOf(game.playerAI.getToken()));
        txtP1.setText(String.valueOf(game.playerOne.getToken()));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
