package cd.wayupdev.project_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edMatricule = findViewById(R.id.editTextMatricule);
        EditText edPassword = findViewById(R.id.edittext_password);

        Button boutonLogin = findViewById(R.id.button_login);
        progressBar = findViewById(R.id.progress_bar);

        // 16AB005
        boutonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matricule = edMatricule.getText().toString();
                String password = edPassword.getText().toString();

                if (matricule.isEmpty()) {
                    Toast.makeText(
                            LoginActivity.this,
                            "Le matricule ne doit pas etre vide",
                            Toast.LENGTH_LONG
                    ).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(
                            LoginActivity.this,
                            "Le mot de passe ne doit pas etre vide",
                            Toast.LENGTH_LONG
                    ).show();
                } else {
                    login(matricule, password);
                }
            }
        });
    }

    private void login(String matricule, String password) {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.GONE);

        SharedPreferences session = getSharedPreferences("session",MODE_PRIVATE);
        SharedPreferences.Editor editor = session.edit();
        editor.putBoolean("session_active", false);

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}