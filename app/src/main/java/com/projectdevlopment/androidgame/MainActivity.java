package com.projectdevlopment.androidgame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    Game game = new Game();
    SoundPool pool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);     //CREATE SoundPool

        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {

            // Error check and notify when finish loading
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if(status != 0){
                    Log.e("SoundPoolDemo", "error loading resource");
                    return;
                }
                Log.i("SoundPoolDemo", "loaded" + sampleId);
            }
        });
        pool.load(this, R.raw.audio_gameover, 1);
        pool.load(this, R.raw.audio_win, 2);
        pool.load(this, R.raw.audio_loss, 3);
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

        TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
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
        switch(game.Match(game.playerOne, game.playerAI)) {
            case 1:
                txtMessage.setText("YOU WON THAT ROUND");
                pool.play(2, 1, 1, 1, 0, 1);
                break;
            case 2:
                txtMessage.setText("YOU LOST THAT ROUND");
                pool.play(3, 1, 1, 1, 0, 1);
                break;
            case 3:
                txtMessage.setText("DRAW THAT ROUND");
                pool.play(3, 1, 1, 1, 0, 1);
                break;
            case 4:
                GameOver();
                break;
        }

        //display tokens + message


    }

    public void GameOver(){

        Intent intent = new Intent(this, GameoverActivity.class);
        startActivity(intent);
        return;

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
