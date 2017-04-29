package kalandlabor.hu.rhythmiccolors;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * Created by user on 2017.04.23..
 */

public class Game extends AppCompatActivity {
    CustomAdapter customAdapter;
    private ViewFlipper simpleViewFlipper;
    int[] flippedImages = {R.drawable.prim1, R.drawable.prim2, R.drawable.prim3};
    private int flipInterval = 1000;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        final TextView count = (TextView) findViewById(R.id.tvCountdown);
        count.setTextSize(40);
        count.setTextColor(Color.RED);
        simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper);

//        customAdapter = new CustomAdapter(getApplicationContext(),flippedImages);
//        simpleAdapterViewFlipper.setAdapter(customAdapter);
        for (int i = 0; i<flippedImages.length; i++){
            ViewGroup.LayoutParams lp = simpleViewFlipper.getLayoutParams();


            ImageView imageView = new ImageView(this);
            imageView.setImageResource(flippedImages[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_START);


            simpleViewFlipper.addView(imageView);

            simpleViewFlipper.setLayoutParams(lp);
            simpleViewFlipper.setFlipInterval(1500);
            simpleViewFlipper.setInAnimation(this,R.anim.right_in);
        }

//simpleViewFlipper.setOutAnimation(this,R.anim.left_out);


        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                count.setText("" + (millisUntilFinished / 1000 - 1));
                if (millisUntilFinished < 2000) {
                    count.setText("GO!");

                    simpleViewFlipper.startFlipping();

                }
            }

            public void onFinish() {
            }
        }.start();
    }



    public void onClick1(View view){
        int pict = simpleViewFlipper.getCurrentView().getId();

        View btn = findViewById(R.id.button1);

        Log.d(String.valueOf(pict), "onClick1: viewcolor");
        Log.d(String.valueOf(btn.getId())+"btn1", "onClick1: buttoncolor");
        if(pict==btn.getId()) {
            points += 1;
            Log.d(String.valueOf(points), "onClick1: ");
            TextView pointsTV = (TextView) findViewById(R.id.points);
            pointsTV.setText("" + points);
        }
    }


    public void onClick2(View view) {
        int pict = simpleViewFlipper.getCurrentView().getId();
        View btn = findViewById(R.id.button2);
        Log.d(String.valueOf(pict), "onClick2: viewcolor");
        Log.d(String.valueOf(btn.getId()), "onClick2: buttoncolor");
        if(pict==btn.getId()) {
            points += 1;
            Log.d(String.valueOf(points), "onClick1: ");
            TextView pointsTV = (TextView) findViewById(R.id.points);
            pointsTV.setText("" + points);
        }
    }
    }




