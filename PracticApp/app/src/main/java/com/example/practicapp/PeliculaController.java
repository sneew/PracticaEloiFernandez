package com.example.practicapp;

import android.content.Context;

import androidx.room.Room;

import com.example.practicapp.database.PeliculaDao;
import com.example.practicapp.database.PeliculaDatabase;
import com.example.practicapp.model.Pelicula;

import java.util.List;

public class PeliculaController {

    private static PeliculaController sPeliculaLab;

    private PeliculaDao peliculaDao;

    private PeliculaController(Context context){
        Context appContext = context.getApplicationContext();
        PeliculaDatabase database = Room.databaseBuilder(appContext, PeliculaDatabase.class, "persona").allowMainThreadQueries().build();
        peliculaDao = database.getPeliculaDao();
    }

    public static PeliculaController get(Context context){
        if (sPeliculaLab == null){
            sPeliculaLab = new PeliculaController(context);
        }
        return sPeliculaLab;
    }

    public List<Pelicula> getPelicules(){
        return peliculaDao.getPelicules();
    }

    public Pelicula getPelicula(String id){
        return peliculaDao.getPelicula(id);
    }

    public void addPelicula(Pelicula persona){
        peliculaDao.addPelicula(persona);
    }

    public void updatePelicula(Pelicula persona){ peliculaDao.updatePelicula(persona);
    }

    public void deletePelicula(Pelicula persona){
        peliculaDao.deletePelicula(persona);
    }
}
