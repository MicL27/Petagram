package com.curso.petragram.db;

import android.content.ContentValues;
import android.content.Context;

import com.curso.petragram.R;
import com.curso.petragram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Horus", R.drawable.cat1, 5));
        mascotas.add(new Mascota("Kima", R.drawable.cat2, 5));
        mascotas.add(new Mascota("Oreo", R.drawable.cat3, 5));
        mascotas.add(new Mascota("Kala", R.drawable.dog1, 2));
        mascotas.add(new Mascota("Lucas", R.drawable.dog2, 2));*/

        BaseDatos bd = new BaseDatos(context);
        insertarAlgunasMascotas(bd);
        return bd.obtenerTodasLasMascotas();
    }

    public void insertarAlgunasMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Horus");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.cat1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Kima");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.cat2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Oreo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.cat3);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Kala");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Lucas");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog2);

        db.insertarMascota(contentValues);
    }

    public void darRatingMascota(Mascota contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RATINGS_MASCOTA_ID_MASCOTA, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RATINGS_MASCOTA_NUMERO_RATINGS, contacto.getRating() + 1);
        db.insertarRatingMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRatingMascota(contacto);
    }

}
