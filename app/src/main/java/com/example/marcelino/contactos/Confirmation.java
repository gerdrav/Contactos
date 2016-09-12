package com.example.marcelino.contactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class Confirmation extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion);

        Intent intent = getIntent();
        Contactos contact = (Contactos) intent.getSerializableExtra("Contact");

        TextView etNameConfirm = (TextView)findViewById(R.id.tvSetName);
        etNameConfirm.setText(contact.getContactName());
        TextView etDateConfirm = (TextView)findViewById(R.id.tvSetBirthDate);
        etDateConfirm.setText("Fecha de nacimiento: " + contact.getBirthDate());
        TextView etPhoneConfirm = (TextView)findViewById(R.id.tvSetPhone);
        etPhoneConfirm.setText("Tel: " + contact.getPhoneNumber());
        TextView etEmailConfirm = (TextView)findViewById(R.id.tvSetEmail);
        etEmailConfirm.setText("Email: " + contact.getEmail());
        TextView etDescriptionConfirm = (TextView)findViewById(R.id.tvSetDescription);
        etDescriptionConfirm.setText("Descripción: " + contact.getDescription());
    }

    public void editSettings(View v){
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        super.onBackPressed();
        //finish();
    }
}
