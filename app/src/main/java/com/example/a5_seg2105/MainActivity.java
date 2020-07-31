package com.example.a5_seg2105;

import  androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{
    boolean change = false;
    TextView screen;
    Button bt0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button plus;
    Button minus;
    Button times;
    Button div;
    Button clear;
    Button equal;
    Button dot;
    double v1 = 0;
    double v2 = 0;
    double ans = 0;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect variables to layout
        screen = findViewById(R.id.screen);
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        times = findViewById(R.id.times);
        div = findViewById(R.id.div);
        clear = findViewById(R.id.clear);
        equal = findViewById(R.id.equal);
        dot = findViewById(R.id.dot);

        //set click for the button
        screen.setText("0");
        bt0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("0");
                    change =false;

                } else {
                    screen.setText(screen.getText() + "0");
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("1");
                    change =false;

                }else {
                    screen.setText(screen.getText() + "1");
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("2");
                    change =false;

                }else {
                    screen.setText(screen.getText() + "2");
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("3");
                    change =false;

                } else {
                    screen.setText(screen.getText() + "3");
                }
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("4");
                    change =false;

                } else {
                    screen.setText(screen.getText() + "4");
                }
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("5");
                    change =false;

                }else {
                    screen.setText(screen.getText() + "5");
                }
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("6");
                    change =false;
                } else {
                    screen.setText(screen.getText() + "6");
                }
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("7");
                    change =false;
                } else {
                    screen.setText(screen.getText() + "7");
                }
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("8");
                    change =false;
                } else {
                    screen.setText(screen.getText() + "8");
                }
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText("9");
                    change =false;

                } else {
                    screen.setText(screen.getText() + "9");
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(screen.getText().toString().contains(".")){
                    return;
                }
                if (screen.getText().equals("0")|| change||screen.getText().equals("Over max")) {
                    screen.setText(".");
                    change =false;

                } else {
                    screen.setText(screen.getText() + ".");
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String x = screen.getText().toString();
                if(x.equals("")){
                    return;
                }
                if(x.length()>7){
                    x=x.substring(0,7);
                }

                double value = Double.parseDouble(x);
                if (v1 == 0) {
                    v1 = value;
                    operation = "+";
                    screen.setText("");
                }
                else {
                    v2=value;
                    getAns();
                    if(ans>9999999){
                        screen.setText("Over max");
                        reset();
                        return;
                    }
                    if (isInt(ans)){
                        screen.setText(String.valueOf((int)ans));
                    }
                    else {
                        screen.setText(Double.toString(ans));
                    }
                    reset();
                    change=true;
                }

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String x = screen.getText().toString();
                if(x.length()>7){
                    x=x.substring(0,7);
                }
                if(x.equals("")){
                    return;
                }
                double value = Double.parseDouble(x);
                if (v1 == 0) {
                    v1 = value;
                    operation = "-";
                    screen.setText("");
                }
                else {
                    v2=value;
                    getAns();
                    if(ans>9999999){
                        screen.setText("Over max");
                        reset();
                        return;
                    }
                    if (isInt(ans)){
                        screen.setText(String.valueOf((int)ans));
                    }
                    else {
                        screen.setText(Double.toString(ans));
                    }
                    reset();
                    change=true;
                }

            }
        });
        times.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String x = screen.getText().toString();
                if(x.length()>7){
                    x=x.substring(0,7);
                }
                if(x.equals("")){
                    return;
                }
                double value = Double.parseDouble(x);
                if (v1 == 0) {
                    v1 = value;
                    operation = "*";
                    screen.setText("");
                }
                else {
                    v2=value;
                    getAns();
                    if(ans>9999999){
                        screen.setText("Over max");
                        reset();
                        return;
                    }
                    if (isInt(ans)){
                        screen.setText(String.valueOf((int)ans));
                    }
                    else {
                        screen.setText(Double.toString(ans));
                    }
                    reset();
                    change=true;
                }

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String x = screen.getText().toString();
                if(x.length()>7){
                    x=x.substring(0,7);
                }
                if(x.equals("")){
                    return;
                }
                double value = Double.parseDouble(x);
                if (v1 == 0) {
                    v1 = value;
                    operation = "/";
                    screen.setText("");
                }
                else {
                    v2=value;
                    getAns();
                    if(ans>9999999){
                        screen.setText("Over max");
                        reset();
                        return;
                    }
                    if (isInt(ans)){
                        screen.setText(String.valueOf((int)ans));
                    }
                    else {
                        screen.setText(Double.toString(ans));
                    }
                    reset();
                    change=true;
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
                reset();
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String x = screen.getText().toString();
                if(x.length()>7){
                    x=x.substring(0,7);
                }
                if(x.equals("")){
                    return;
                }
                double value = Double.parseDouble(x);
                if (operation.equals("")) {
                    return;


                }
                else {
                    v2=value;
                    getAns();
                    if(ans>9999999){
                        screen.setText("Over max");
                        reset();
                        return;
                    }
                    if (isInt(ans)){
                        screen.setText(String.valueOf((int)ans));
                    }
                    else {
                        screen.setText(Double.toString(ans));
                    }
                    reset();
                    change=true;
                }

            }
        });

    }

    public void reset() {
        v1 = 0;
        v2 = 0;
        operation = "";
    }

    public void getAns() {
        if (operation.equals("+")) {
            ans = v1 + v2;
        }
        if (operation.equals("/")) {
            ans = v1 / v2;
        }
        if (operation.equals("*")) {
            ans = v1 * v2;
        }
        if (operation.equals("-")) {
            ans = v1 - v2;
        }
    }

    public boolean isInt(double ans) {
        return ans == (int) ans;
    }
}

