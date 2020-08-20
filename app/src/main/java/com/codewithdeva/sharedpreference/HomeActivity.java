package com.codewithdeva.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    TextView textView,name,email;
    Button logout;
    SharedPreferences preferences;

    private static final String Shared_Pref_Name="mypref";
    private static final String Key_Name="name";
    private static final String Key_Email="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView=findViewById(R.id.textview);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        logout=findViewById(R.id.logout);

        preferences=getSharedPreferences(Shared_Pref_Name,MODE_PRIVATE);

        String sname=preferences.getString(Key_Name,null);
        String semail=preferences.getString(Key_Email,null);

        if(sname!=null || semail!=null){
            //so set the data on textview
            name.setText("Full Name - "+ sname);
            email.setText("Email ID - " + semail);

            //so call to button for logout
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SharedPreferences.Editor editor=preferences.edit();
                    editor.clear();
                    editor.commit();
                    Toast.makeText(HomeActivity.this, "Log Out Successful", Toast.LENGTH_SHORT).show();
                    finish();

                }
            });
        }


    }
}