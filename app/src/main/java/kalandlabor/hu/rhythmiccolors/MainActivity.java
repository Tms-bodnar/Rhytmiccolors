package kalandlabor.hu.rhythmiccolors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void colorSchemes(View view){
        Intent colorSchemesIntent = new Intent(this,Description.class);
        startActivity(colorSchemesIntent);
    }




    public void exit(View view) {
        finish();
    }


}
