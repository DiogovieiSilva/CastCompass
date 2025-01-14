package com.example.castcompass;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.castcompass.listeners.ProdutoListener;
import com.example.castcompass.models.Produto;
import com.example.castcompass.models.Singleton;

public class DetalhesProdutosActivity extends AppCompatActivity implements ProdutoListener {

    public static final String IDPRODUTO = "id";

    private TextView tvNome, tvPreco, tvDescricao, tvStock;
    private ImageView imgCapa;
    private Produto produto;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produtos);

        tvNome = findViewById(R.id.tvNome);
        tvPreco = findViewById(R.id.tvPreco);
        tvStock = findViewById(R.id.tvStock);
        tvDescricao = findViewById(R.id.tvDescricao);
        imgCapa = findViewById(R.id.ivImage);


        Singleton.getInstance(this).setProdutoListener(this);
        produto = Singleton.getInstance(this).getProdutoAPI(this, getIntent().getIntExtra(IDPRODUTO, 0));
        if(produto != null){
            carregarDados();
        }
    }

    public void carregarDados(){

        tvNome.setText(produto.getNome());
        tvPreco.setText(produto.getPreco() + "€");
        tvStock.setText(produto.getStock() + " unidades");
        tvDescricao.setText(produto.getDescricao());
        // imgCapa.setImageResource(produto.getImagem());
    }

    @Override
    public void onRefreshProduto(Produto produto) {
        this.produto = produto;
        carregarDados();
    }

}