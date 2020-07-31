

/*
 * base activity for calculator
 *author Andy Huang < chuan110@uottawa.ca
 *
 */


package com.example.a5_seg2105;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    //creat a activity connect to the menu and setting up when each items selected what  even t happens
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.normal:
                Toast.makeText(this, " Basic Calculator ", Toast.LENGTH_SHORT).show();
                openMainActivity();
                return true;
            case R.id.rt:
                Toast.makeText(this, "Right triangle calculator ", Toast.LENGTH_SHORT).show();
                opentrigrt();
                return true;
            case R.id.tf:
                Toast.makeText(this, " Trigonometric functions calculator ", Toast.LENGTH_SHORT).show();
                opentrigtf();
                return true;
            case R.id.questions:
                Toast.makeText(this, " Questions & Answers ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.credit:
                Toast.makeText(this, " Credit : Andy Huang University of Ottawa", Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*
     * open right triangle calculator()
     *author Andy Huang < chuan110@uottawa.ca
     *
     */
    public void opentrigrt(){
        Intent intent = new Intent(this,TrigActivity.class);
        startActivity(intent);
    }
    /*
     * open trig function calculator()
     *author Andy Huang < chuan110@uottawa.ca
     *
     */
    public void opentrigtf(){
        Intent intent = new Intent(this,Trig2Activity.class);
        startActivity(intent);
    }
    /*
     * open calculator()
     *author Andy Huang < chuan110@uottawa.ca
     *
     */
    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}