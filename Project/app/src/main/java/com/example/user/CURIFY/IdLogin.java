package com.example.user.CURIFY;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 12/18/2016.
 */

public class IdLogin extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnRegister;
    DbHelper helper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(IdLogin.this, IdRegister.class);
                startActivity(i);
            }
        });;

        //Hide Show Password]
        final EditText ed = (EditText) findViewById(R.id.input_pw);
        CheckBox c = (CheckBox) findViewById(R.id.checkBox);

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (!isChecked) {
                    ed.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    ed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        /*if (v.getId() == R.id.btnLogin) {
            EditText a = (EditText) findViewById(R.id.input_name);
            String stra = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.input_pw);
            String strb = b.getText().toString();

            String password = helper.searchPass(stra);
            if (strb.equals(password)) {
                Intent i = new Intent(IdLogin.this, Home.class);
                i.putExtra("Username", stra);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(IdLogin.this, "Username or Passwords don't match", Toast.LENGTH_LONG);
                temp.show();
            }
        }*/
            EditText a = (EditText) findViewById(R.id.input_name);
            String stra = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.input_pw);
            String strb = b.getText().toString();
            if(stra.isEmpty()==true)
            {
                Toast.makeText(IdLogin.this,"Please insert your username!",Toast.LENGTH_LONG).show();
            }
            else if(strb.isEmpty()==true)
            {
                Toast.makeText(IdLogin.this,"Please insert your password!",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent i = new Intent(IdLogin.this,Home.class);
                i.putExtra("usnm",stra);
                startActivity(i);
                this.finish();
            }

    }
    



    public void onRegisterClick(View v) {
        if (v.getId() == R.id.btnRegister) {
            Intent i = new Intent(this, IdRegister.class);
            startActivity(i);
        }
    }
}

    /*Keterangan Button IdLogin
    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View arg0) {

            if(input_email.getText().toString().equals(""))
            {
                Toast.makeText(Home.this, "Input your e-mail", Toast.LENGTH_SHORT).show();
            }
            if(input_pw.getText().toString().equals(""))
            {
                Toast.makeText(Home.this, "Input your password", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Home.this, "Input Tidak Kosong", Toast.LENGTH_SHORT).show();
            }
        }
    });*/
