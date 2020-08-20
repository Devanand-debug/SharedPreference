package com.codewithdeva.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    EditText name,email;
    Button save;
    SharedPreferences preferences;

    private static final String Shared_Pref_Name="mypref";
    private static final String Key_Name="name";
    private static final String Key_Email="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=findViewById(R.id.textview);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        save=findViewById(R.id.save);

         preferences=getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);
         //when open Activity first check shared preferences data available or not.

        String sname=preferences.getString(Key_Name,null);
        if(sname!=null){
            //if data is available directly call on HomeActivity.
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);

        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //When click a button put data on shared preference.
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString(Key_Name,name.getText().toString());
                editor.putString(Key_Email,email.getText().toString());
                editor.apply();

                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}