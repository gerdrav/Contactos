package com.example.marcelino.contactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TextInputEditText nameInput;
    private TextInputEditText phoneInput;
    private TextInputEditText emailInput;
    private TextInputEditText descriptionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * I do send nameInput and the identifier to a Sentinel class which implements a TextWatcher.
         * All this on a addTextChangedLister.
         * in this way will be listening to each key is pressed and display an error if necessary.         */
        //
        nameInput = (TextInputEditText) findViewById(R.id.etName);
        nameInput.addTextChangedListener(new Sentinel("name", nameInput));

        phoneInput = (TextInputEditText) findViewById(R.id.etPhoneNumber);
        phoneInput.addTextChangedListener(new Sentinel("phone",phoneInput));

        emailInput = (TextInputEditText)findViewById(R.id.etEmail);
        emailInput.addTextChangedListener(new Sentinel("email",emailInput));

        descriptionInput = (TextInputEditText) findViewById(R.id.etDescription);
        descriptionInput.addTextChangedListener(new Sentinel("description", descriptionInput));
    }

    public void nextOnClic(View v){
        try {
            if (new Sentinel().isValid()) {

                Contactos contacto = new Contactos(
                        nameInput.getText().toString(),
                        setDate(),
                        phoneInput.getText().toString(),
                        emailInput.getText().toString(),
                        descriptionInput.getText().toString());

                //Declare intet to Confirmation.class
                Intent intent = new Intent(this, Confirmation.class);
                //Sending complete object to Confirmation.class
                intent.putExtra("Contact", (Serializable) contacto);
                startActivity(intent);

            } else {
                Toast toast = Toast.makeText(getBaseContext(), "Faltan datos por llenar", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        catch (Exception e){
            System.out.println(getResources().getString(R.string.wrongMessage));
        }
    }

    private String setDate(){
        datePicker = (DatePicker) findViewById(R.id.dpBirthDate);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; //This is because months start from zero and finish on eleven.
        int year = datePicker.getYear();
        return day + "/" + month + "/" + year;

    }
}
