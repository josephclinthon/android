package com.example.joseph.likeimic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import java.util.List;
import java.util.ArrayList;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String [] vec;
    int cont;
    int estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            RelativeLayout content = (RelativeLayout)findViewById(R.id.content);
            content.removeAllViews();

            View child = getLayoutInflater().inflate(R.layout.likeimi, null);
            content.addView(child);

        } else if (id == R.id.nav_gallery) {
            RelativeLayout content = (RelativeLayout)findViewById(R.id.content);
            content.removeAllViews();

            View child = getLayoutInflater().inflate(R.layout.fotos, null);
            content.addView(child);
            RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
            LinearLayoutManager linLayManager = new LinearLayoutManager(this);
            recycler.setLayoutManager(linLayManager);
            recycler.setHasFixedSize(true);
            List <Fotografia> fotografias = new ArrayList<>();
            fotografias.add(new Fotografia("Foto 1 de LiKeimi", R.drawable.likeimi_00));
            fotografias.add(new Fotografia("Foto 2 de LiKeimi", R.drawable.likeimi_01));
            fotografias.add(new Fotografia("Foto 3 de LiKeimi", R.drawable.likeimi_02));
            fotografias.add(new Fotografia("Foto 4 de LiKeimi", R.drawable.likeimi_03));
            fotografias.add(new Fotografia("Foto 5 de LiKeimi", R.drawable.likeimi_04));

            RecyclerAdaptador adapter = new RecyclerAdaptador(fotografias);
            recycler.setAdapter(adapter);

        } else if (id == R.id.nav_slideshow) {
            RelativeLayout content = (RelativeLayout)findViewById(R.id.content);
            content.removeAllViews();

            View child = getLayoutInflater().inflate(R.layout.contactenos, null);
            content.addView(child);

        } else if (id == R.id.nav_manage) {
            RelativeLayout content = (RelativeLayout)findViewById(R.id.content);
            content.removeAllViews();

            View child = getLayoutInflater().inflate(R.layout.ttt, null);
            content.addView(child);
            vec = new String[10];
            for (int i=1;i<10;i++){
                vec[i]=" ";
            }
            cont=1;
            estado = 0;

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //JUEGO DE TRES EN RAYA
    public String mvec(int n){
        String str ="O";
        if(cont%2==0){
            str = "X";
        }
        vec[n]=str;
        cont++;
        int num=ganador();
        if(num!=0){
            TextView f11 = (TextView)findViewById(R.id.mensaje);
            if(num==1){
                f11.setText("GANO LOS X");
            }else{
                f11.setText("GANO LOS O");
            }
            estado=1;
        }
        if(cont==9){
            TextView f11 = (TextView)findViewById(R.id.mensaje);
            f11.setText("EMPATE");
        }
        Log.d("TTT",vec[7]+"|"+vec[8]+"|"+vec[9]);
        Log.d("TTT",vec[4]+"|"+vec[5]+"|"+vec[6]);
        Log.d("TTT",vec[1]+"|"+vec[2]+"|"+vec[3]);
        Log.d("---","___");
        return str;
    }
    public int ganador(){
        String s ="X";
        int num=0;
        if((vec[1].equals(s)&&vec[2].equals(s)&&vec[3].equals(s))||
                (vec[4].equals(s)&&vec[5].equals(s)&&vec[6].equals(s))||
                (vec[7].equals(s)&&vec[8].equals(s)&&vec[9].equals(s))||
                (vec[1].equals(s)&&vec[4].equals(s)&&vec[7].equals(s))||
                (vec[2].equals(s)&&vec[5].equals(s)&&vec[8].equals(s))||
                (vec[3].equals(s)&&vec[6].equals(s)&&vec[9].equals(s))||
                (vec[7].equals(s)&&vec[5].equals(s)&&vec[3].equals(s))||
                (vec[1].equals(s)&&vec[5].equals(s)&&vec[9].equals(s))){
            num=1;
        }
        s="O";
        if((vec[1].equals(s)&&vec[2].equals(s)&&vec[3].equals(s))||
                (vec[4].equals(s)&&vec[5].equals(s)&&vec[6].equals(s))||
                (vec[7].equals(s)&&vec[8].equals(s)&&vec[9].equals(s))||
                (vec[1].equals(s)&&vec[4].equals(s)&&vec[7].equals(s))||
                (vec[2].equals(s)&&vec[5].equals(s)&&vec[8].equals(s))||
                (vec[3].equals(s)&&vec[6].equals(s)&&vec[9].equals(s))||
                (vec[7].equals(s)&&vec[5].equals(s)&&vec[3].equals(s))||
                (vec[1].equals(s)&&vec[5].equals(s)&&vec[9].equals(s))){
            num=2;
        }
        return num;
    }
    public void jugar(View v){
        TextView f11 = (TextView) findViewById(R.id.f11);
        f11.setText(" ");
        TextView f12 = (TextView) findViewById(R.id.f12);
        f12.setText(" ");
        TextView f13 = (TextView) findViewById(R.id.f13);
        f13.setText(" ");

        TextView f21 = (TextView) findViewById(R.id.f21);
        f21.setText(" ");
        TextView f22 = (TextView) findViewById(R.id.f22);
        f22.setText(" ");
        TextView f23 = (TextView) findViewById(R.id.f23);
        f23.setText(" ");

        TextView f31 = (TextView) findViewById(R.id.f31);
        f31.setText(" ");
        TextView f32 = (TextView) findViewById(R.id.f32);
        f32.setText(" ");
        TextView f33 = (TextView) findViewById(R.id.f33);
        f33.setText(" ");

        estado =0;
        cont=1;
        for (int i=1;i<10;i++){
            vec[i]=" ";
        }
    }
    //--marcar
    public void m11(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f11);
            f11.setText(mvec(7));
        }
    }
    public void m12(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f12);
            f11.setText(mvec(8));
        }
    }
    public void m13(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f13);
            f11.setText(mvec(9));
        }
    }
    public void m21(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f21);
            f11.setText(mvec(4));
        }
    }
    public void m22(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f22);
            f11.setText(mvec(5));
        }
    }public void m23(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f23);
            f11.setText(mvec(6));
        }
    }
    public void m31(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f31);
            f11.setText(mvec(1));
        }
    }
    public void m32(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f32);
            f11.setText(mvec(2));
        }
    }public void m33(View v){
        if(cont<10&&estado==0) {
            TextView f11 = (TextView) findViewById(R.id.f33);
            f11.setText(mvec(3));
        }
    }





}
