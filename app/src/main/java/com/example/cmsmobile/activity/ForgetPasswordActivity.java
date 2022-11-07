package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.repository.AccountRepository;

import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class ForgetPasswordActivity extends AppCompatActivity {

    private AccountRepository accountRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        sendEmail = findViewById(R.id.sendEmail_forgetPasswordActivity);
        emailLabel = findViewById(R.id.emailLabel_forget_password);
        email = findViewById(R.id.mail_forgetPassword_Activity);
        accountRepository = new AccountRepository(this);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    Button sendEmail;
    private TextView emailLabel;
    private EditText email;
    String forgetPasswordEmail;
    String TokenSentToEmail;
    final String username = "dungtran12345567788@gmail.com";
    final String password = "jtjxtpitgomydxsq";
    //jtjxtpitgomydxsq \\ real abcede123

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean checkIfExisted(String account_name){
        try {
            accountRepository.getAccountByEmail(forgetPasswordEmail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void sendEmail() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        if (sendEmail.getText().toString().equals("Send Email")) {
            forgetPasswordEmail = email.getText().toString();

            if(checkIfExisted(forgetPasswordEmail)){
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Random generator = new Random(13032001);
                int randomNumber = generator.nextInt(1000000);
                Date createdTokenDate = new Date();
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText().toString()));

                message.setSubject("Recover password code");
                String encodedToken = Base64.getEncoder().encode((randomNumber + " " + createdTokenDate).getBytes()).toString();

                message.setText("Your Token is: " + encodedToken);


                Transport.send(message);
                Toast.makeText(this, "Check Your Email To Get Token Code", Toast.LENGTH_SHORT).show();
                sendEmail.setText("Enter Code");
                emailLabel.setText("Enter Your Code Sent To Email");
                email.setText("");
                TokenSentToEmail = encodedToken;
            } catch (AddressException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            }else{
                Toast.makeText(ForgetPasswordActivity.this,"This Account Name doest exist",Toast.LENGTH_LONG).show();
            }
        } else {
            if (TokenSentToEmail.equals(email.getText().toString())) {
                Intent intent = new Intent(ForgetPasswordActivity.this, RecoverPasswordActivity.class);
                intent.putExtra("account_name", forgetPasswordEmail);
                startActivity(intent);
            }

        }
    }

}