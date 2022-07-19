package cd.wayupdev.project_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AjouterTravailActivity extends AppCompatActivity {

    private EditText editTextDescription;
    private EditText editTextPromotion;
    private EditText editTextCategory;
    private EditText editTextDateTravail;
    private Button buttonAjouterPhoto;
    private Button buttonAjouterTravail;
    private ProgressBar progressBar;
    private TextView tvNomsPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_travail);
        initialiserComposant();
        checkFieldConfirmation();
    }

    private void initialiserComposant(){
        editTextDescription = findViewById(R.id.etDescription);
        editTextPromotion = findViewById(R.id.etPromotion);
        editTextCategory = findViewById(R.id.etCategory);
        editTextDateTravail = findViewById(R.id.etDate);
        buttonAjouterPhoto = findViewById(R.id.btnAjotPhoto);
        buttonAjouterTravail = findViewById(R.id.btnAjoutModifier);
    }

    private void checkFieldConfirmation(){
        buttonAjouterTravail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = editTextDescription.getText().toString();
                String promotion = editTextPromotion.getText().toString();
                String category = editTextCategory.getText().toString();
                String date = editTextDateTravail.getText().toString();

                if (description.isEmpty()){
                    Toast.makeText(
                            AjouterTravailActivity.this,
                            "Le champ description ne doit pas etre vide",
                            Toast.LENGTH_LONG
                    ).show();
                }else if (promotion.isEmpty()){
                    Toast.makeText(
                            AjouterTravailActivity.this,
                            "Le champ promotion ne doit pas etre vide",
                            Toast.LENGTH_LONG
                    ).show();
                }else  if (category.isEmpty()){
                    Toast.makeText(
                            AjouterTravailActivity.this,
                            "Le champ category ne doit pas etre vide",
                            Toast.LENGTH_LONG
                    ).show();
                }else if (date.isEmpty()){
                    Toast.makeText(
                            AjouterTravailActivity.this,
                            "Le champ date ne doit pas etre vide",
                            Toast.LENGTH_LONG
                    ).show();
                }else {
                    goToHomePage();
                }

            }
        });
    }

    private void goToHomePage(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
}