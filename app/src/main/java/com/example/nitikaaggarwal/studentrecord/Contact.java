package com.example.nitikaaggarwal.studentrecord;

/**
 * Created by nitikaaggarwal on 28/06/16.
 */
public class Contact {
        String _name;
    long _phone_number;

        // Empty constructor
        public Contact(){

        }
        // constructor
        public Contact( long number){
            this._phone_number = number;
        }
    public Contact( String name){
        this._name = name;
    }
        // constructor
        public Contact(String name, long _phone_number){
            this._name = name;
            this._phone_number = _phone_number;
        }


        // getting name
        public String getName(){
            return this._name;
        }

        // setting name
        public void setName(String name){
            this._name = name;
        }

        // getting phone number
        public long getPhoneNumber(){
            return this._phone_number;
        }

        // setting phone number
        public void setPhoneNumber(long phone_number){
            this._phone_number = phone_number;
        }
}
