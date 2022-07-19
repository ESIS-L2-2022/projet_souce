package cd.wayupdev.project_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    }

    private void initialiserComposant(){
        editTextDescription = findViewById(R.id.etDescription);
        editTextPromotion = findViewById(R.id.etPromotion);
        editTextCategory = findViewById(R.id.etCategory);
        editTextDateTravail = findViewById(R.id.etDate);
        buttonAjouterPhoto = findViewById(R.id.btnAjotPhoto);
        buttonAjouterTravail = findViewById(R.id.btnAjoutModifier);
    }


}