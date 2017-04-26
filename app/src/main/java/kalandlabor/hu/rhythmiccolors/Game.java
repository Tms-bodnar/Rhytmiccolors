package kalandlabor.hu.rhythmiccolors;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.TextView;


/**
 * Created by user on 2017.04.23..
 */

public class Game extends AppCompatActivity {
    private AdapterViewFlipper simpleAdapterViewFlipper;
    int[] flippedImages = {R.drawable.prim4, R.drawable.prim2, R.drawable.prim3};
    private int flipInterval = 500;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        final TextView count = (TextView) findViewById(R.id.tvCountdown);
        count.setTextSize(40);
        count.setTextColor(Color.RED);
        simpleAdapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.simpleAdapterViewFlipper);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),flippedImages);
        simpleAdapterViewFlipper.setAdapter(customAdapter);
        simpleAdapterViewFlipper.setFlipInterval(1000);
        simpleAdapterViewFlipper.setInAnimation(this,R.animator.right_in);
        simpleAdapterViewFlipper.setOutAnimation(this,R.animator.left_out);
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                count.setText("" + (millisUntilFinished / 1000 - 1));
                if (millisUntilFinished < 2000) {
                    count.setText("GO!");

                    simpleAdapterViewFlipper.startFlipping();

                }
            }

            public void onFinish() {
            }
        }.start();
    }



    public void onClick1(View view){


        int color1 = 0;
        Log.d(String.valueOf(color1), "onClick1: viewcolor");

        int color2 = 1;
        Log.d(String.valueOf(color2), "onClick1: buttoncolor");
        if(color1 == color2) {
            points += 1;
            Log.d(String.valueOf(points), "onClick1: ");
            TextView pointsTV = (TextView) findViewById(R.id.points);
            pointsTV.setText("" + points);
        }
    }


    public void onClick2(View view) {
        AdapterViewFlipper vf = (AdapterViewFlipper) findViewById(R.id.simpleAdapterViewFlipper);
        ColorDrawable viewCol = (ColorDrawable) vf.getCurrentView().getBackground();
        int color1 = viewCol.getColor();
        Log.d(String.valueOf(color1), "onClick1: viewcolor");
        ColorDrawable buttonCol = (ColorDrawable)findViewById(R.id.button2).getBackground();
        int color2 = buttonCol.getColor();
        Log.d(String.valueOf(color2), "onClick1: buttoncolor");
        if(color1 == color2) {
            points += 1;
            Log.d(String.valueOf(points), "onClick1: points");
            TextView pointsTV = (TextView) findViewById(R.id.points);
            pointsTV.setText("" + points);
        }
    }
    }




