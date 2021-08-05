package com.example.mpesaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class sendmoney extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        Button button5 = (Button) findViewById(R.id.back1);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhome1();
            }
        });
    }

    public void openhome1()
    {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    //Method for widrawal amount

    public void withdrawClick(View v)
    {
        EditText with =(EditText) findViewById(R.id.with);
        int withdrawAmount = 0;

        try {
            withdrawAmount = parseInt(with.getText().toString());
        }catch (Exception ex)
        {
            Toast.makeText(this, "Please Enter A valid Amount", 1000).show();
        }
        Intent intent = getIntent();
        intent.putExtra("Amount", withdrawAmount);

        setResult(RESULT_OK,intent);
        finish();
    }
}