package com.example.nitikaaggarwal.studentrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mobileEditText,nameEditText;
    Button Save, Search;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileEditText = (EditText) findViewById(R.id.phone_number_et);
        nameEditText = (EditText) findViewById(R.id.name_et);
        Save = (Button) findViewById(R.id.save_btn);
        Search = (Button) findViewById(R.id.search_btn);
        db = new DatabaseHandler(this);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRecordActivity.class);
                intent.putExtra("keyName","value");
                startActivity(intent);
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                long number=0;
                String name=null;
                try{
                    number = Long.parseLong(mobileEditText.getText().toString());
                    name = nameEditText.getText().toString();
                    db.addContact(new Contact(name, number));
                    Toast.makeText(getApplicationContext(),"Data Addaed",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, ShowRecordActivity.class);
                    intent.putExtra("keyName","value");
                    startActivity(intent);

                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Please fill data",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
