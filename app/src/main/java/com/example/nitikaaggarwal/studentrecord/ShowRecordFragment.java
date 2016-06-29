package com.example.nitikaaggarwal.studentrecord;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class ShowRecordFragment extends Fragment {
            EditText numberEditText;
            TextView nameTextView;
    SQLiteDatabase db;
    DatabaseHandler mDbHelper;

    Button show;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_show_record, container, false);
        InitViews(rootView);
        return rootView;
    }
    public void InitViews(View rootView)
    {
        numberEditText = (EditText) rootView.findViewById(R.id.show_record_phone_ev);
        nameTextView = (TextView) rootView.findViewById(R.id.show_name_tv);
        show = (Button) rootView.findViewById(R.id.show_button);

         mDbHelper = new DatabaseHandler(getContext());

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String number = numberEditText.getText().toString();

//               mDbHelper.getContact(number);
//                nameTextView.setText( mDbHelper.getContact(number).getName());
//               if( mDbHelper.getContact(number).getName().equals(null))
//               {
//                   nameTextView.setText(" No data found");
//               }

                if (!(mDbHelper.getContact(number).getName().equals(null ))) {
                    nameTextView.setText(mDbHelper.getContact(number).getName());
                }else
                {
                    nameTextView.setText(" No data found");
                }





//                if (mDbHelper.getContact(number)!=null){
//                    nameTextView.setText( mDbHelper.getContact(number).getName());
//                }
//                else
//                {
//                    nameTextView.setText("Sorry no record found for this n");
//                }

            }
        });
    }


}
