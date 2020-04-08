package com.example.dialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TrimDialogFragment.TrimDialogListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button inputBTN = findViewById(R.id.inputBTN);
        inputBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button click", "Clicked the button");

                EditText inputET = findViewById(R.id.inputET);
                String theInput = inputET.getText().toString();

                if(theInput.equals(""))
                {
                    usePlainInput();
                }
                else if (theInput.charAt(0)==' ' || theInput.charAt(theInput.length()-1)==' ')
                {
                    TrimDialogFragment trimDF = new TrimDialogFragment();
                    trimDF.show(getSupportFragmentManager(), null);
                }
                else
                {
                    usePlainInput();
                }
            }
        });
    }

    @Override
    public void useTrimmedInput()
    {
        Log.d("Callback", "Positive button callback invoked");
        EditText inputET = findViewById(R.id.inputET);
        String theInput = inputET.getText().toString().trim();
        TextView resultTV = findViewById(R.id.resultTV);
        resultTV.setText("<<" + theInput + ">>");
    }

    @Override
    public void usePlainInput()
    {
        Log.d("Callback", "Negative button callback invoked");
        EditText inputET = findViewById(R.id.inputET);
        String theInput = inputET.getText().toString();
        TextView resultTV = findViewById(R.id.resultTV);
        resultTV.setText("<<" + theInput + ">>");
    }
}
