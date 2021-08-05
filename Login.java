package com.example.mpesaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MPESA SERVICES");

        //Declaring buttons

        EditText editText=(EditText) findViewById(R.id.logincontacts);
        EditText editText1=(EditText) findViewById(R.id.loginpincode);



        Button button =(Button) findViewById(R.id.buttonbackreg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRegister();
            }
        });
        //Login button that will validate inputs
        Button button1 =(Button) findViewById(R.id.butnlogin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone=editText.getText().toString();
                String pincode=editText1.getText().toString();

                Intent intent=getIntent();

                String con=intent.getStringExtra("con");
                String code=intent.getStringExtra("code");
                if (phone.equals(con)&& pincode.equals(code))
                {
                    openhome();
                }
                else{
                    recreate();

                }




            }
        });
}
// Registration method

    public void openRegister()
    {
        Intent intent = new Intent(this, welcome.class);
        startActivity(intent);
    }
    //Method to open home

    public void openhome()
    {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}