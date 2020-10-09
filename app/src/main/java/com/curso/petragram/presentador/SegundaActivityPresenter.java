package com.curso.petragram.presentador;

import android.content.Context;

import com.curso.petragram.db.ConstructorMascotas;
import com.curso.petragram.pojo.Mascota;
import com.curso.petragram.vista.fragment.IRecyclerViewFragmentView;
import com.curso.petragram.vista.fragment.ISegundaActivity;

import java.util.ArrayList;

public class SegundaActivityPresenter implements ISegundaActivityPresenter {

    private ISegundaActivity iSegundaActivity;
    private Context context;
    private ConstructorMascotas constructorMascotas;

    private ArrayList<Mascota> mascotas;

    public SegundaActivityPresenter(ISegundaActivity iSegundaActivity, Context context) {
        this.iSegundaActivity = iSegundaActivity;
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
        iSegundaActivity.inicializarAdaptadorRV(iSegundaActivity.crearMascotaAdaptador(mascotas));
        iSegundaActivity.generarLinearLayoutVertical();

    }
}
