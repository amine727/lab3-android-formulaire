package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Récupération des composants du layout
        recap = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);

        // Récupérer l’Intent envoyé depuis MainActivity
        Intent intent = getIntent();

        // Extraire les données envoyées
        String nom = intent.getStringExtra("nom");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String adresse = intent.getStringExtra("adresse");
        String ville = intent.getStringExtra("ville");

        // Construire le texte à afficher
        String texte =
                "Nom : " + format(nom) + "\n" +
                        "Email : " + format(email) + "\n" +
                        "Phone : " + format(phone) + "\n" +
                        "Adresse : " + format(adresse) + "\n" +
                        "Ville : " + format(ville);

        // Afficher le résumé
        recap.setText(texte);

        // Bouton retour
        btnRetour.setOnClickListener(v -> finish());
    }

    // Méthode pour éviter les valeurs nulles ou vides
    private String format(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "—";
        }
        return value.trim();
    }
}
