package com.cst2335.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity<emailText> extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText editText ;
public static String str = "Husan";
    public static String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.Button);
        textView=findViewById(R.id.textView1);
        editText = findViewById(R.id.editText1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          msg = editText.getText().toString();
                SharedPreferences shrd = getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();
                editor.putString(str,msg);
                editor.apply();
                editText.setText(msg);
                Intent goToProfile = new Intent( MainActivity.this,ProfileActivity.class);
                goToProfile.putExtra(str, msg);

                startActivity(goToProfile);

            }

        });
onPause();




    }

    @Override
    protected void onPause() {
        super.onPause();
     SharedPreferences getShared = getSharedPreferences("demo",MODE_PRIVATE)   ;
     String value =getShared.getString(str,"");
     editText.setHint(value);
    }
    public void openActivity(){

    }
}