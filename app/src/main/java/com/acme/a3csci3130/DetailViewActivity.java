package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetailViewActivity extends Activity {

    private EditText numberField, nameField,primaryField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        primaryField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            primaryField.setText(receivedPersonInfo.primary);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){

        String uid=receivedPersonInfo.uid;
        String name=nameField.getText().toString();
        String number = numberField.getText().toString();
        String primary = primaryField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact person = new Contact(uid,name,number,primary,address,province);

        appState.firebaseReference.child(uid).setValue(person);

        Toast.makeText(DetailViewActivity.this, "The contact has been updated!", Toast.LENGTH_SHORT).show();
        finish();

    }


    public void eraseContact(View v)
    {
        appState.firebaseReference.child( receivedPersonInfo.uid).removeValue();
        Toast.makeText(DetailViewActivity.this, "The contact has been deleted!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
