
/*
 * Trig function calculator
 *author Andy Huang < chuan110@uottawa.ca
 *
 */


package com.example.a5_seg2105;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Trig2Activity extends BaseActivity {
    Button calculate;
    Button clear;
    EditText input;
    TextView screen;
    double value;
    Spinner unit;
    Spinner type;
    int ctype=1;
    boolean degree =true;
    double ans;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trig2);

        //connect variables to layout
        //a spinner for the unit degree and radius
        unit = findViewById(R.id.unit);
        List<String> list = new ArrayList<>();
        list.add("Degree");
        list.add("Radians");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit.setAdapter(adapter);
        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String unitselect = adapterView.getItemAtPosition(i).toString();

                if (unitselect.equals("Degree")){
                    degree=true;
                }
                else{
                    degree=false;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // a spinner for the trig function
        type = findViewById(R.id.type);
        List<String> list2 = new ArrayList<>();
        list2.add("Sin");
        list2.add("Cos");
        list2.add("Tan");
        list2.add("Csc");
        list2.add("Sec");
        list2.add("Cot");
        list2.add("arcSin");
        list2.add("arcCos");
        list2.add("arcTan");
        list2.add("arcCsc");
        list2.add("arcSec");
        list2.add("arcCot");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter2);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String typeSelect = adapterView.getItemAtPosition(i).toString();

                if (typeSelect.equals("Sin")){
                    ctype=1;
                }
                if (typeSelect.equals("Cos")){
                    ctype=2;
                }
                if (typeSelect.equals("Tan")){
                    ctype=3;
                }
                if (typeSelect.equals("Csc")){
                    ctype=4;
                }
                if (typeSelect.equals("Sec")){
                    ctype=5;
                }
                if (typeSelect.equals("Cot")){
                    ctype=6;
                }
                if (typeSelect.equals("arcSin")){
                    ctype=7;
                }
                if (typeSelect.equals("arcCos")){
                    ctype=8;
                }
                if (typeSelect.equals("arcTan")){
                    ctype=9;
                }
                if (typeSelect.equals("arcCsc")){
                    ctype=10;
                }
                if (typeSelect.equals("arcCot")){
                    ctype=11;
                }
                if (typeSelect.equals("arcSec")){
                    ctype=12;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//connect variables to layout
        input = (EditText) findViewById(R.id.value);
        calculate = findViewById(R.id.button);
        clear = findViewById(R.id.button2);
        screen=findViewById(R.id.textView2);
        //calculate the answer base on spinner type
        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                value=Double.parseDouble(input.getText().toString());
                if(degree){
                    //convert degree to radians
                    value=Math.toRadians(value);
                }
                if( ctype==1 ) ans = Math.sin(value);
                else if( ctype==2 ) ans = Math.cos(value);
                else if( ctype==3 ) ans = Math.tan(value);
                else if( ctype==4 ) ans = 1/Math.sin(value);
                else if( ctype==5 ) ans = 1/Math.cos(value);
                else if( ctype==6 ) ans = 1/Math.tan(value);
                else if( ctype==7 ) ans = Math.asin(value);
                else if( ctype==8 ) ans = Math.acos(value);
                else if( ctype==9 ) ans = Math.atan(value);
                else if( ctype==10 ) ans = Math.asin(1/value);
                else if( ctype==11 ) ans = Math.acos(1/value);
                else ans = Math.atan(1/value);

                screen.setText(String.format("%.7g%n", ans));

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
            }
        });

    }
}