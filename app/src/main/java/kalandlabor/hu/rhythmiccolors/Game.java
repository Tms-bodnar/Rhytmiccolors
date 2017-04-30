
package kalandlabor.hu.rhythmiccolors;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.List;

import static kalandlabor.hu.rhythmiccolors.R.layout.game;


/**
 * Created by user on 2017.04.23..
 */

public class Game extends AppCompatActivity {
    private ViewFlipper simpleViewFlipper;
    Integer[] images = {R.drawable.prim1, R.drawable.prim2, R.drawable.prim3, R.drawable.prim4,
                    R.drawable.prim5, R.drawable.prim6,R.drawable.prim7,R.drawable.prim8};

    private int flipInterval = 1000;
    private int points = 0;
    Intent intent;
    int level;
    int listParam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(game);
        intent = getIntent();
        level = intent.getIntExtra("ColorButton", 2);
        listParam = 6;

        final TextView count = (TextView) findViewById(R.id.tvCountdown);
        count.setTextSize(40);
        count.setTextColor(Color.RED);
        Toast leveltoast = new Toast(this);
        leveltoast.makeText(this, ""+level/2+" level with "+level+" colors!",Toast.LENGTH_LONG).show();


        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                count.setText("" + (millisUntilFinished / 1000 - 1));
                if (millisUntilFinished < 2000) {
                    count.setText("GO!");

                    flipper();

                }
            }
            public void onFinish() {
            }
        }.start();

        final View btn1 = findViewById(R.id.button1);
        btn1.setTag(R.drawable.prim1);
        btn1.setOnClickListener(new View.OnClickListener() {
            private boolean clickable = true;
            public void reset(){
                clickable= true;
            }
            @Override
            public void onClick(View v) {
                if(clickable){
                    clickable= false;
                }
                if(btn1.getTag().equals(simpleViewFlipper.getCurrentView().getTag())){
                    LinearLayout ll1 = (LinearLayout) findViewById(R.id.linlay1);
                    LinearLayout ll2 = (LinearLayout) findViewById(R.id.linlay2);
                    if(ll1.getWidth()>ll1.getHeight()) {
                        points += 1;
                        count.setText("" + points);

                        int width1 = ll1.getWidth() - ll1.getHeight();
                        int width2 = ll2.getWidth() + ll2.getHeight();
                        ll1.getLayoutParams().width = width1;
                        ll1.requestLayout();

//                        ll2.getLayoutParams().width= width2;
//                        ll2.requestLayout();
                        Log.d("grid", ""+ll2.getLayoutParams().width);
//                        ImageView vv = new ImageView(Game.this.getApplicationContext());
//                        vv.setImageResource(R.drawable.prim2);
//                        vv.setScaleType(ImageView.ScaleType.FIT_START);
//                        ll2.addView(vv);

                    }else{
                        finish();
                    }
                }
            }

        });
        final View btn2 = findViewById(R.id.button2);
        btn2.setTag(R.drawable.prim2);
        btn2.setOnClickListener(new View.OnClickListener() {
            private boolean clickable = true;
            public void reset(){
                clickable= true;
            }
            @Override
            public void onClick(View v) {
                if (clickable) {
                    clickable = false;
                }
                if (btn2.getTag().equals(simpleViewFlipper.getCurrentView().getTag())) {
                    LinearLayout ll1 = (LinearLayout) findViewById(R.id.linlay1);
                    LinearLayout ll2 = (LinearLayout) findViewById(R.id.linlay2);
                    if (ll1.getWidth() > ll1.getHeight()) {
                        points += 1;
                        count.setText("" + points);

                        int width1 = ll1.getWidth() - ll1.getHeight();
                        int width2 = ll2.getWidth() + ll2.getHeight();
                        ll1.getLayoutParams().width = width1;
                        ll1.requestLayout();
                        ll2.getLayoutParams().width= width2;
                        ll2.requestLayout();
                        Log.d("Flipper", ""+ll1.getLayoutParams().width);
                        Log.d("grid", ""+ll2.getLayoutParams().width);
//                        ImageView vv = new ImageView(Game.this.getApplicationContext());
//                        vv.setImageResource(R.drawable.prim3);
//                        vv.setScaleType(ImageView.ScaleType.FIT_START);
//                        ll2.addView(vv);

                    } else {
                        finish();
                    }
                }
            }
        });
    }
    public void flipper(){
        List<Integer> colorList = ColorsAdmin.ListAdmin(images,level,listParam);
        Log.d("level,listParam", ""+level+ " "+listParam);
        Log.d("listsize:", ""+colorList.size());
        simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper);
        for (int i = 0; i<colorList.size(); i++){
            ViewGroup.LayoutParams lp = simpleViewFlipper.getLayoutParams();
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(colorList.get(i));
            imageView.setTag(colorList.get(i));
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            simpleViewFlipper.addView(imageView);
            simpleViewFlipper.setLayoutParams(lp);
            simpleViewFlipper.setFlipInterval(flipInterval);
            simpleViewFlipper.setInAnimation(this,R.anim.right_in);
            Log.d("i=",""+i);

        }
        Log.d("childcount",""+simpleViewFlipper.getChildCount());

        simpleViewFlipper.startFlipping();
        simpleViewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("displayed", "" + simpleViewFlipper.getDisplayedChild());
                if (simpleViewFlipper.getDisplayedChild() == simpleViewFlipper.getChildCount() - 1) {
                    simpleViewFlipper.stopFlipping();
                }
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Log.d("displayed",""+simpleViewFlipper.getDisplayedChild());



    }


    }




