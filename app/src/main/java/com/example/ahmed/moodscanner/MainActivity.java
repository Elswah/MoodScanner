package com.example.ahmed.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;




public class MainActivity extends ActionBarActivity {
ImageView imageView;
    TextView textView;
    Runnable runnable;
    AnimationDrawable animationDrawable;
    String[]moods={"happy","nervious","Good","Smile","Sad"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView2);
        textView=(TextView)findViewById(R.id.textView_result);

        imageView.setBackgroundResource(R.drawable.animation);
        animationDrawable=(AnimationDrawable)imageView.getBackground();

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //start animation
                animationDrawable.start();
                showResult();
                return true;
            }
        });

    }
    public  void showResult(){
        runnable=new Runnable() {
            @Override
            public void run() {
         int random= (int) (Math.random()*moods.length);
                textView.setText(moods[random]);
                //stop animation after result
                animationDrawable.stop();
            }
        };
        android.os.Handler handler=new android.os.Handler();
        handler.postDelayed(runnable,5000);

    }



}
