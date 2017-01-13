package com.example.user.CURIFY;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    EditText receiver,msgs,smsgs;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.fb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        msgs=(EditText)findViewById(R.id.message);
        smsgs =(EditText)findViewById(R.id.subMessage);
        b=(Button)findViewById(R.id.btnSendMessage);



        addListenerOnButton1();

    }

    private void addListenerOnButton1() {
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.i("Send email", "");
                String to = getString(R.string.admin_email);
                String msg = msgs.getText().toString();
                String sub = smsgs.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT,sub);
                email.putExtra(Intent.EXTRA_TEXT,msg);

                email.setType("message/rfc822");

                if(msg.isEmpty()==true)
                {
                    Toast.makeText(Feedback.this, "Message cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try {
                        startActivity(Intent.createChooser(email, "Send mail..."));
                        Log.i("Finished sending email...", "");
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(Feedback.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });
    }


}
