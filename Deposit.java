package com.example.mpesaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class Deposit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);


        Button button =(Button) findViewById(R.id.bac);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openhome();
            }
        });
    }

    public  void openhome()
    {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    // Method for depositing

    public void depositClick(View v)
    {
        EditText depo =(EditText) findViewById(R.id.depo);
        int depositAmount = 0;


        try {
                depositAmount = parseInt(depo.getText().toString());
        }catch (Exception ex)
        {
            Toast.makeText(this, "Please Enter A valid Amount", +1000).show();
        }
        Intent intent = getIntent();
        intent.putExtra("Amount", depositAmount);

        setResult(RESULT_OK,intent);
        finish();
    }
}