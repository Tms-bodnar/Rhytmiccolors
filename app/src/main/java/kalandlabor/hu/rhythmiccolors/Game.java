
package kalandlabor.hu.rhythmiccolors;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.GridLayout;
import android.widget.ImageView;
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
    Integer[] images = {R.drawable.prim1, R.drawable.prim3,
            R.drawable.prim6, R.drawable.prim8};
    List<Integer> colorList;
    int size = 400;
    private int duration = 1000;
    int points = 0;
    boolean clickable = true;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(game);




        final View btnView1 = findViewById(R.id.btnView1);
        btnView1.setTag(R.drawable.prim1);
        final View btnView2 = findViewById(R.id.btnView2);
        btnView2.setTag(R.drawable.prim2);
        final View btnView3 = findViewById(R.id.btnView3);
        btnView3.setTag(R.drawable.prim3);
        final View btnView4 = findViewById(R.id.btnView4);
        btnView4.setTag(R.drawable.prim4);
        final View btnView5 = findViewById(R.id.btnView5);
        btnView5.setTag(R.drawable.prim5);
        final View btnView6 = findViewById(R.id.btnView6);
        btnView6.setTag(R.drawable.prim6);
        final View btnView7 = findViewById(R.id.btnView7);
        btnView7.setTag(R.drawable.prim7);
        final View btnView8 = findViewById(R.id.btnView8);
        btnView8.setTag(R.drawable.prim8);
        final TextView tvPoints = (TextView)findViewById(R.id.tvGrid3);
        final TextView tvSpeed = (TextView) findViewById(R.id.tvGrid4);
        tvPoints.setText("Points: " +String.valueOf(points));
        tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
        GridLayout leftBtnGroup = (GridLayout) findViewById(R.id.gridLay1);
        GridLayout rightBtnGroup = (GridLayout) findViewById(R.id.gridLay2);
        final GridLayout middleGridLayout = (GridLayout) findViewById(R.id.gridLay3);
        flipper();

        btnView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (btnView1.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable) {
                    points+=2;
                    clickable=false;
                    duration = setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView1.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    points-=1;
                    clickable=false;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }
            }
        });
/*        btnView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnView2.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    points+=2;
                    clickable=false;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView2.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points-=1;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }
            }
        });*/
        btnView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnView3.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points += 2;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView3.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points-=1;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }
            }
        });
/*        btnView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnView4.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points+= 2;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView4.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                points-=1;
                duration=setDuration(points);
                tvPoints.setText("Points: " +String.valueOf(points));
                tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
            }
            }
        });*/
/*        btnView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnView5.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points+=2;
                    duration= setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView5.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points-=1;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }
            }
        });*/
        btnView6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (btnView6.getTag().equals(simpleViewFlipper.getCurrentView().getTag())) {
                    clickable=false;
                    points+=2;
                    duration = setDuration(points);
                    tvPoints.setText(String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView6.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points-=1;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }
            }
        });
       /* btnView7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (btnView7.getTag().equals(simpleViewFlipper.getCurrentView().getTag())) {
                    clickable=false;
                    points+=2;
                    duration = setDuration(points);
                    tvPoints.setText(String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView7.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points-=1;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }
            }
        });*/
        btnView8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (btnView8.getTag().equals(simpleViewFlipper.getCurrentView().getTag())) {
                    clickable=false;
                    points+=2;
                    duration = setDuration(points);
                    tvPoints.setText(String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }else if(!btnView8.getTag().equals(simpleViewFlipper.getCurrentView().getTag())&&clickable){
                    clickable=false;
                    points-=1;
                    duration=setDuration(points);
                    tvPoints.setText("Points: " +String.valueOf(points));
                    tvSpeed.setText("Speed: "+String.valueOf(duration)+"ms");
                }
            }
        });



    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(Game.this, Description.class));
        finish();
    }

    private int setDuration(int points){

        if(points<=80) {
            if (points >= 10 && points < 20) {
                duration = 900;

            } else if (points >= 20 && points < 30) {
                duration = 875;

            } else if (points >= 30 && points < 40) {
                duration = 850;

            } else if (points >= 40 && points < 50) {
                duration = 825;

            } else if (points >= 50 && points < 60) {
                duration = 775;

            } else if (points >= 60 && points < 70) {
                duration = 700;

            } else if (points >= 70 && points < 80) {
                duration=650;

            }
        }
        switch (points){
            case 10: case 11:
                Toast level1Toast = new Toast(this);
                level1Toast.makeText(this, "Excellent!", Toast.LENGTH_SHORT).show();
                break;
            case 20: case 21:
                Toast level2Toast = new Toast(this);
                level2Toast.makeText(this, "You are really fast!! ", Toast.LENGTH_SHORT).show();
                break;
            case 30: case 31:
                Toast level3Toast = new Toast(this);
                level3Toast.makeText(this, "OMG, damn good!!", Toast.LENGTH_SHORT).show();
                break;
            case 40: case 41:
                Toast level4Toast = new Toast(this);
                level4Toast.makeText(this, "Damn fast!!", Toast.LENGTH_SHORT).show();
                break;
            case 50: case 51:
                Toast level5Toast = new Toast(this);
                level5Toast.makeText(this,"F.ckin' speedy", Toast.LENGTH_SHORT).show();
                break;
            case 60:case 61:
                Toast level6Toast = new Toast(this);
                level6Toast.makeText(this, "Are you Flash?", Toast.LENGTH_SHORT).show();
                break;
            case 70:case 71:
                Toast level7Toast = new Toast(this);
                level7Toast.makeText(this, "Are you Flash? Increase speed +10%", Toast.LENGTH_SHORT).show();
                break;
            case 80: case 81:
                simpleViewFlipper.stopFlipping();
                Toast levelToast = new Toast(this);
                levelToast.makeText(this, "OK, i believe now you are Flash!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Game.this, Description.class));
                finish();
                break;
        }
        return duration;
    }

    public void flipper() {
        colorList = ColorsAdmin.ListAdmin(images, size);
        simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper);
        for (int i = 0; i < colorList.size(); i++) {
            ViewGroup.LayoutParams lp = simpleViewFlipper.getLayoutParams();
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(colorList.get(i));
            imageView.setTag(colorList.get(i));
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            simpleViewFlipper.addView(imageView);
            simpleViewFlipper.setLayoutParams(lp);
            simpleViewFlipper.setFlipInterval(1000);
            simpleViewFlipper.setInAnimation(this, R.anim.right_in);
        }

        simpleViewFlipper.startFlipping();
        simpleViewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                simpleViewFlipper.getInAnimation().setDuration(duration);
                simpleViewFlipper.setFlipInterval(duration);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                clickable=true;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}




