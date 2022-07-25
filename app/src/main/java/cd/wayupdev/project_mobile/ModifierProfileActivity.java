package cd.wayupdev.project_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Locale;

public class ModifierProfileActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private String password = "19mm375";
    private EditText oldPassword;
    private EditText newPassword;
    private EditText confirmPassword;
    private Button modifier;
    private CheckBox checkBox;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profile);

        oldPassword = findViewById(R.id.oldPassword);
        newPassword = findViewById(R.id.newPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
        checkBox = findViewById(R.id.checkboxS);

        modifier = findViewById(R.id.buttonModifierPW);
        progressBar = findViewById(R.id.progress_bar);
        modifierPassword();

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldPassword.setInputType(0x00000001);
                newPassword.setInputType(0x00000001);
                confirmPassword.setInputType(0x00000001);
            }
        });
    }

    private void modifierPassword(){
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old, newP, conf;
                old = oldPassword.getText().toString();
                newP = newPassword.getText().toString();
                conf = confirmPassword.getText().toString();

                if (old.equals(password)){
                    if (newP.length() >= 6){
                        if (newP.equals(conf)) {
                            password = newP;
                            modifierMotPass();
                        }else
                            Toast.makeText(ModifierProfileActivity.this, "confirmation incorrete", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(ModifierProfileActivity.this, "le mot de passe doit avoir au moins 6 caractere", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(ModifierProfileActivity.this, "Ancien mot de passe incorrete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void modifierMotPass() {
        progressBar.setVisibility(View.VISIBLE);
        modifier.setEnabled(false);

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}