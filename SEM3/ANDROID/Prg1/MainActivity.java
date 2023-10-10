package com.example.a29v2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.a29v2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    EditText user,pwd;
    String u="Alen";
    String p="123";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

    }

    public void verify(View v){
        if (v.getId()==R.id.txtid3) {
            user = (EditText) findViewById(R.id.txtid);
            pwd = (EditText) findViewById(R.id.txtid1);
            String a = user.getText().toString();
            String b = pwd.getText().toString();
            if (a.equals(u) && b.equals(p))
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show();

        }

    }
}