
/*
 * right triangle calculator
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
// right triangle calculator base o given information find angle and side for the triangle
public class TrigActivity extends BaseActivity {
    Button calculate;
    Button reset;
    double sideA;
    double sideB;
    double sideC;
    double angleA;
    double angleB;
    EditText sideAinput;
    EditText sideBinput;
    EditText sideCinput;
    EditText angleAinput;
    EditText angleBinput;
    Spinner unit;
    boolean degree =true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trig);

        //connect variables to layout
        //spinner for the unit
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
        sideAinput = (EditText) findViewById(R.id.sa);
        sideBinput = (EditText) findViewById(R.id.sb);
        sideCinput = (EditText) findViewById(R.id.sc);
        angleAinput = (EditText) findViewById(R.id.aa);
        angleBinput = (EditText) findViewById(R.id.ab);
        calculate = findViewById(R.id.button);
        reset = findViewById(R.id.button2);

        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                angleB=0;
                sideA=0;
                sideB=0;
                sideC=0;
                angleA=0;
                if(!"".equals(sideAinput.getText().toString())){
                    sideA=Double.parseDouble(sideAinput.getText().toString());
                }
                if(!"".equals(sideBinput.getText().toString())){
                    sideB=Double.parseDouble(sideBinput.getText().toString());
                }
                if(!"".equals(sideCinput.getText().toString())){
                    sideC=Double.parseDouble(sideCinput.getText().toString());
                }
                if(!"".equals(angleAinput.getText().toString())){
                    angleA=Double.parseDouble(angleAinput.getText().toString());
                }
                if(!"".equals(angleBinput.getText().toString())){
                    angleB=Double.parseDouble(angleBinput.getText().toString());
                }
                if (checkForValidInput())
                {
                    if (sfa()){
                        sfs();
                    }
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angleBinput.setText("");
                angleAinput.setText("");
                sideAinput.setText("");
                sideBinput.setText("");
                sideCinput.setText("");
            }
        });



    }
    // * radian to degree()
    // *author Andy Huang < chuan110@uottawa.ca
    // *
    // */
    public double radToDegree(double value){
        return (value*180/Math.PI);
    }

    /*
     * check to see user input is valid
     *author Andy Huang < chuan110@uottawa.ca
     *
     */
    public boolean checkForValidInput(){
        // check to see if both angles were input and they don't add up to 90 degree
        if (angleA>0 && angleB>0){
            double sum = angleA+angleB;
            if(sum != 90){
                Toast.makeText(this, "You input two angles that do not add up to 90 degrees."+"\n"+" Please input only one angle or two angles that add up to 90 degrees", Toast.LENGTH_SHORT).show();

                return false;
            }
        }
        // check to see if three sides make a right triangle
        if (sideA>0 && sideB>0 && sideC>0){
            if (sideC != Math.sqrt(Math.pow(sideA,2)+Math.pow(sideB,2))){
                Toast.makeText(this, "You input three sides, but they do not make a right triangle", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;

    }
    /*
     * solves for angle()
     *author Andy Huang < chuan110@uottawa.ca
     *
     */
    public boolean sfa (){
        //use give information to find angle
        if (angleA>0) {
            angleB = 90 - angleA;
        }
        else if (angleB>0) {
            angleA = 90 - angleB;
        }
        else if (sideA>0 && sideB>0){
            angleA = radToDegree(Math.atan (sideA/sideB));
            angleB = radToDegree(Math.atan (sideB/sideA));
        }
        else if (sideA>0 && sideC>0){
            angleA = radToDegree(Math.asin (sideA/sideC));
            angleB = radToDegree(Math.acos (sideA/sideC));
        }
        else if (sideB>0 && sideC>0){
            angleA = radToDegree(Math.acos (sideB/sideC));
            angleB = radToDegree(Math.asin (sideB/sideC));
        }
        if (angleA>0 && angleB>0){
            if(degree) {
                //display degree round to 7decimal place
                angleBinput.setText(String.format("%.7g%n", angleB));
                angleAinput.setText(String.format("%.7g%n", angleA));
            }
            else{
                //display radius
                angleBinput.setText(Double.toString(Math.toRadians(angleB)));
                angleAinput.setText(Double.toString(Math.toRadians(angleA)));
            }
            //set angle to rad
            angleA=Math.toRadians(angleA);
            angleB=Math.toRadians(angleB);

            return true;
        }
        else {
            Toast.makeText(this, "Not enough information, you must input at least 1 side and an angle or 2 sides", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    /*
     * solve for sides()
     *author Andy Huang < chuan110@uottawa.ca
     *
     */
    public void sfs (){
        if (sideA>0){
            sideB = sideA/Math.tan(angleA);
            sideC = sideA/Math.sin(angleA);
        }
        else if (sideB>0){
            sideA = sideB/Math.tan(angleB);
            sideC = sideB/Math.sin(angleB);
        }

        else if (sideC>0){
            sideA = sideC*Math.sin(angleA);
            sideB = sideC*Math.cos(angleA);
        }
        if (sideA>0 && sideB>0 && sideC>0){
            // display sides and round to 5 decimal place
            sideAinput.setText(String.format("%.5g%n", sideA));
            sideBinput.setText(String.format("%.5g%n", sideB));
            sideCinput.setText(String.format("%.5g%n", sideC));
            return;
        }
        else {
            Toast.makeText(this, "You must input at least 1 side and an angle or 2 sides", Toast.LENGTH_SHORT).show();
            sideAinput.setText(Double.toString(sideA));
            sideBinput.setText(Double.toString(sideB));
            sideCinput.setText(Double.toString(sideC));
        }

    }


}