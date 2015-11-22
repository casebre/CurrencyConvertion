package com.example.rafael.currencyconvertion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float cad = (float) 2.92;

    public boolean validateField(){
        RadioButton radioOriginalCur = (RadioButton) findViewById(R.id.radioButtonOriginal);
        RadioButton radioFinalCur = (RadioButton) findViewById(R.id.radioButtonCurrency);
        EditText textAmount = (EditText) findViewById(R.id.editTextAmount);

        if (radioOriginalCur.isChecked()
                && radioFinalCur.isChecked()
                && textAmount.length() > 0
                && Float.parseFloat(textAmount.getText().toString()) >= 0)
            return true;
        else
            return false;
    }

    public void clickConvert(View view){
        TextView result = (TextView) findViewById(R.id.textViewResult);
        Float convertion = (float)0.0;

        if (validateField()) {
            EditText textAmount = (EditText) findViewById(R.id.editTextAmount);
            convertion = Float.parseFloat(textAmount.getText().toString()) * cad;
            result.setText(Float.toString(convertion));
            Toast.makeText(getApplicationContext(), "CAD " + Float.toString(convertion), Toast.LENGTH_LONG).show();
        }
        else {

            result.setText("Fill out all fields properly");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
