package com.example.p_two;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usuario, contraseña;
    Button login, clear;
    TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.user);
        contraseña = (EditText) findViewById(R.id.password);
        message = (TextView) findViewById(R.id.message);
        login = (Button) findViewById(R.id.login);
        clear = (Button) findViewById(R.id.clear);

    }

    public void Login() {
        if(usuario.getText().toString().equals("isafco") && contraseña.getText().toString().equals("123456"))
        {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"EL usuario o la contraseña están incorrectos.",Toast. LENGTH_SHORT).show();
        }
    }

    public void Clear() {
        usuario.setText("");
        contraseña.setText("");
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login:
                Login();
                break;

            case R.id.clear:
                Clear();
                break;

        }
    }
}

