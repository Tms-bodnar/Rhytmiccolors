package kalandlabor.hu.rhythmiccolors;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static kalandlabor.hu.rhythmiccolors.R.layout.countdown;
import static kalandlabor.hu.rhythmiccolors.R.layout.game;

/**
 * Created by user on 2017.05.01..
 */

public class Countdown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(countdown);
        final ImageView countImage = (ImageView) findViewById(R.id.countImage);
        final Animation countAnim = AnimationUtils.loadAnimation(this, R.anim.zoom);
        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                int count = (int) (millisUntilFinished/1000);
                switch (count){
                    case 4: countImage.setImageResource(R.drawable.ready);
                        countImage.setAnimation(countAnim);
                        countImage.startAnimation(countAnim);
                        break;
                    case 3: countImage.setImageResource(R.drawable.steady);
                        countImage.setAnimation(countAnim);
                        countImage.startAnimation(countAnim);
                        break;
                    case 2: countImage.setImageResource(R.drawable.go);
                        countImage.setAnimation(countAnim);
                        countImage.startAnimation(countAnim);
                        break;
                    case 1:
                        game();
                        break;

                }
                }

            public void onFinish() {


            }

        }.start();

    }
    public void game(){
        Intent gameIntent = new Intent(this,Game.class);
        startActivity(gameIntent);
    }
}