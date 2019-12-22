package com.example.a38_nguyenbavan_lap5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtpassword,edtuser;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtpassword = findViewById(R.id.edtpassword);
        edtuser = findViewById(R.id.edtuser);
        btnLogin = findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dem=0;
                int dem2=0;
                int dem3=0;
                int dem4=0;
                String strpassword = edtpassword.getText().toString();
                String struser = edtuser.getText().toString();
                if(struser.length()==0) {
                    edtpassword.setError("Your User");

                }
                for (int i=0; i<strpassword.length();i++){


                    if ((strpassword.codePointAt(i)>=48)&&(strpassword.codePointAt(i)<=57)){
                        dem++;
                    }
                    if ((strpassword.codePointAt(i)>=65)&&(strpassword.codePointAt(i)<=90)){
                        dem2++;
                    }
                    if ((strpassword.codePointAt(i)>=97)&&(strpassword.codePointAt(i)<=122)){
                        dem3++;
                    }
                    if ((strpassword.codePointAt(i)>0)&&(strpassword.codePointAt(i)<48)
                            ||(strpassword.codePointAt(i)>57)&&(strpassword.codePointAt(i)<65)
                            ||(strpassword.codePointAt(i)>90)&&(strpassword.codePointAt(i)<97)||
                            (strpassword.codePointAt(i)>122)&&(strpassword.codePointAt(i)<255)){
                        dem4++;
                    }
                }


                if(strpassword.length()==0) {
                    edtpassword.setError("Your Password");

                }
                else
                if(strpassword.length()<6)
                {
                    edtpassword.setError("Your Password Must Have 6 Characters");
                }
                else
                if(  dem ==0){
                    edtpassword.setError("Your Password Must Have 1 Number");
                }
                else if(dem2 ==0){
                    edtpassword.setError("Your Password Must Have 1 uppercase characters");
                }
                else if(dem3 ==0){
                    edtpassword.setError("Your Password Must Have 1 lowercase characters");
                }
                else if(dem4 ==0){
                    edtpassword.setError("Your Password Must Have 1 Special characters");
                }
                else{
                    Toast.makeText(MainActivity.this, "Username: admin      Password: Admin123*", Toast.LENGTH_SHORT).show();
                }
                if(struser.equals("admin")==true&&strpassword.equals("Admin123*")==true){
                    Intent intent = new Intent(getBaseContext(),FoodOrder.class);
                    startActivity(intent);
                }
            }
        });

    }
}
