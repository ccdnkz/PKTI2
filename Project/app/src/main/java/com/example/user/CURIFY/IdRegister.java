package com.example.user.CURIFY;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 12/18/2016.
 */

public class IdRegister extends Activity implements View.OnClickListener{

    DbHelper helper = new DbHelper(this);
    Button btnRegister;
    EditText input_name, input_email, input_pw, input_cpw, input_addr;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_register);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        input_name = (EditText) findViewById(R.id.input_name);
        input_email = (EditText) findViewById(R.id.input_email);
        input_pw = (EditText) findViewById(R.id.input_pw);
        input_cpw = (EditText) findViewById(R.id.input_cpw);
        input_addr = (EditText) findViewById(R.id.input_addr);

        switch (v.getId()){
            case R.id.btnRegister:
                String uname = input_name.getText().toString();
                String email = input_email.getText().toString();
                String pw = input_pw.getText().toString();
                String cpw = input_cpw.getText().toString();
                String addr = input_addr.getText().toString();

                if(!pw.equals(cpw)) {
                    //pop-up msg
                    Toast pass = Toast.makeText(IdRegister.this, "Passwords don't match", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else if(pw.isEmpty()==true || cpw.isEmpty()==true || uname.isEmpty()==true || email.isEmpty()==true) {
                    Toast.makeText(IdRegister.this, "Some data is still empty. Please fill it", Toast.LENGTH_SHORT).show();
                }
                else{
                    //insert details in db
                    DbContact c = new DbContact();
                    c.setUname(uname);
                    c.setEmail(email);
                    c.setPw(pw);
                    c.setAddr(addr);

                    helper.insertContact(c);

                    startActivity(new Intent(this, IdLogin.class));
                    this.finish();
                }
                break;
            default:
                startActivity(new Intent(this, Home.class));
                break;
        }
    }
}
