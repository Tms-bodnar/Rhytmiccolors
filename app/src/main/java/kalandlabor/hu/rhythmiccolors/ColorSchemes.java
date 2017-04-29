package kalandlabor.hu.rhythmiccolors;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by user on 2017.04.23..
 */

public class ColorSchemes extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_schemes);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button21).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
    }

    public void onClick(View view){
//        int color1 = ((ColorDrawable) findViewById(R.id.button1).getBackground()).getColor();
        int btnId = view.getId();
        switch(btnId){
            case R.id.button11 :  game(view); break;
            case R.id.button21 :  game(view); break;
            case R.id.button3 :  game(view); break;
            case R.id.button4 :  game(view); break;
            case R.id.button5 :  game(view); break;
            case R.id.button6 :  game(view); break;

        }



    }

    public void game(View view) {
        Intent gameIntent = new Intent(this,Game.class);

        startActivity(gameIntent);
    }
}
