package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Maths extends AppCompatActivity {
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationCorrectAnswer;
    TextView result;
    TextView count;
    TextView timer;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button13;
    int noOfQuestions=0;
    int score=0;
    boolean click=true;

    public void playAgain(View view){
        click=true;
        button13.setVisibility(View.INVISIBLE);
        score=0;
        noOfQuestions=0;
        result.setText(" ");
        count.setText(Integer.toString(score)+ "/"+Integer.toString(noOfQuestions));
        newQuestion();
        timer.setText("30s");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000+"s"));
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                button13.setVisibility(View.VISIBLE);
                click=false;

            }
        }.start();

    }




    public void chooseAnswer(View view) {
        if (click) {
            if (Integer.toString(locationCorrectAnswer).equals(view.getTag().toString())) {
                result.setText("Correct!");
                score++;
            } else {
                result.setText("Wrong!");
            }
            noOfQuestions++;
            count.setText(Integer.toString(score) + "/" + Integer.toString(noOfQuestions));
            newQuestion();
        }
    }

    public void newQuestion(){
        TextView question=findViewById(R.id.question);
        Random rand=new Random();
        int a= rand.nextInt(50);
        int b=rand.nextInt(50);
        int result=0;
        char op='?';
        switch(rand.nextInt(4)){
            case 0:op='+';
                result=a+b;
                break;
            case 1:op='-';
                result=a-b;
                break;
            case 2:op='*';
                result=a*b;
                break;
            case 3:op='/';
                result=a/b;
                break;
        }
        question.setText(a + " " + op + " "+ b);
        locationCorrectAnswer=rand.nextInt(4);
        answers.clear();
        for(int i=0;i<4;i++){
            if(i==locationCorrectAnswer){
                answers.add(result);
            }
            else{
                int wrongAnswer=rand.nextInt(140);
                while(wrongAnswer==result){
                    wrongAnswer=rand.nextInt(140);
                }
                answers.add(wrongAnswer);
            }

        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }




    public void startFunction(View view){
        click=true;
        TextView start=findViewById(R.id.start);
        start.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
             timer.setText(String.valueOf(l/1000+"s"));
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                button13.setVisibility(View.VISIBLE);
                click=false;

            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        result=findViewById(R.id.result);
        count=findViewById(R.id.count);
        button0=findViewById(R.id.button6);
        button1=findViewById(R.id.button7);
        button2=findViewById(R.id.button8);
        button3=findViewById(R.id.button9);
        button13=findViewById(R.id.button13);
        timer=findViewById(R.id.Timer);
        button13.setVisibility(View.INVISIBLE);
        click=false;
        newQuestion();

    }
}