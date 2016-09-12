package tw.org.iii.zoraone;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    private View img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    img = findViewById(R.id.welcome_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMain();
            }
        });

    }

    private void gotoMain(){
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
        finish();
    }
}
