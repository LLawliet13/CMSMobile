package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cmsmobile.R;

import java.util.Properties;

public class ForgetPasswordActivity extends AppCompatActivity {

    TextView forgetPassword;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        forgetPassword = findViewById(R.id.mail_forgetPassword_Activity);
        sendEmail = findViewById(R.id.sendEmail_forgetPasswordActivity);
    }
    private EditText email;
    private void checkIfExist(){

    }
    final String username = "abc678xyzdung@gmail.com";
    final String password = "abcede123";
    String messageToSend = "";
    private void sendEmail(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
    }

}