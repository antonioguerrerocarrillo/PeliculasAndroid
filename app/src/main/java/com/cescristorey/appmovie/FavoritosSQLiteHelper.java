package com.cescristorey.appmovie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class FavoritosSQLiteHelper extends SQLiteOpenHelper {

        //Sentencia SQL para crear la tabla de favoritos
        String sqlCreate = "CREATE TABLE Favoritos (codigo TEXT, nombre TEXT, foto TEXT, es_pelicula TEXT)";

        public FavoritosSQLiteHelper(Context contexto, String nombre,
                                     CursorFactory factory, int version) {
            super(contexto, nombre, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //Se ejecuta la sentencia SQL de creación de la tabla
            db.execSQL(sqlCreate);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {

        }
}
