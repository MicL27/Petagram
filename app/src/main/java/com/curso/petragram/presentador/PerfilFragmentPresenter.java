package com.curso.petragram.presentador;

import android.content.Context;

import com.curso.petragram.db.ConstructorMascotas;
import com.curso.petragram.pojo.Mascota;
import com.curso.petragram.vista.fragment.IPerfilFragment;
import com.curso.petragram.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IPefilFragmentPresenter {

    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public PerfilFragmentPresenter(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilFragment.inicializarAdaptadorRV(iPerfilFragment.crearMascotaAdaptador(mascotas));
        iPerfilFragment.generarGridLayout();

    }
}
