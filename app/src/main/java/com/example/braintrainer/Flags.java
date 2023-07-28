package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Flags extends AppCompatActivity {
    TextView start;
    ImageView flag;
    int locationCorrectAnswers;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView timer;
    TextView done;
    TextView playAgain;
    TextView comment;
    int question=0;
    int score=0;
    int num;
    TextView count;
    boolean click=true;
    List<Integer> images = Arrays.asList(R.drawable.india, R.drawable.sk, R.drawable.uk, R.drawable.malaysia, R.drawable.usa,R.drawable.angola,R.drawable.canada,R.drawable.bahrain,R.drawable.brazil,R.drawable.germany,
                                        R.drawable.argentina,R.drawable.cuba,R.drawable.egypt,R.drawable.denmark,R.drawable.nepal,R.drawable.maldives,R.drawable.lesotho,R.drawable.iraq,R.drawable.fiji,R.drawable.srilanka,
                                        R.drawable.seychellas,R.drawable.qatar,R.drawable.saudi,R.drawable.southafrica,R.drawable.vietnam,R.drawable.uganda,R.drawable.bhutan,R.drawable.mongolia,R.drawable.greece,R.drawable.newzealand,R.drawable.australia);
    List<String> name = Arrays.asList("India", "South Korea", " United Kingdom", "Malaysia", "USA","Angola","Canada","Bahrain","Brazil","Germany","Argentina","Cuba","Egypt","Denmark","Nepal","Maldives",
                                        "Lesotho","Iraq","Fiji","Sri Lanka","Seychellas","Qatar","Saudi Arabia","South Africa","Vietnam","Uganda","Bhutan","Mongolia","Greece","New Zealand","Australia");
    ArrayList<String> answers = new ArrayList<String>();
    List<String> wrongOption = Arrays.asList("Antartica", "Albania", "Algeria", "Zimbave", "Dubai","Bahamas","Belgium","China","North Korea","Ethiopia","France","Indonesia","Ireland","Libya","Mexico","Netherlands","Nigeria","Norway","Oman","Phillippines","Portugal","Sweden","Switzerland","Thailand","Turkey","Yemen");

    public void startMethod(View view) {
        click=true;
        start.setVisibility(View.INVISIBLE);

        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
              timer.setText(String.valueOf(l/1000+"s"));
            }

            @Override
            public void onFinish() {
                done.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
                click=false;
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                comment.setVisibility(View.INVISIBLE);
                flag.setVisibility(View.INVISIBLE);

            }
        }.start();
    }

    public void correctAnswer(View view) {
        comment.setVisibility(View.VISIBLE);


        if (click) {
            if (Integer.toString(locationCorrectAnswers).equals(view.getTag().toString())) {
                comment.setText("Correct!");
                score++;

            } else {
                comment.setText("Wrong!: "+name.get(num));

            }
            question++;
            count.setText(score + "/" + question);
            newQuestion();

        }
    }


    public void newQuestion() {
        flag = (ImageView) findViewById(R.id.imageView2);
        String result = null;
        String wrong = null;
        Random rand = new Random();
        num = rand.nextInt(31);
        flag.setImageResource(images.get(num));
        locationCorrectAnswers = rand.nextInt(4);
        answers.clear();
        for (int i = 0; i < 4; i++) {
            if (i == locationCorrectAnswers) {
                result = name.get(num);
                answers.add(result);

            } else {
                int wrongAnswers = rand.nextInt(26);
                while (wrongAnswers == locationCorrectAnswers || answers.contains(wrongOption.get(wrongAnswers))) {
                    wrongAnswers = rand.nextInt(26);
                }
                wrong = wrongOption.get(wrongAnswers);
                answers.add(wrong);


            }
        }
        button0.setText(answers.get(0));
        button1.setText(answers.get(1));
        button2.setText(answers.get(2));
        button3.setText(answers.get(3));
    }

    public void playAgain(View view){
        click=true;
        done.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        flag.setVisibility(View.VISIBLE);
        comment.setText("");
        score=0;
        question=0;
        count.setText(score+"/"+question);
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000+"s"));
            }

            @Override
            public void onFinish() {
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                comment.setVisibility(View.INVISIBLE);
                flag.setVisibility(View.INVISIBLE);
                done.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
                click=false;

            }
        }.start();
        newQuestion();



    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);
        start = (TextView) findViewById(R.id.start);
        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        comment=(TextView)findViewById(R.id.textView2);
        timer=(TextView)findViewById(R.id.timer);
        done=(TextView)findViewById(R.id.textView7);
        playAgain=(TextView)findViewById(R.id.playAgain);
        count=(TextView)findViewById(R.id.count);
        comment.setVisibility(View.INVISIBLE);
        click=false;
        newQuestion();

    }
}




