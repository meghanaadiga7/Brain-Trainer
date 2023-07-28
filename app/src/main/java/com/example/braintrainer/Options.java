package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Options extends AppCompatActivity {
    CardView math;
   // CardView kdrama;
    CardView flags;
    public void mathButton(View view){
        Intent i=new Intent(Options.this,Maths.class);
        startActivity(i);
    }
   /* public void kdramaMethod(View view){
        Intent i=new Intent(Options.this,Kdrama.class);
        startActivity(i);
    }*/

    public void flagMethod(View view){
        Intent i=new Intent(Options.this,Flags.class);
        startActivity(i);
    }

    public void marvelMethod(View view){
        Intent i=new Intent(Options.this,Marvels.class);
        startActivity(i);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        math=(CardView)findViewById(R.id.math);
        //kdrama=(CardView)findViewById(R.id.kdrama);
        flags=(CardView)findViewById(R.id.flags);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


    }
