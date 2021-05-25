package com.itbl.bpdbtender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

public class Splash extends Activity {

    Animation topAnim, botAnim;
    ImageView image;
    TextView slogan,itbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.logo);
        slogan = findViewById(R.id.slogan);
        itbl = findViewById(R.id.itbl);

        slogan.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        itbl.setTypeface(ResourcesCompat.getFont(this, R.font.kaushan_script));

        image.setAnimation(topAnim);
        slogan.setAnimation(botAnim);
        itbl.setAnimation(botAnim);

        Thread t= new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    Intent i=new Intent(Splash.this,LoginActivity.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();
    }
}
