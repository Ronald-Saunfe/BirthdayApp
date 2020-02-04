package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    private ImageView img1;
    private TextView txt1;
    private CardView cardOne;
    private CardView cardtwo;
    private ImageView img2;
    private TextView txt2;
    Activity actvity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else
        {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);

        }
        setContentView(R.layout.activity_main);
        actvity = this;

        cardOne = (CardView) findViewById(R.id.cgift1);
        img1 = (ImageView) findViewById(R.id.giftone1);
        txt1 = (TextView) findViewById(R.id.giftone);

        cardtwo =  (CardView)findViewById(R.id.cgift2);
        img2 = (ImageView) findViewById(R.id.img2);
        txt2 = (TextView) findViewById(R.id.txt2);

        cardtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actvity, gifttwo.class);
                Pair<View, String> p1 = Pair.create((View)cardtwo, "cardgift2");
                Pair<View, String> p2 = Pair.create((View)img2, "img2");
                Pair<View, String> p3 = Pair.create((View)txt2, "txt2");

                ActivityOptionsCompat option = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(actvity, p1, p2,p3);
                startActivity(intent, option.toBundle());
            }
        });

        cardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actvity, Giftone.class);
                Pair<View, String> p1 = Pair.create((View)cardOne, "cardgift1");
                Pair<View, String> p2 = Pair.create((View)img1, "img1");
                Pair<View, String> p3 = Pair.create((View)txt1, "txt1");

                ActivityOptionsCompat option = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(actvity, p1, p2,p3);
                startActivity(intent, option.toBundle());
            }
        });

    }
    @Override
    public void onBackPressed() {
        //To support reverse transitions when user clicks the device back button
        supportFinishAfterTransition();
    }
}
