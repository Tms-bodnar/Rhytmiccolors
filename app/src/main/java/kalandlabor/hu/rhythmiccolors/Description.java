package kalandlabor.hu.rhythmiccolors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 2017.04.23..
 */

public class Description extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        findViewById(R.id.btnStart).setOnClickListener(this);
    }

    public void onClick(View view){
        int btnId = view.getId();
        switch(btnId){
            case R.id.btnStart :  countdown(view); break;


        }



    }

    public void countdown(View view) {
        Intent countdownIntent = new Intent(this,Countdown.class);
        startActivity(countdownIntent);
    }
}
