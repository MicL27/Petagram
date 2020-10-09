package com.curso.petragram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.curso.petragram.adapter.MascotaAdaptador;
import com.curso.petragram.pojo.Mascota;
import com.curso.petragram.presentador.ISegundaActivityPresenter;
import com.curso.petragram.presentador.RecyclerViewFragmentPresenter;
import com.curso.petragram.presentador.SegundaActivityPresenter;
import com.curso.petragram.vista.fragment.ISegundaActivity;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity implements ISegundaActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ISegundaActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        presenter = new SegundaActivityPresenter(this, getApplicationContext());


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getApplicationContext(), 2);
        listaMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}