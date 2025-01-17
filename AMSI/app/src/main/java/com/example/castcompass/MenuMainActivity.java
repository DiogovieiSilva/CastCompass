package com.example.castcompass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.castcompass.models.Singleton;
import com.google.android.material.navigation.NavigationView;

public class MenuMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private FragmentManager fragmentManager;
    private String username = "Sem Username!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.ndOpen, R.string.ndClose);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

        carregarCabecalho(); //TODO:criar método
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        carregarFragmentoInicial();
    }

    private boolean carregarFragmentoInicial() {
        Menu menu = navigationView.getMenu();
        MenuItem item = menu.getItem(0);
        item.setChecked(true);
        return onNavigationItemSelected(item);
    }

    private void carregarCabecalho() {
        username = getIntent().getStringExtra(LoginActivity.USER);
        SharedPreferences sharedPrefUser = getSharedPreferences("DADOS_USER", Context.MODE_PRIVATE);

        if (username != null) {
            SharedPreferences.Editor editor = sharedPrefUser.edit();
            editor.putString("USERNAME", username);
            editor.apply();
        } else {
            username = sharedPrefUser.getString("USERNAME", "Sem Username!");
        }

        View headerView = navigationView.getHeaderView(0);
        TextView nav_tvUsername = headerView.findViewById(R.id.tvUsername);
        nav_tvUsername.setText(username);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.navHome) {
            fragment = new ListaProdutosFragment();
            setTitle(item.getTitle());
        } else if (item.getItemId() == R.id.navCarrinho) {
            setTitle(item.getTitle());
        }else if (item.getItemId() == R.id.navFavoritos) {
            // Singleton.getInstance(getApplicationContext()).favoritoBD.getAllFavoritos();
            fragment = new ListaFavoritosFragment();
            setTitle(item.getTitle());
        }else if (item.getItemId() == R.id.navMensagens) {
            setTitle(item.getTitle());
        }
        else {
            enviarEmail();
        }

        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.contentFragment, fragment).commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void enviarEmail() {
        //TODO: intent implicito ACTION_SEND
    }


}