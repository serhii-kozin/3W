package www.a3w;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import www.a3w.persone.PersoneActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, PersoneActivity.class);
        startActivity(intent);
        finish();
    }
}
