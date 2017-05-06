
package kalandlabor.hu.rhythmiccolors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.List;

import static kalandlabor.hu.rhythmiccolors.R.layout.game;


/**
 * Created by user on 2017.04.23..
 */

public class Game extends AppCompatActivity {
    private ViewFlipper simpleViewFlipper;
    Integer[] images = {R.drawable.prim1, R.drawable.prim2, R.drawable.prim3, R.drawable.prim4,
            R.drawable.prim5, R.drawable.prim6, R.drawable.prim7, R.drawable.prim8};
    List<Integer> colorList;
    int size = 400;
    private int flipInterval = 1000;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(game);




        final View btnView1 = findViewById(R.id.btnView1);
        btnView1.setTag(R.drawable.prim1);
        View btnView2 = findViewById(R.id.btnView2);
        btnView2.setTag(R.drawable.prim2);
        final View btnView3 = findViewById(R.id.btnView3);
        btnView3.setTag(R.drawable.prim3);
        View btnView4 = findViewById(R.id.btnView4);
        btnView4.setTag(R.drawable.prim4);
        View btnView5 = findViewById(R.id.btnView5);
        btnView5.setTag(R.drawable.prim5);
        final View btnView6 = findViewById(R.id.btnView6);
        btnView6.setTag(R.drawable.prim6);
        View btnView7 = findViewById(R.id.btnView7);
        btnView7.setTag(R.drawable.prim7);
        final View btnView8 = findViewById(R.id.btnView8);
        btnView8.setTag(R.drawable.prim8);

        GridLayout leftBtnGroup = (GridLayout) findViewById(R.id.gridLay1);
        GridLayout rightBtnGroup = (GridLayout) findViewById(R.id.gridLay2);
        final GridLayout middleGridLayout = (GridLayout) findViewById(R.id.gridLay3);

        flipper();
        btnView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (btnView1.getTag().equals(simpleViewFlipper.getCurrentView().getTag())) {
                    ImageView iv = new ImageView(Game.this);
                    iv.setImageResource(R.drawable.prim1);
                    middleGridLayout.removeAllViews();
                    middleGridLayout.addView(iv);


                }
            }
        });

        btnView6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (btnView6.getTag().equals(simpleViewFlipper.getCurrentView().getTag())) {

                    ImageView iv = new ImageView(Game.this);
                    iv.setImageResource(R.drawable.prim6);
                    middleGridLayout.removeAllViews();
                    middleGridLayout.addView(iv);

                }
            }
        });
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
            simpleViewFlipper.setFlipInterval(flipInterval);
            simpleViewFlipper.setInAnimation(this, R.anim.right_in);
        }
        simpleViewFlipper.startFlipping();
    }
}




