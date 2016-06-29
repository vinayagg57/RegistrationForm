package com.example.nitikaaggarwal.studentrecord;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistrationFragment extends Fragment {

    EditText mobileEditText,nameEditText;
    Button Save;
    DatabaseHandler db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);
        InitViews(rootView);
        return rootView;
    }

    private void InitViews(View rootView) {
        mobileEditText = (EditText) rootView.findViewById(R.id.phone_number_et);
        nameEditText = (EditText) rootView.findViewById(R.id.name_et);
        Save = (Button) rootView.findViewById(R.id.save_btn);
       db = new DatabaseHandler(getActivity());

        Save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name = mobileEditText.getText().toString();
        String number = nameEditText.getText().toString();
        db.addContact(new Contact(name, number));
Toast.makeText(getActivity(),"Data Addaed",Toast.LENGTH_LONG).show();

        Fragment showRecord = new ShowRecordFragment();
        FragmentTransaction ft  = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, showRecord);
        ft.addToBackStack(null);
        ft.commit();


    }
});
    }

}