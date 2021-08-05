package com.example.mpesaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class register extends AppCompatActivity {
    public static  final  String EXTRA_TEXT = "com.example.application.mpesaapplication.EXTRA_TEXT";
// Declaring edittexts holding user information
    EditText name,surname,contacts,pin;

//Initialize all variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("MPESA SERVICES");



        name=(EditText) findViewById(R.id.registername);
        surname=(EditText)findViewById(R.id.registersurname);
        contacts=(EditText)findViewById(R.id.registercontacts);
        pin=(EditText)findViewById(R.id.registerpin);

        Button button1=(Button) findViewById(R.id.reghomeback);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openLogin();
            }
        });
        //Register new user

        Button button2=(Button) findViewById(R.id.butnreg);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name=name.getText().toString();
                String Surname=surname.getText().toString();
                String Contacts=contacts.getText().toString();
                String Pin=pin.getText().toString();
                if (name.equals("")||surname.equals("")||contacts.equals("")||pin.equals(""))
                {

                    Toast.makeText(register.this, "Please fill in all spaces",+1000).show();
                }
                else {
                    openLogin1();

                }


            }
        });



    }
    //Open login method

    public void openLogin()
    {
        Intent intent = new Intent(this, welcome.class);
        startActivity(intent);
    }
    //Method to open login1
    public void openLogin1()
    {
        EditText editText = (EditText)findViewById(R.id.registername);
        String text = editText.getText().toString();

        Intent intent = new Intent(this, home.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);

    }

}