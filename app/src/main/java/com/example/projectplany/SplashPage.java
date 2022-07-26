package com.example.projectplany;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashPage extends AppCompatActivity{

    private static int SPLASH_SCREEN_TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_page);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(1800);
        fadeOut.setDuration(1800);
        ImageView image = findViewById(R.id.imageView);

        image.setAnimation(fadeOut);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashPage.this, PlanyMenu.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);

    }

}