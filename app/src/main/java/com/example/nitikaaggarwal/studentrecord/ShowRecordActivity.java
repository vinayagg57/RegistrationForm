package com.example.nitikaaggarwal.studentrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowRecordActivity extends AppCompatActivity {
    EditText numberEditText;
    TextView nameTextView;
    DatabaseHandler mDbHelper;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record);

        numberEditText = (EditText) findViewById(R.id.show_record_phone_ev);
        nameTextView = (TextView) findViewById(R.id.show_name_tv);
        show = (Button) findViewById(R.id.show_button);

        mDbHelper = new DatabaseHandler(this);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = numberEditText.getText().toString();

                if (mDbHelper.getContact(number)!=null && mDbHelper.getContact(number).getName()!=null ) {
                    nameTextView.setText(mDbHelper.getContact(number).getName());
                }else
                {
                    nameTextView.setText(" No Name found for this number");
                }
            }
        });

    }
}
