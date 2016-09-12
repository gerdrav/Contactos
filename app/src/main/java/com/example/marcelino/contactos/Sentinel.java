package com.example.marcelino.contactos;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import java.util.Date;

public class Sentinel extends AppCompatActivity implements TextWatcher{
    private String inputId; //This is the identifier.
    private TextInputEditText input; //This is the TextInputEditTex

    private int day, month, year;

    private static boolean statusName = false;
    private static boolean statusDate = false;
    private static boolean statusPhone = false;
    private static boolean statusEmail = false;
    private static boolean statusDescription = false;
    Contactos contactos;

    //Main constructor
    public Sentinel(){
    }

    //Normal constructor
    public Sentinel(String id, TextInputEditText input){
        this.inputId = id;
        this.input = input;
    }

    //Date constructor
    public Sentinel (String id, int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        //Not necessary right now.
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        switch (inputId){
            case "name":
                if (charSequence.toString().matches("[a-zA-Z ]*")) {
                    statusName = true;
                    break;
                }else {
                    statusName = false;
                    try{
                        this.input.setError(input.getResources().getString(R.string.wrongCaracterName));
                        break;
                    }catch(Exception exception){
                        Toast toast = Toast.makeText(this, input.getResources().getString(R.string.wrongMessage), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

            case "phone":
                if (charSequence.toString().matches( "[0-9]*")) {
                    statusPhone = true;
                    break;
                }else{
                    statusPhone = false;
                    try{
                        this.input.setError(input.getResources().getString(R.string.wrongCaracterPhone));
                        break;
                    }catch(Exception exception){
                        Toast toast = Toast.makeText(this, input.getResources().getString(R.string.wrongMessage), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                break;
            case "email":
                  if (charSequence.toString().matches("[A-Za-z0-9. _%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{3}$")) {
                      statusEmail = true;
                      break;
                }else{
                      statusEmail = false;
                    try{
                        this.input.setError(input.getResources().getString(R.string.wrongCaracterEmail));
                        break;
                    }catch(Exception exception){
                        Toast toast = Toast.makeText(this, input.getResources().getString(R.string.wrongMessage), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                break;
            case "description":
                if (charSequence.toString() != "") {
                    statusDescription = true;
                    break;
                }else{
                    statusDescription = false;
                    try{
                        this.input.setError(input.getResources().getString(R.string.wrongDescriptionMessage));
                        break;
                    }catch(Exception exception){
                        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrongMessage), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                break;
            default: //Not necessary right now.
        }
    }
    @Override
    public void afterTextChanged(Editable charSequence) {
        //Not necessary right now.
    }

    public boolean isValid() {
        if(this.statusName && this.statusPhone  && this.statusEmail && this.statusDescription)
            return true;
        else
            return false;
    }

}
