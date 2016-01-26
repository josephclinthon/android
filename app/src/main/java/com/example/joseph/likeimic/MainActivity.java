package com.example.joseph.likeimic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private List<Fotografia> fotografias;
    private RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void mostrarMensajeLogin(View v) {
        final TextView texto = (TextView) findViewById(R.id.editText);
        final TextView texto2 = (TextView) findViewById(R.id.editText2);
        if (("" + texto2.getText()).equals("nose")) {
            Toast mensaje = Toast.makeText(getApplicationContext(), "Cargando Perfil de "
                    + texto.getText(), Toast.LENGTH_LONG);
            mensaje.show();

            Intent myIntent = new Intent(MainActivity.this, ContentActivity.class);
            myIntent.putExtra("key", texto.getText());
            MainActivity.this.startActivity(myIntent);
        }
    }


}
