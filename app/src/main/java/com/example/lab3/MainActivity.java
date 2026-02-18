package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Références vers les champs
    private EditText nom, email, phone, adresse, ville;

    // Référence vers le bouton
    private Button btnEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lier les composants XML au Java
        nom = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        adresse = findViewById(R.id.adresse);
        ville = findViewById(R.id.ville);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        // Action du bouton Envoyer
        btnEnvoyer.setOnClickListener(v -> {

            // Récupérer les valeurs saisies
            String sNom = nom.getText().toString().trim();
            String sEmail = email.getText().toString().trim();
            String sPhone = phone.getText().toString().trim();
            String sAdresse = adresse.getText().toString().trim();
            String sVille = ville.getText().toString().trim();

            // Vérification simple : Nom et Email obligatoires
            if (sNom.isEmpty() || sEmail.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Nom et Email sont obligatoires.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Création de l’Intent vers Screen2Activity
            Intent in = new Intent(MainActivity.this, MainActivity2.class);

            // Envoi des données avec putExtra
            in.putExtra("nom", sNom);
            in.putExtra("email", sEmail);
            in.putExtra("phone", sPhone);
            in.putExtra("adresse", sAdresse);
            in.putExtra("ville", sVille);

            // Lancer l'écran 2
            startActivity(in);
        });
    }
}
