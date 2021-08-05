package com.example.mpesaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class home extends AppCompatActivity {
// declaring variables for
    private int currentBalance;


// Declaring arrays for list transactions
    private ArrayList<String>arrayListTransactions;
    private ArrayAdapter<String> arrayAdapterTransactions;



// Method to open home page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("VODACOM MPESA SERVICES");

        Intent intent = getIntent();
        String text = intent.getStringExtra(register.EXTRA_TEXT);

        TextView textView = (TextView)findViewById(R.id.textViewloginNAMES);

        textView.setText(text);

        currentBalance = 100;

        arrayListTransactions = new ArrayList<String>();
        arrayAdapterTransactions = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListTransactions);
        ListView listViewTransactions = (ListView) findViewById(R.id.transactions);
        listViewTransactions.setAdapter(arrayAdapterTransactions);
    }


// Method to open menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    // Method for selected items

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menuDeposit)
        {
            Intent intent = new Intent(this, Deposit.class);
            startActivityForResult(intent, 1);
        }
        else if(item.getItemId()==R.id.menuWithdraw)
        {
            Intent intent = new Intent(this, sendmoney.class);
            startActivityForResult(intent, 2);
        }
        else if(item.getItemId()==R.id.menuClearTransactions)
        {
            System.exit(0);
        }
        return true;
    }
// method to evaluate amount
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int amount=data.getExtras().getInt("Amount");

        if(requestCode==1 )
        {
            currentBalance += amount;
            arrayListTransactions.add("+ M"+amount);
        }
        else if(requestCode==2 && amount<=currentBalance)
        {
            currentBalance -= amount;
            arrayListTransactions.add("- M"+amount);
        }
        else
        {
            Toast.makeText(this, "Amount is Greater than Balance", Toast.LENGTH_SHORT).show();

        }
        // Display balance

        TextView textViewCurrentBalance = findViewById(R.id.textViewCurrentBalance);
        textViewCurrentBalance.setText("Current Balance: M"+currentBalance);
    }
}