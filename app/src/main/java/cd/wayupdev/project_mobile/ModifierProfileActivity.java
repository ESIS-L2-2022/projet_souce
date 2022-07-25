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

import cd.wayupdev.project_mobile.util.Common;

public class ModifierProfileActivity extends AppCompatActivity {

    private static final int IS_CHECK = 0x00000001;
    private static final int IS_NOT_CHECK = 0x00000081;

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
                if (checkBox.isChecked()){
                    oldPassword.setInputType(IS_CHECK);
                    newPassword.setInputType(IS_CHECK);
                    confirmPassword.setInputType(IS_CHECK);
                }else {
                    oldPassword.setInputType(IS_NOT_CHECK);
                    newPassword.setInputType(IS_NOT_CHECK);
                    confirmPassword.setInputType(IS_NOT_CHECK);
                }
            }
        });
    }

    private void modifierPassword(){
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fielverification();
            }
        });
    }

    public void fielverification(){
        String oldPword, newPword, confPassword;
        oldPword = oldPassword.getText().toString();
        newPword = newPassword.getText().toString();
        confPassword = confirmPassword.getText().toString();

        if (oldPword.equals(password)){
            if (newPword.length() >= 6){
                if (newPassword.equals(confPassword)) {
                    password = newPword;
                    modifierMotPass();
                }else
                    Common.myTost(this, "confirmation incorrete");
            }else
                Common.myTost(this, "le mot de passe doit avoir au moins 6 caractere");
        }else
            Common.myTost(this, "Ancien mot de passe incorrete");
    }

    private void modifierMotPass() {
        progressBar.setVisibility(View.VISIBLE);
        modifier.setEnabled(false);

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}