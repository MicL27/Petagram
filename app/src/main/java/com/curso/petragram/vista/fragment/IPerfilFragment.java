package com.curso.petragram.vista.fragment;

import com.curso.petragram.adapter.MascotaAdaptador;
import com.curso.petragram.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilFragment {

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public MascotaAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
