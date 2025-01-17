package com.example.castcompass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.castcompass.listeners.UtilizadorListener;
import com.example.castcompass.models.Singleton;
import com.example.castcompass.models.Utilizador;

public class PerfilActivity extends AppCompatActivity implements UtilizadorListener {
    private EditText etUsername, etEmail, etDataNascimento, etNome, etNumero, etMorada, etNif, etGenero;
    private Button btnGuardarPerfil, btnApagarPerfil;
    private Utilizador utilizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        setTitle("Perfil");

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etDataNascimento = findViewById(R.id.etDataNascimento);
        etNome = findViewById(R.id.etNome);
        etNumero = findViewById(R.id.etTelemovel);
        etMorada = findViewById(R.id.etMorada);
        etNif = findViewById(R.id.etNif);
        etGenero = findViewById(R.id.etGenero);
        btnGuardarPerfil = findViewById(R.id.btnGuardarPerfil);
        btnApagarPerfil = findViewById(R.id.btnApagarPerfil);

        // Carregar os dados do utilizador
        Singleton.getInstance(this).setUtilizadorListener(this);
        Singleton.getInstance(this).getUtilizadorAPI(this);

        if (utilizador != null) {
            carregarDados();
        }
    }

    private void carregarDados() {
        etUsername.setText(utilizador.getUsername());
        etEmail.setText(utilizador.getEmail());
        etDataNascimento.setText(utilizador.getDataNascimento());
        etNome.setText(utilizador.getNome());
        etNumero.setText(utilizador.getTelemovel());
        etMorada.setText(utilizador.getMorada());
        etNif.setText(utilizador.getNif());
        etGenero.setText(utilizador.getGenero());
    }

    public void onClickEditarPerfil(View view) {
        if (btnGuardarPerfil.getText().equals("Editar Perfil")) {
            etNome.setEnabled(true);
            etNumero.setEnabled(true);
            etMorada.setEnabled(true);
            etNif.setEnabled(true);
            btnGuardarPerfil.setText("Guardar Perfil");
        } else {
            etNome.setEnabled(false);
            etNumero.setEnabled(false);
            etMorada.setEnabled(false);
            etNif.setEnabled(false);

            // Guardar as alterações
            Singleton.getInstance(this).setUtilizadorListener(this);
            Singleton.getInstance(this).atualizarUtilizadorAPI(this, etNome.getText().toString(), etNumero.getText().toString(), etMorada.getText().toString(), etNif.getText().toString());


            btnGuardarPerfil.setText("Editar Perfil");
        }
    }

    public void onClickApagarPerfil(View view) {
        Singleton.getInstance(this).setUtilizadorListener(this);
        Singleton.getInstance(this).apagarUtilizadorAPI(this);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRefreshUtilziador(Utilizador utilizador) {
       this.utilizador = utilizador;
       carregarDados();
    }
}