package com.example.smartfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button accedi;
    private EditText email;
    private EditText password;
    MainActivity mainActivity;
    private TextView smarrita;
    private TextView registrazione;
    private String account_email=email.getText().toString();
    private String account_password=password.getText().toString();

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accedi = findViewById(R.id.accedi);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        smarrita = findViewById(R.id.smarrita);

    }

    public void missPassword(View view) {
        final EditText edittext = new EditText(mainActivity.getApplicationContext());
        edittext.setInputType(InputType.TYPE_CLASS_PHONE);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cambio password");
        builder.setMessage("Inserisci la tua e-mail e le invieremo le modalità per il cambio password");
        builder.setView(edittext);

        // Set up the buttons
        builder.setPositiveButton("Conferma e-mail", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }

    public void checkLogin() {
        if (account_email.equals("giacomomancini@gmail.com")) {
            if (account_password.equals("ciaociao")) {
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent);
            }
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(mainActivity);
            alert.setTitle("Errore");
            alert.setMessage("Email o password errati");
            alert.show();
        }
    }

    public void goRegistrazione(View view) {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }
}
